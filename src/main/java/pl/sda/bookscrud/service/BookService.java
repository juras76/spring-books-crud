package pl.sda.bookscrud.service;

import org.springframework.stereotype.Service;
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


}
