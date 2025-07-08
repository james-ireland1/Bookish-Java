package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/browse")
public class BrowseController {

    private final LibraryService libraryService;

    @Autowired
    public BrowseController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @RequestMapping("")
    List<Book> listBooks() { return libraryService.getAllCopies(); }
    }
