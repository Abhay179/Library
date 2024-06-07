package project.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorRepository Arepo;

    @Autowired
    BookRepository Brepo;

    @PostMapping
        public Boolean create(@RequestBody AuthorEntity data){
        Arepo.save(data);
        System.out.println(data.getName());
        return  true;
    }

    @GetMapping
    public List<AuthorEntity> getAll(){
        return Arepo.findAll();
    }
    @GetMapping("id/{myid}")
    public AuthorEntity getAuthorById(@PathVariable String myid){
        return Arepo.findById(myid).orElse(null);
    }

    @GetMapping("/{name}")
    public AuthorEntity getByName(@PathVariable String name){
        return Arepo.findByName(name);
    }
    @DeleteMapping("id/{myid}")
    public boolean delById(@PathVariable String myid){
        Arepo.deleteById(myid);
        return  true;
    }

    @PutMapping("id/{myid}")
    public boolean update(@PathVariable String myid , @RequestBody AuthorEntity author){
        AuthorEntity old=Arepo.findById(myid).orElse(null);
//        BookEntity book=Brepo.findByAuthorname(author.getName());
        if(old!=null){
            old.setAge(author.getAge());
        }
//        book.getAboutAuthor().add(old);
        Arepo.save(old);
        return true;

    }
}
