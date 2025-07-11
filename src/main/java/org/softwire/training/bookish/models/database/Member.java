package org.softwire.training.bookish.models.database;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.Date;
import java.util.List;

public class Member {
    private int memberID;
    private String name;
    private Date registrationDate;
    private String status;
    private List<CopyDTO> copies;

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

    public List<CopyDTO> getCopies() {
        return copies;
    }

    public void setCopies(List<CopyDTO> copies) {
        this.copies = copies;
    }
}
