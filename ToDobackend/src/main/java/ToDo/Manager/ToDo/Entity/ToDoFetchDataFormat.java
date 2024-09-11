package ToDo.Manager.ToDo.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ToDoFetchDataFormat {

    private String status;
    private String task;
    private String sortColumn;

    private String sortOrder;

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }
}
