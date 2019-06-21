package com.hand.listen;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author panbailiang
 * @version 1.0
 * @description:完成个人任务
 * @date 2019/6/15 12:06
 */
public class FinishPersonTask {
    public static void main(String[] args) {

        //流程定义key
        String processDifiniitionKey = "holidayListen";
        String assignee = "张三";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery().processDefinitionKey(processDifiniitionKey).taskAssignee(assignee).list();
        for (Task task : list) {
            System.out.println("----------------------------");
            System.out.println(" 流 程 实 例 id ： " +
                    task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
            processEngine.getTaskService()//
                    .complete(task.getId());
            System.out.println(task.getAssignee()+"完成任务："+task.getId());
        }


    }
}
