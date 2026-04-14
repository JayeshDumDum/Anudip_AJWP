package com.journalapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.journalapp.backend.model.JournalEntry;

public interface JournalRepository
        extends JpaRepository<JournalEntry, Long> {
}
