package com.leopord.hmall.controller;

import com.leopord.hmall.entity.Product;
import com.leopord.hmall.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class BookController {

    @Resource
    private BookService bookService;

    @RequestMapping("/getBook/{id}")
    public Product getProduct(@PathVariable("id") Integer id) {
        return bookService.getProductById(id);
    }
}
