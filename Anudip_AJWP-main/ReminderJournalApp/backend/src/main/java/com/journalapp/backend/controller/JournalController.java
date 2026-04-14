package com.journalapp.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.journalapp.backend.model.JournalEntry;
import com.journalapp.backend.repository.JournalEntryRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/journal")
public class JournalController {

    private final JournalEntryRepository repository;

    public JournalController(JournalEntryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<JournalEntry> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public JournalEntry save(@RequestBody JournalEntry entry) {
        return repository.save(entry);
    }
}
