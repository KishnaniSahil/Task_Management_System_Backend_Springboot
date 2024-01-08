package apiintegration.demo.service;

import apiintegration.demo.repository.taskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class taskService {

    @Autowired

    private taskRepository taskrepository;

    public void taskDetails(@RequestBody Map<String,Object> taskData){
        String description=(String)taskData.get("description");
        this.taskrepository.taskDetails(description);
    }

    public void deleteTask(@RequestBody Map<String,Object> deleteTask){
        Integer tid=(Integer)deleteTask.get("tid");
        this.taskrepository.deleteTask(tid);
    }

    public void finishTask(@RequestBody Map<String,Object> finishTask){
        Integer tid=(Integer)finishTask.get("tid");

        this.taskrepository.finishTask(tid);
    }

    public void updateTask(@RequestBody Map<String,Object> updateTask){
        Integer tid=(Integer)updateTask.get("tid");
        String description=(String)updateTask.get("description");
        this.taskrepository.updateTask(tid,description);
    }

    public List<Map<String ,Object>> getTask(){
        return taskrepository.getTask(); }


}
