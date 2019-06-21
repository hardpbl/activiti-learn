package com.hand.condidateusers;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * @author panbailiang
 * @version 1.0
 * @description:拾取任务，这样任务才有了审批人，如我们的任务是xiaowang和xiaozhao可以处理，可是必须先拾取，才能进行处理
 * @date 2019/6/20 22:35
 */
public class ClaimTask {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        //要拾取的任务id
        String taskId = "5002";
        //任务候选人id
        String userId = "xiaowang";
        //拾取任务
        //即使该用户不是候选人也能拾取(建议拾取时校验是否有资格)
        //校验该用户有没有拾取任务的资格
        Task task = taskService.createTaskQuery()//
                .taskId(taskId)
                .taskCandidateUser(userId)//根据候选人查询
                .singleResult();
        if(task!=null){
            taskService.claim(taskId, userId);
            //拾取成功act_ru_task表的assign字段会变成我们的任务候选人idxiaowang
            System.out.println("任务拾取成功");
        }
    }
}
