package com.journalapp.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.journalapp.backend.model.Reminder;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    // Get reminders for a user
    List<Reminder> findByUserId(Long userId);

    // Get reminders by status
    List<Reminder> findByStatus(Reminder.Status status);
}
