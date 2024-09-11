package ToDo.Manager.ToDo.Service;

import ToDo.Manager.ToDo.Entity.ToDoFetchDataFormat;
import ToDo.Manager.ToDo.Repo.ToDoRepository;
import ToDo.Manager.ToDo.Entity.ToDotable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository repo;

    public List<ToDotable> FetchToDoTableData(ToDoFetchDataFormat request) {
//        System.out.println(request.getSortOrder()+""+request.getSortColumn());
            return repo.QueryForToDoTableDisplay(request.getStatus(), request.getTask()); // Adjust parameters as needed

    }


    public ToDotable addTaskInTable(ToDotable insertData) {
        return repo.save(insertData);
    }

    public ToDotable updateTaskInTable(ToDotable updateData) {
        updateData.updateCompletedDate(updateData.getStatus());
        return repo.save(updateData);  // This will update if ID is present
    }

    public String deleteTaskInTable(Long taskId) {
        repo.deleteById(taskId);
        return "Task deleted successfully";
    }
}
