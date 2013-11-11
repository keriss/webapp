package lu.lv.keriss.testapp.services;

import lu.lv.keriss.testapp.model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BookDao implements IBookDao {
    private TreeMap<Long, Book> books = new TreeMap<Long,Book>();
    private AtomicLong sequence = new AtomicLong(0);
    private int maxBooks = 20;

    public BookDao() {
        init();
    }

    private void init(){
        for(int i=1;i<=maxBooks;i++){
            addBook(new Book("book_" + i));
        }
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<Book>(books.values());
    }

    @Override
    public List<Book> getFree(List<Long> usersBooks) {
        if(usersBooks == null){
            usersBooks = new ArrayList<Long>();
        }
        TreeMap<Long,Book> freeBooks= new TreeMap<Long,Book>();
        Set<Long> keys = books.keySet();
        Iterator<Long> iKey = keys.iterator();
        while(iKey.hasNext()){
            Long key = iKey.next();
            if(!(books.get(key)).getIsBusy() || usersBooks.contains(key)){
                freeBooks.put(key,books.get(key));
            }
        }
        return new ArrayList<Book>(freeBooks.values());
    }

    @Override
    public void updateBook(Book book) {
        if(books.get(book.getId())!=null){
            books.put(book.getId(), book);
        }else{
            addBook(book);
        }
    }

    @Override
    public void deleteBook(Long id) {
        books.remove(id);
    }

    @Override
    public void addBook(Book book) {
        if (book.getId() == null) {
            book.setId(sequence.getAndIncrement());
        }
        books.put(book.getId(), book);
    }

    @Override
    public Book findBookById(Long id) {
        return books.get(id);
    }

    @Override
    public void updateBusy(List<Long> bookIds, boolean setUnset){
        if(bookIds!=null && bookIds.size()>0){
            Iterator<Long> biter = bookIds.iterator();
            while(biter.hasNext()){
                Long key = biter.next();
                books.get(key).setIsBusy(setUnset);
            }
        }
    }
}
