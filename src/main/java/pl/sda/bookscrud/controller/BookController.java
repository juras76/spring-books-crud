package pl.sda.bookscrud.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sda.bookscrud.domain.dto.BookMinDTO;
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
}
