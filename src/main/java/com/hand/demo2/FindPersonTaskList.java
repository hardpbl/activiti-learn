package com.hand.demo2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author panbailiang
 * @version 1.0
 * @description:TODO
 * @date 2019/6/15 11:47
 */
public class FindPersonTaskList {
    public static void main(String[] args) {
        //流程定义key
        String processDifiniitionKey = "holidayEUL";
        String assignee = "张三";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery().processDefinitionKey(processDifiniitionKey).taskAssignee(assignee).list();
        for (Task task : list) {
            System.out.println("----------------------------");
            System.out.println("流程实例id ：" +
                    task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
        }
    }
}
