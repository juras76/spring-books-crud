package pl.sda.bookscrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bookscrud.domain.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByAliveTrue();
}
