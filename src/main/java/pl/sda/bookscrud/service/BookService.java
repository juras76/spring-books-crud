package pl.sda.bookscrud.service;

import org.springframework.stereotype.Service;
import pl.sda.bookscrud.domain.dto.AuthorMinDTO;
import pl.sda.bookscrud.domain.dto.BookDTO;
import pl.sda.bookscrud.domain.dto.BookMinDTO;
import pl.sda.bookscrud.domain.entity.Book;
import pl.sda.bookscrud.repository.BookRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BookService {

    static final Function<Book, BookMinDTO> BOOK_BOOK_MIN_DTO_FUNCTION = b -> new BookMinDTO(b.getId(), b.getTitle());
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookMinDTO> getAll() {
        return bookRepository.findAll().stream()
                .map(BOOK_BOOK_MIN_DTO_FUNCTION)
                .collect(Collectors.toList());
    }
    public BookDTO getBook(Long id){
        Book book=bookRepository.findById(id).orElse(null));
        if (book == null) {
            return null;
        }
        BookDTO dto=new BookDTO();
        dto.setId(book.getId());
        AuthorMinDTO authorMinDTO=new AuthorMinDTO();
        authorMinDTO.setId(book.getAuthor().getId());
        authorMinDTO.setFirstName(book.getAuthor().getFirstName());
        authorMinDTO.setLastName(book.getAuthor().getLastName());
        dto.setAuthor(authorMinDTO);
        dto.setCover(book.getCover());
        dto.setGenre(book.getGenre());
        dto.setLanguage(book.getLanguage());
        dto.setPrice(book.getPrice());
        dto.setPublishYear(book.getPublishYear());
        return dto;

    }


}
