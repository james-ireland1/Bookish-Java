package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Copy;
import org.softwire.training.bookish.models.database.CopyDTO;
import org.softwire.training.bookish.models.database.Member;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibraryService extends DatabaseService {
    public List<Book> getAllCopies() {
        List<Map<String,Object>> rows = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM bookish.books b JOIN bookish.copies c ON b.BookID = c.BookID LEFT JOIN bookish.members m ON c.MemberID = m.MemberID;")
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

    public List<Member> getAllUsers() {
        List<Map<String,Object>> rows = jdbi.withHandle(handle ->
                handle.createQuery("SELECT m.MemberID AS MemberID, Name, RegistrationDate, m.Status AS MemberStatus, copyID, c.BookID AS BookID, c.Status AS CopyStatus, DueBack, Title, Author, ISBN, Edition, Publisher FROM bookish.members m LEFT OUTER JOIN bookish.copies c ON m.MemberID = c.MemberID LEFT JOIN bookish.books b ON c.BookID = b.BookID;")
                        .mapToMap()
                        .list());
        Map<Integer, Member> memberMap = new HashMap<>();
        for (Map<String,Object> row : rows) {
            int memberID = (int) row.get("memberid");
            Member member = memberMap.computeIfAbsent(memberID, id -> {
                Member newMember = new Member();
                newMember.setMemberID(memberID);
                newMember.setName((String) row.get("name"));
                newMember.setRegistrationDate((Date) row.get("registrationdate"));
                newMember.setStatus((String) row.get("memberstatus"));
                newMember.setCopies(new ArrayList<>());
                return newMember;
            });
            if (row.get("copyid") != null) {
                CopyDTO copy = new CopyDTO();
                copy.setCopyID((int) row.get("copyid"));
                copy.setBookID((int) row.get("bookid"));
                copy.setStatus((String) row.get("copystatus"));
                copy.setMemberID((Integer) row.get("memberid"));
                copy.setDueBack((Date) row.get("dueback"));
                copy.setMemberName((String) row.get("name"));
                copy.setTitle((String) row.get("title"));
                copy.setAuthor((String) row.get("author"));
                copy.setISBN((String) row.get("isbn"));
                copy.setEdition((String) row.get("edition"));
                copy.setPublisher((String) row.get("publisher"));

                member.getCopies().add(copy);
            }
        }

        return new ArrayList<>(memberMap.values());
    }
}
