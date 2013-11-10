package lu.lv.keriss.testapp.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

public class User {
    @Id
    private Long id;
    @NotEmpty
    @Size(min = 1, max = 20)
    private String name;
    @Min(1)
    @Max(100)
    private int age;
    private boolean active;
    private List<Long> books;

    public User() {
    }

    public User(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Long> getBooks() {
        return books;
    }

    public void setBooks(List<Long> books) {
        this.books = books;
    }

    public void addBook(Long bookId) {
        this.books.add(bookId);
    }

    public void addBooks(List<Long> bookIds) {
        this.books.addAll(bookIds);
    }
}