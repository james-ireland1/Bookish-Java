package org.softwire.training.bookish.models.database;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

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

    public Book() {};

    public void setBookID(int BookID) {this.bookID = BookID;}
    public void setTitle(String Title) {this.title = Title;}
    public void setAuthor(String Author) {this.author = Author;}
    public void setISBN(String ISBN) {this.ISBN = ISBN;}
    public void setEdition(String Edition) {this.edition = Edition;}
    public void setPublisher(String Publisher) {this.publisher = Publisher;}

    public void printBook() {
        System.out.println(this.bookID + ": "
                + this.title + ", "
                + this.author + ", "
                + this.ISBN + ", "
                + this.edition + ", "
                + this.publisher);
    }
}
