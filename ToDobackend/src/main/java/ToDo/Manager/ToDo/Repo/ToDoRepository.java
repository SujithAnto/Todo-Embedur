package ToDo.Manager.ToDo.Repo;

import ToDo.Manager.ToDo.Entity.ToDotable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDotable,Long> {

    @Query("SELECT t FROM ToDotable t WHERE "
            + "(:status IS NULL OR t.status = :status) AND "
            + "(:title IS NULL OR t.title LIKE %:title%) "
            + "ORDER BY t.dueInHours ASC")
    List<ToDotable> QueryForToDoTableDisplay(
            @Param("status") String status,
            @Param("title") String title);




}
