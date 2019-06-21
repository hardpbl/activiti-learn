package com.hand.condidateusers;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author panbailiang
 * @version 1.0
 * @description:查询用户组任务，注意任务负责人是null，代表当前无处理人，需要先进行拾取操作
 * @date 2019/6/20 22:31
 */
public class QueryUsersGroupTask {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 流程定义key
        String processDefinitionKey = "holidayCondidateUsers";
        // 任务候选人
        String candidateUser = "xiaowang";
        // 创建TaskService
        TaskService taskService = processEngine.getTaskService();
        //查询组任务
        List<Task> list = taskService.createTaskQuery()//
                .processDefinitionKey(processDefinitionKey)//
                .taskCandidateUser(candidateUser)//根据候选人查询
                .list();
        for (Task task : list) {
            System.out.println("----------------------------");
            System.out.println("流程实例id：" + task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
        }
    }
}
