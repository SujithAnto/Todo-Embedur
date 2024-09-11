package ToDo.Manager.ToDo.Service;

import ToDo.Manager.ToDo.Repo.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ToDo.Manager.ToDo.Entity.ToDotable;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ToDoRepository taskRepository;

    public void sendReminderEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    @Scheduled(fixedRate = 60000) // Runs every minute
    public void checkTasksAndSendReminders() {
        List<ToDotable> tasks = taskRepository.findAll();
        for (ToDotable task : tasks) {
            if (isReminderTime(task)) {
                sendReminderEmail(
                        "recipient-email@example.com", // Replace with actual email address
                        "Reminder: Task \"" + task.getTitle() + "\" is due soon",
                        "Your task \"" + task.getTitle() + "\" is due within the next " + task.getDueInHours() + " hours."
                );
            }
        }
    }

    private boolean isReminderTime(ToDotable task) {
        LocalDateTime reminderDateTime = task.getCreatedDate().plusHours(task.getDueInHours());
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.isEqual(reminderDateTime) || currentDateTime.isAfter(reminderDateTime);
    }
}
