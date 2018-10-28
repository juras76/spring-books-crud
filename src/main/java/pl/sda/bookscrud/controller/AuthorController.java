package pl.sda.bookscrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sda.bookscrud.domain.dto.AuthorDTO;
import pl.sda.bookscrud.domain.dto.AuthorMinDTO;
import pl.sda.bookscrud.domain.dto.IdDTO;
import pl.sda.bookscrud.service.AuthorService;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<AuthorMinDTO> list() {
        return authorService.list();
    }

    @PutMapping("/create")
    @ResponseBody
    public IdDTO create(@RequestBody AuthorDTO dto) {
        return authorService.create(dto);
    }
    @GetMapping("/get/{id}")
    @ResponseBody
    public AuthorDTO get(@PathVariable("id")Long id){
        return authorService.getAuthor(id);

    }

}
