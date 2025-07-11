package org.softwire.training.bookish.models.database;

import java.util.Date;

public class CopyDTO {
    private int copyID;
    private String status;
    private Integer memberID;
    private Date dueBack;
    private String memberName;
    private int bookID;
    private String title;
    private String author;
    private String ISBN;
    private String edition;
    private String publisher;


    public int getCopyID() {
        return copyID;
    }
    public void setCopyID(int copyID) {
        this.copyID = copyID;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMemberID() {
        return memberID;
    }
    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public Date getDueBack() {
        return dueBack;
    }
    public void setDueBack(Date dueBack) {
        this.dueBack = dueBack;
    }

    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getBookID() {
        return bookID;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
