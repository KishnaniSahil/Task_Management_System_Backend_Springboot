package apiintegration.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class taskRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void taskDetails(String description) {
        this.jdbcTemplate.update("exec [dbo].[CreateTask] ?", description);
    }

    public void deleteTask(Integer tid){
        System.out.println(this.jdbcTemplate.update("Exec [dbo].[DeleteTask] ?",tid));
    }

    public void finishTask(Integer tid){
        System.out.println(this.jdbcTemplate.update("Exec [dbo].[FinishTask] ?",tid));
    }

    public void updateTask(Integer tid,String description){
        System.out.println(this.jdbcTemplate.update("Exec [dbo].[UpdateTask] ?,?",tid,description));
    }

    public List<Map<String ,Object>> getTask(){
        return this.jdbcTemplate.queryForList("EXEC [dbo].[getTask]") ;}


}
