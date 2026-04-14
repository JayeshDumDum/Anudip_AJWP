package com.journalapp.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.journalapp.backend.model.Reminder;
import com.journalapp.backend.service.ReminderServiceImpl;

@RestController
@RequestMapping("/api/reminders")
@CrossOrigin(origins = "*")
public class ReminderController {

    private final ReminderServiceImpl reminderService;

    public ReminderController(ReminderServiceImpl reminderService) {
        this.reminderService = reminderService;
    }

    // CREATE reminder
    @PostMapping
    public Reminder createReminder(@RequestBody Reminder reminder) {
        return reminderService.saveReminder(reminder);
    }

    // GET all reminders
    @GetMapping
    public List<Reminder> getAllReminders() {
        return reminderService.getAllReminders();
    }

    // GET reminder by id
    @GetMapping("/{id}")
    public Reminder getReminder(@PathVariable Long id) {
        return reminderService.getReminder(id);
    }

    // MARK reminder as done
    @PutMapping("/{id}/done")
    public Reminder markAsDone(@PathVariable Long id) {
        return reminderService.markAsDone(id);
    }

    // DELETE reminder
    @DeleteMapping("/{id}")
    public void deleteReminder(@PathVariable Long id) {
        reminderService.deleteReminder(id);
    }
}

