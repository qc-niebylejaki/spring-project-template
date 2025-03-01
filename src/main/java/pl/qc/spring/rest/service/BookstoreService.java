package pl.qc.spring.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.qc.spring.rest.dto.BookItem;
import pl.qc.spring.rest.model.Book;
import pl.qc.spring.rest.repository.BookstoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookstoreService {

    private final BookMapper bookMapper;
    private final BookstoreRepository bookstoreRepository;

    public List<BookItem> findAll() {
        return bookstoreRepository.findAll()
                .stream().map(bookMapper::bookToBookItem)
                .toList();
    }

    public Optional<BookItem> findById(Long id) {
        return bookstoreRepository.findById(id)
                .map(bookMapper::bookToBookItem)
                .or(Optional::empty);
    }

    public BookItem addBook(BookItem bookItem) {
        Book book = bookMapper.bookDtoToBook(bookItem);
        bookstoreRepository.save(book);
        return bookItem;
    }


    public BookItem updateBook(BookItem bookItem) {
        Book book = bookMapper.bookDtoToBook(bookItem);
        bookstoreRepository.save(book);
        return bookItem;
    }

    public void removeBook(Long id) {
        bookstoreRepository.deleteById(id);
    }
}
