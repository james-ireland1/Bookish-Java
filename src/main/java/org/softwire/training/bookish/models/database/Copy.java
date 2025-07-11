package org.softwire.training.bookish.models.database;

import java.util.Date;

public class Copy {
    private int copyID;
    private int bookID;
    private String status;
    private Integer memberID;
    private Date dueBack;
    private String memberName;

    public int getCopyID() {
        return copyID;
    }
    public void setCopyID(int copyID) {
        this.copyID = copyID;
    }

    public int getBookID() {
        return bookID;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
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
}
