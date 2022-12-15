package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.services.BakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bakers")
public class BakerController {
    @Autowired
    private BakerService bakerService;

    public BakerController(BakerService service) {
        this.bakerService = service;
    }
    @GetMapping("/all")
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(bakerService.index(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Baker> show(@PathVariable Long id) {
        return new ResponseEntity<>(bakerService.show(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(bakerService.create(baker), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Baker> update(@PathVariable Long id,@RequestBody Baker baker) {
        return new ResponseEntity<>(bakerService.update(id, baker), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(bakerService.delete(id), HttpStatus.OK);
    }
}
