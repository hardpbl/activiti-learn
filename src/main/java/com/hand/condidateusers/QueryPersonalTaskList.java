package com.hand.condidateusers;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author panbailiang
 * @version 1.0
 * @description:查询个人待办任务列表
 * @date 2019/6/20 22:40
 */
public class QueryPersonalTaskList {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 流程定义key
        String processDefinitionKey = "holidayCondidateUsers";
        // 任务负责人
        String assignee = "xiaowang";
        // 创建TaskService
        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery()//
                .processDefinitionKey(processDefinitionKey)//
                .taskAssignee(assignee).list();
        for (Task task : list) {
            System.out.println("----------------------------");
            System.out.println(" 流 程 实 例 id ： " +
                    task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
        }
    }
}
