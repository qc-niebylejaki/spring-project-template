package pl.qc.spring.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.qc.spring.rest.model.Book;

@Repository
public interface BookstoreRepository extends JpaRepository<Book, Long> {
}
