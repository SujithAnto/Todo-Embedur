package ToDo.Manager.ToDo.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ToDotable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 50, nullable = false)
    private String status;

    @Column(name = "due_in_hours")
    private Integer dueInHours;

    @Column(name = "created_date", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDate;

    @Column(name = "completed_date")
    private LocalDateTime completedDate;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        updateCompletedDate(status);
    }

    public Integer getDueInHours() {
        return dueInHours;
    }

    public void setDueInHours(Integer dueInHours) {
        this.dueInHours = dueInHours;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDateTime completedDate) {
        this.completedDate = completedDate;
    }

    // Update the completedDate if status is "Completed"
    public void updateCompletedDate(String status) {
        if ("Completed".equalsIgnoreCase(status)) {
            System.out.println("Setting completedDate for task: " + this.id +  LocalDateTime.now());
            this.completedDate = LocalDateTime.now();
        } else {
            this.completedDate = null; // Clear the completed date if not completed
        }
    }
}
