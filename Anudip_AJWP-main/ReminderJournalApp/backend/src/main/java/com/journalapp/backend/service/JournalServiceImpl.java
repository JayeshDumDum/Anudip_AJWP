package com.journalapp.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.journalapp.backend.model.JournalEntry;
import com.journalapp.backend.repository.JournalEntryRepository;

@Service
public class JournalServiceImpl {

    private final JournalEntryRepository journalEntryRepository;

    public JournalServiceImpl(JournalEntryRepository journalEntryRepository) {
        this.journalEntryRepository = journalEntryRepository;
    }

    public JournalEntry saveJournal(JournalEntry journalEntry) {
        return journalEntryRepository.save(journalEntry);
    }

    public JournalEntry getJournal(Long id) {
        return journalEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journal not found"));
    }

    public List<JournalEntry> getAllJournals() {
        return journalEntryRepository.findAll();
    }

    public void deleteJournal(Long id) {
        journalEntryRepository.deleteById(id);
    }
}
