package project.library;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("book")
@Getter
@Setter
public class BookEntity {
    @Id
    private String bookid;
    private String authid;
    private String title;
    private String author;
    @DBRef
    private ArrayList<AuthorEntity> aboutauthor=new ArrayList<>();
    private status status;

}
