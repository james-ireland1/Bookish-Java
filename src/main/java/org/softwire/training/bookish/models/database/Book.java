package org.softwire.training.bookish.models.database;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.ArrayList;
import java.util.List;

public class Book {
    @ColumnName("BookID")
    private int bookID;

    @ColumnName("Title")
    private String title;

    @ColumnName("author")
    private String author;

    @ColumnName("ISBN")
    private String ISBN;

    @ColumnName("Edition")
    private String edition;

    @ColumnName("Publisher")
    private String publisher;

    private List<Copy> copies;

    public Book() {};

    public void setBookID(int BookID) {
        this.bookID = BookID;
    }
    public int getBookID() {
        return this.bookID;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }
    public String getTitle() {
        return this.title;
    }

    public void setAuthor(String Author) {
        this.author = Author;
    }
    public String getAuthor() {
        return this.author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getISBN() {
        return this.ISBN;
    }

    public void setEdition(String Edition) {
        this.edition = Edition;
    }
    public String getEdition() {
        return this.edition;
    }

    public void setPublisher(String Publisher) {
        this.publisher = Publisher;
    }
    public String getPublisher() {
        return this.publisher;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }
    public List<Copy> getCopies() {
        return this.copies;
    }

    public void printBook() {
        System.out.println(this.bookID + ": "
                + this.title + ", "
                + this.author + ", "
                + this.ISBN + ", "
                + this.edition + ", "
                + this.publisher);
    }
}
