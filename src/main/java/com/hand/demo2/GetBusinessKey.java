package com.hand.demo2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * @author panbailiang
 * @version 1.0
 * @description:获取businesskey
 * @date 2019/6/19 23:53
 */
public class GetBusinessKey {
    public static void main(String[] args) {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        //通过taskService得到个人具体任务
        Task task = taskService.createTaskQuery().processDefinitionKey("holidayEUL").taskAssignee("张三").singleResult();

        //通过task对象得到流程实例id
        String processInstanceId = task.getProcessInstanceId();
//       System.out.println("task.getId() = "+task.getId());
        taskService.complete(task.getId());

        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

        System.out.println("businessKey = " + processInstance.getBusinessKey());

        //通过流程实例id得到流程实例对象
    }
}
