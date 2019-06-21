package com.hand.condidateusers;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

/**
 * @author panbailiang
 * @version 1.0
 * @description:完成个人任务
 * @date 2019/6/20 22:43
 */
public class CompleteTask {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //任务ID
        String taskId = "5002";
        processEngine.getTaskService()//
                .complete(taskId);
        System.out.println("完成任务："+taskId);
    }
}
