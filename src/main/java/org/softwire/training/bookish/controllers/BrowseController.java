package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.page.BrowsePageModel;
import org.softwire.training.bookish.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/browse")
public class BrowseController {

    private final LibraryService libraryService;

    @Autowired
    public BrowseController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @RequestMapping("")
    ModelAndView browse(@RequestParam(required = false, defaultValue = "title") String sort) {

        /*List<String> sortOptions =  Arrays.asList("title","author","isbn","edition","publisher");

        if (!sortOptions.contains(sort)) {sort = "title";}

        List<Book> allBooks = libraryService.getAllBooks(sort);

        allBooks.forEach(book -> book.setCopies(libraryService.getCopies(book.getBookID())));*/

        List<Book> allBooks = libraryService.getAllCopies();

        BrowsePageModel browsePageModel = new BrowsePageModel();
        browsePageModel.setBooks(allBooks);

        return new ModelAndView("browse", "model", browsePageModel);
    }
}