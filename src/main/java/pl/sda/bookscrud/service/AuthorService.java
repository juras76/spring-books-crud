package pl.sda.bookscrud.service;

import org.springframework.stereotype.Service;
import pl.sda.bookscrud.domain.dto.AuthorDTO;
import pl.sda.bookscrud.domain.dto.AuthorMinDTO;
import pl.sda.bookscrud.domain.dto.IdDTO;
import pl.sda.bookscrud.domain.entity.Author;
import pl.sda.bookscrud.repository.AuthorRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    static final Function<Author, AuthorMinDTO> AUTHOR_AUTHOR_MIN_DTO_FUNCTION = a -> new AuthorMinDTO(a.getId(), a.getFirstName(), a.getLastName());
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorMinDTO> list() {
        return authorRepository.findAll().stream()
                .map(a -> new AuthorMinDTO(a.getId(), a.getFirstName(), a.getLastName()))
                .collect(Collectors.toList());
    }

    public IdDTO create(AuthorDTO dto) {
        Author a = mapDtoToAuthor(dto);
        a = authorRepository.save(a);
        return new IdDTO(a.getId());
    }

    private Author mapDtoToAuthor(AuthorDTO dto) {
        Author a = new Author();
        a.setFirstName(dto.getFirstName());
        a.setLastName(dto.getLastName());
        a.setGender(dto.getGender());
        a.setAlive(dto.getAlive());
        return a;
    }

    public AuthorDTO getAuthor(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) {
            return null;
        }
        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setFirstName(author.getFirstName());
        dto.setLastName(author.getLastName());
        dto.setAlive(author.getAlive());
        dto.setGender(author.getGender());
        dto.setBooks(author.getBooks()
                .stream()
                .map(BookService.BOOK_BOOK_MIN_DTO_FUNCTION)
                .collect(Collectors.toList()));

        return dto;
    }

    public List<AuthorMinDTO> aliveAuthors(){
        return authorRepository.findByAliveTrue()
            .stream()
            .map(AUTHOR_AUTHOR_MIN_DTO_FUNCTION)
            .collect(Collectors.toList());


    }
}
