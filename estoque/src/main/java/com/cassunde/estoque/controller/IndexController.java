package com.cassunde.estoque.controller;

import com.cassunde.estoque.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/stock")
public class IndexController {

    @GetMapping
    public ResponseEntity acitve(){
	    System.out.println("recebi");
        return ResponseEntity.ok(new Product(UUID.randomUUID().toString(),true));
    }
}
