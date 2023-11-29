package controllers;

import models.BookChangeStatusDto;
import models.BookDto;
import org.springframework.web.bind.annotation.*;
import services.BookService;

import java.util.List;

@RestController
@RequestMapping("api/books")
@CrossOrigin(origins = "*")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable long id) {
        return bookService.getById(id);
    }

    @PostMapping
    public void addBook(@RequestBody BookDto bookDto) {
        bookService.add(bookDto);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable long id, @RequestBody BookDto bookDto) {
        bookService.update(id, bookDto);
    }

    @PatchMapping("/{id}")
    public void updateBookStatus(@PathVariable long id, @RequestBody BookChangeStatusDto bookDto) {
        bookService.changeStatus(id, bookDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable long id) {
        bookService.deleteById(id);
    }
}