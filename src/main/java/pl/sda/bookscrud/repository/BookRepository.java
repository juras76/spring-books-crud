package pl.sda.bookscrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bookscrud.domain.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
