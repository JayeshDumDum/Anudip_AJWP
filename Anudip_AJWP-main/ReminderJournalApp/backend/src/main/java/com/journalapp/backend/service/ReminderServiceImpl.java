package com.journalapp.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.journalapp.backend.model.Reminder;
import com.journalapp.backend.repository.ReminderRepository;

@Service
public class ReminderServiceImpl {

    private final ReminderRepository reminderRepository;

    public ReminderServiceImpl(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    // create reminder
    public Reminder saveReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    // get reminder by id
    public Reminder getReminder(Long id) {
        return reminderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reminder not found"));
    }

    // get all reminders
    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    // mark reminder as done
    public Reminder markAsDone(Long id) {
        Reminder reminder = getReminder(id);
        reminder.setStatus(Reminder.Status.DONE);
        return reminderRepository.save(reminder);
    }

    // delete reminder
    public void deleteReminder(Long id) {
        reminderRepository.deleteById(id);
    }
}
