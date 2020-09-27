package com.cassunde.estoque.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class IndexController {

    @GetMapping
    public ResponseEntity acitve(){
        return ResponseEntity.ok().build();
    }
}
