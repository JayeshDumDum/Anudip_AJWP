package com.journalapp.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.journalapp.backend.model.JournalEntry;

public interface JournalEntryRepository
        extends JpaRepository<JournalEntry, Long> {

    // ✅ Custom query: get all journals of a user
    List<JournalEntry> findByUserId(Long userId);
}
