package org.softwire.training.bookish.models.database;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.Date;
import java.util.List;

public class Member {
    @ColumnName("MemberID")
    private int memberID;

    @ColumnName("Name")
    private String name;

    @ColumnName("RegistrationDate")
    private Date registrationDate;

    @ColumnName("Status")
    private String status;

    private List<Book> books;

    public Member() {};

    public int getMemberID() {
        return memberID;
    }
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
