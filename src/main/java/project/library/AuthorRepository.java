package project.library;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<AuthorEntity, String> {
    AuthorEntity findByName(String name);
}
