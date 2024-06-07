package project.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookRepository Brepo;
    @Autowired
    AuthorRepository Arepo;


    @GetMapping
    public List<BookEntity> getAll(){
        return Brepo.findAll();
    }
    @GetMapping("/id/{myid}")//GET ALL THE BOKS
    public BookEntity getById(@PathVariable String myid){
        return Brepo.findById(myid).orElse(null);
    }
    @GetMapping("{author}")//GET ALL BOOKS BY AUTHOR
    public List<BookEntity> getByAuthor(@PathVariable String author){
        return Brepo.findBooksByAuthor(author);
    }
    @GetMapping("{author}/{id}")//GET A SINGLE BOOK BY AUTHOR
    public BookEntity getByAuthor(@PathVariable String author, @PathVariable int id){
        return Brepo.findBooksByAuthor(author).get(id);
    }


    @PostMapping//CREATING A BOOK
    public Boolean create(@RequestBody BookEntity data){
        AuthorEntity author=Arepo.findByName(data.getAuthor());
        data.getAboutauthor().add(author);
        Brepo.save(data);
        return  true;
    }

    @DeleteMapping("/id/{myid}")
    public  boolean delete(@PathVariable String id){
        Brepo.deleteById(id);
        return true;
    }
//    @PutMapping("id/{myid}")//NORMAL UPDATE
//    public boolean update(@PathVariable String id ,@RequestBody BookEntity data){
//        BookEntity old=Brepo.findById(id).orElse(null);
//        old.setStatus(data.getStatus());
//        Brepo.save(old);
//        return  true;
//    }
    @PutMapping("{bookid}/author/{authid}")
    public boolean update(@PathVariable String bookid ,@PathVariable String authid ,@RequestBody BookEntity data){
        BookEntity book=Brepo.findById(bookid).orElse(null);
        String id=book.getAuthid();
        if(book !=null){
            if(book.getAuthid().equals(authid)){
                book.setTitle(data.getTitle());
                Brepo.save(book);
                return true;
            }
            else{
                return false;
            }
        }
            return false;
    }





}
