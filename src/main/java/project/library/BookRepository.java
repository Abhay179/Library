package project.library;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<BookEntity , String> {
//    BookEntity findByAuthorName(String author);
    List<BookEntity> findBooksByAuthor  (String author);
    BookEntity findByAuthor (String author);
}
