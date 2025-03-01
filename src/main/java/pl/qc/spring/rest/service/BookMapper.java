package pl.qc.spring.rest.service;

import org.mapstruct.Mapper;
import pl.qc.spring.rest.dto.BookItem;
import pl.qc.spring.rest.model.Book;

@Mapper
public interface BookMapper {
    BookItem bookToBookItem(Book book);
    Book bookDtoToBook(BookItem bookDto);
}
