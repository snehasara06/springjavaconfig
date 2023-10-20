package com.kgisl.javaspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kgisl.javaspring.dao.BookDao;
import com.kgisl.javaspring.entity.BookInfo;



@Controller
@RequestMapping("/books")
public class BookController {
    
@Autowired
private BookDao bookDao;

    @GetMapping("/")
    public String getAll(Model book) {
        List < BookInfo > allBooks = bookDao.getBooks();
        book.addAttribute("books", allBooks);
        allBooks.forEach(System.out::println);
        return "book";
    }
}
