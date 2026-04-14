package com.journalapp.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.journalapp.backend.model.JournalEntry;
import com.journalapp.backend.repository.JournalEntryRepository;

@Service
public class JournalService {

    private final JournalEntryRepository repository;

    public JournalService(JournalEntryRepository repository) {
        this.repository = repository;
    }

    public List<JournalEntry> getAllEntries() {
        return repository.findAll();
    }

    public JournalEntry saveEntry(JournalEntry entry) {
        return repository.save(entry);
    }

    public JournalEntry getEntryById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }
}
