package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/muffins")
public class MuffinController {
    @Autowired
    private MuffinService muffinService;

    public MuffinController(MuffinService service) {
        this.muffinService = service;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(muffinService.index(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Muffin> show(@PathVariable Long id) {
        return new ResponseEntity<>(muffinService.show(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Muffin> create(@RequestBody Muffin baker) {
        return new ResponseEntity<>(muffinService.create(baker), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Muffin> update(@PathVariable Long id, @RequestBody Muffin baker) {
        return new ResponseEntity<>(muffinService.update(id, baker), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(muffinService.delete(id), HttpStatus.OK);
    }
}
