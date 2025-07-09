package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Copy;
import org.softwire.training.bookish.models.database.Technology;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibraryService extends DatabaseService {

    public List<Book> getAllBooks(String sort) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM bookish.books ORDER BY "+sort)
                        .mapToBean(Book.class)
                        .list());
    }

    public List<Copy> getCopies(int bookId) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM bookish.copies WHERE BookID = "+bookId)
                        .mapToBean(Copy.class)
                        .list());
    }

    public List<Book> getAllCopies() {
        List<Map<String,Object>> rows = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM bookish.books b JOIN bookish.copies c ON b.BookID = c.BookID LEFT JOIN bookish.members m ON c.MemberID = m.MemberID")
                        .mapToMap()
                        .list());
        Map<Integer, Book> bookMap = new HashMap<>();
        for (Map<String,Object> row : rows) {
            int bookID = (int) row.get("bookid");
            Book book = bookMap.computeIfAbsent(bookID, id -> {
                Book newBook = new Book();
                newBook.setBookID(bookID);
                newBook.setTitle((String) row.get("title"));
                newBook.setAuthor((String) row.get("author"));
                newBook.setISBN((String) row.get("isbn"));
                newBook.setEdition((String) row.get("edition"));
                newBook.setPublisher((String) row.get("publisher"));
                newBook.setCopies(new ArrayList<>());
                return newBook;
            });

            Copy copy = new Copy();
            copy.setCopyID((int) row.get("copyid"));
            copy.setBookID(bookID);
            copy.setStatus((String) row.get("status"));
            copy.setMemberID((Integer) row.get("memberid"));
            copy.setDueBack((Date) row.get("dueback"));
            copy.setMemberName((String) row.get("name"));

            book.getCopies().add(copy);
        }

        return new ArrayList<>(bookMap.values());
    }

    public void addTechnology(Technology technology) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO technologies (name, logoUrl) VALUES (:name, :logoUrl)")
                        .bind("name", technology.getName())
                        .bind("logoUrl", technology.getLogoUrl())
                        .execute()
        );
    }

    public void deleteTechnology(int technologyId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM technologies WHERE id = :id")
                        .bind("id", technologyId)
                        .execute()
        );
    }
}
