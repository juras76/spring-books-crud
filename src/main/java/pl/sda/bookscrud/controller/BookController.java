package pl.sda.bookscrud.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sda.bookscrud.domain.dto.BookDTO;
import pl.sda.bookscrud.domain.dto.BookMinDTO;
import pl.sda.bookscrud.domain.dto.IdDTO;
import pl.sda.bookscrud.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<BookMinDTO> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public BookDTO get(@PathVariable("id") Long id) {
        return bookService.getBook(id);
    }

    @PutMapping("/create")
    @ResponseBody
    public IdDTO create(@RequestBody BookDTO dto) {
        return bookService.create(dto);
    }
}
