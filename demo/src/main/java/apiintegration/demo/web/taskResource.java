package apiintegration.demo.web;

import apiintegration.demo.service.taskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class taskResource {
    @Autowired
    private taskService taskservice;

    @PostMapping("taskDetails")
    public void taskDetails(@RequestBody Map<String,Object> taskData){
        this.taskservice.taskDetails(taskData);
    }

    @PostMapping("deleteTask")
    public void deleteTask(@RequestBody Map<String,Object> deleteTask){
        this.taskservice.deleteTask(deleteTask);
    }

    @PostMapping("finishTask")
    public void finishTask(@RequestBody Map<String,Object> finishTask){
        this.taskservice.finishTask(finishTask);
    }

    @PostMapping("updateTask")
    public void updateTask(@RequestBody Map<String,Object> updateTask){
        this.taskservice.updateTask(updateTask);
    }

    @GetMapping("/getTask")
    public List<Map<String ,Object>> getTask(){
        return taskservice.getTask(); }
}
