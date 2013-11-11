package lu.lv.keriss.testapp.services;

import lu.lv.keriss.testapp.model.Book;

import java.util.List;

public interface IBookDao {
    List<Book> getAll();
    List<Book> getFree(List<Long> usersBooks);
    void updateBook(Book book);
    void deleteBook(Long id);
    void addBook(Book book);
    Book findBookById(Long id);
    void updateBusy(List<Long> bookIds,boolean setUnset);
}
