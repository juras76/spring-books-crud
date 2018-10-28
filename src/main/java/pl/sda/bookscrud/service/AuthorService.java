package pl.sda.bookscrud.service;

import org.springframework.stereotype.Service;
import pl.sda.bookscrud.domain.dto.AuthorDTO;
import pl.sda.bookscrud.domain.dto.AuthorMinDTO;
import pl.sda.bookscrud.domain.dto.IdDTO;
import pl.sda.bookscrud.domain.entity.Author;
import pl.sda.bookscrud.repository.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

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
}
