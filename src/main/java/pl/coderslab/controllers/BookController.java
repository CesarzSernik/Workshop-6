package pl.coderslab.controllers;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @RequestMapping(value = "/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
    }

    private final MockBookService mockBookService = new MockBookService();

    @GetMapping("")
    @ResponseBody
    public List<Book> BookList() {
        return mockBookService.getList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable Long id){
        return mockBookService.getBook(id);
    }

    @PostMapping("")
    public void createBook(@RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type){
Book newBook = new Book(mockBookService.getNextId(),isbn,title,author,publisher,type);
mockBookService.addToList(newBook);
mockBookService.setNextId();
    }

    @PutMapping("/{id}")
    public void editBook(@PathVariable Long id, @RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type){
Book replacementBook = new Book(id,isbn,title,author,publisher,type);
mockBookService.editBook(replacementBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        mockBookService.removeBook(id);
    }
}
