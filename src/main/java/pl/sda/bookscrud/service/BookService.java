package pl.sda.bookscrud.service;

import org.springframework.stereotype.Service;
import pl.sda.bookscrud.domain.dto.BookMinDTO;
import pl.sda.bookscrud.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookMinDTO> getAll() {
        return bookRepository.findAll().stream()
                .map(b -> new BookMinDTO(b.getId(), b.getTitle()))
                .collect(Collectors.toList());
    }
}
