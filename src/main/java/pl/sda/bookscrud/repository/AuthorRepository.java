package pl.sda.bookscrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bookscrud.domain.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
