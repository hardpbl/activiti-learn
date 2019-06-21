package com.hand.basic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author panbailiang
 * @version 1.0
 * @description:TODO
 * @date 2019/6/14 9:48
 */
public class QueryProcessList {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery().processDefinitionKey("holiday").taskAssignee("wangwu").list();
        for (Task task : list){
            System.out.println("流程实例ID:"+task.getProcessDefinitionId());
            System.out.println("任务ID:"+task.getId());
            System.out.println("任务负责人："+task.getAssignee());
            System.out.println("任务名称："+task.getName());
        }
    }
}
