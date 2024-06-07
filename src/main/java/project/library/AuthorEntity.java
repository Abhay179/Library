package project.library;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Document("Author")
public class AuthorEntity {
    @Id
    private String id;
    private  String name;
    private LocalDate dob;
    private int age;
    private String nationality;
    private String gender;

}
