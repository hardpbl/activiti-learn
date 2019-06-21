package com.hand.basic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

/**
 * @author panbailiang
 * @version 1.0
 * @description:TODO
 * @date 2019/6/14 9:56
 */
public class CompleteTask {
    public static void main(String[] args) {
        //任务id
        String id = "7502";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        taskService.complete(id);

        System.out.println("完成任务id：" + id);
    }
}
