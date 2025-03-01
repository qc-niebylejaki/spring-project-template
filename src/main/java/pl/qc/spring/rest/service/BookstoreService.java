package pl.qc.spring.rest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.qc.spring.rest.dto.BookItem;
import pl.qc.spring.rest.model.Book;
import pl.qc.spring.rest.repository.BookstoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookstoreService {

    private final BookMapper bookMapper;
    private final BookstoreRepository bookstoreRepository;

    public List<BookItem> findAll() {
        log.info("Finding all books");
        return bookstoreRepository.findAll()
                .stream().map(bookMapper::bookToBookItem)
                .toList();
    }

    public Optional<BookItem> findById(Long id) {
        log.info("Finding book by id: {}", id);
        return bookstoreRepository.findById(id)
                .map(bookMapper::bookToBookItem)
                .or(Optional::empty);
    }

    public BookItem addBook(BookItem bookItem) {
        log.info("Adding book: {}", bookItem);
        Book book = bookMapper.bookDtoToBook(bookItem);
        bookstoreRepository.save(book);
        return bookItem;
    }


    public BookItem updateBook(BookItem bookItem) {
        log.info("Updating book: {}", bookItem);
        Book book = bookMapper.bookDtoToBook(bookItem);
        bookstoreRepository.save(book);
        return bookItem;
    }

    public void removeBook(Long id) {
        log.info("Removing book: {}", id);
        bookstoreRepository.deleteById(id);
    }
}
