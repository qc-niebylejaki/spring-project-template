package pl.qc.spring.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.qc.spring.rest.dto.BookItem;
import pl.qc.spring.rest.service.BookstoreService;

import java.util.List;

@RestController
@RequestMapping("/rest/bookstore/books")
@RequiredArgsConstructor
public class BookstoreController {

    private final BookstoreService bookstoreService;

    @GetMapping
    public List<BookItem> getBooks() {
        return bookstoreService.findAll();
    }

    @GetMapping("/{id}")
    public BookItem getBook(@PathVariable Long id) {
        return bookstoreService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    @PostMapping
    public BookItem createBook(@RequestBody BookItem book) {
        return bookstoreService.addBook(book);
    }

    @PutMapping
    public BookItem updateBook(@RequestBody BookItem book) {
        return bookstoreService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookstoreService.removeBook(id);
    }
}
