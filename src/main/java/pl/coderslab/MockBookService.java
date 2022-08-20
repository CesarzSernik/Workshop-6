package pl.coderslab;

import org.springframework.stereotype.Component;
import pl.coderslab.controllers.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MockBookService {

    private final List<Book> list;

    public Long getNextId() {
        return nextId;
    }

    public static void setNextId() {
        MockBookService.nextId = nextId + 1;
    }

    private static Long nextId = 4L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion", "programming"));
    }


    public List<Book> getList() {
        return this.list;
    }

    public Book getBook(Long id) {
        for (Book book : list) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void addToList(Book book) {
        list.add(book);
    }

    public void editBook(Book book) {
        Book editedBook = getBook(book.getId());
        list.remove(editedBook);
        editedBook.setIsbn(book.getIsbn());
        editedBook.setTitle(book.getTitle());
        editedBook.setAuthor(book.getAuthor());
        editedBook.setPublisher(book.getPublisher());
        editedBook.setType(book.getType());
        list.add(editedBook);
    }

    public void removeBook(Long id){
        Book bookToBurn = getBook(id);
        list.remove(bookToBurn);
    }
}
