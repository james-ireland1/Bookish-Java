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
                handle.createQuery("SELECT * FROM bookish.books b JOIN bookish.copies c ON b.BookID = c.BookID")
                        .mapToMap()
                        .list());
        Map<Integer, Book> bookMap = new HashMap<>();
        for (Map<String,Object> row : rows) {
            int bookID = (int) row.get("BookID");
            Book book = bookMap.computeIfAbsent(bookID, id -> {
                Book newBook = new Book();
                newBook.setBookID(bookID);
                newBook.setTitle((String) row.get("Title"));
                newBook.setAuthor((String) row.get("Author"));
                newBook.setISBN((String) row.get("ISBN"));
                newBook.setEdition((String) row.get("Edition"));
                newBook.setPublisher((String) row.get("Publisher"));
                return newBook;
            });

            Copy copy = new Copy();
            copy.setCopyID((int) row.get("CopyID"));
            copy.setBookID(bookID);
            copy.setStatus((String) row.get("Status"));
            copy.setMemberID((int) row.get("MemberID"));
            copy.setDueBack((Date) row.get("DueBack"));

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
