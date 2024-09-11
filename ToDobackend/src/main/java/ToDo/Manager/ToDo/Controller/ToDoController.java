package ToDo.Manager.ToDo.Controller;
import ToDo.Manager.ToDo.Entity.ToDoFetchDataFormat;
import ToDo.Manager.ToDo.Entity.ToDotable;
import ToDo.Manager.ToDo.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ToDoController {
    @Autowired
    private ToDoService service;
    @CrossOrigin(origins = "*")
    @PostMapping("/DisplayTasktable")
    public List<ToDotable> TodoTable(@RequestBody ToDoFetchDataFormat Request) {
        return service.FetchToDoTableData(Request);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/AddTaskToTasktable")
    public ToDotable addTaskToTodoTable(@RequestBody ToDotable insertData) {
        return service.addTaskInTable(insertData);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/UpdateTaskInTable")
    public ToDotable updateTaskInTodoTable(@RequestBody ToDotable updateData) {
        return service.updateTaskInTable(updateData);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/DeleteTaskFromTasktable")
    public String deleteTaskFromTodoTable(@RequestParam Long id) {
        return service.deleteTaskInTable(id);
    }
}
