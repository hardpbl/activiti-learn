package com.hand.condidateusers;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * @author panbailiang
 * @version 1.0
 * @description:任务转交给其他候选人来进行处理
 * @date 2019/6/20 22:49
 */
public class TurnTaskToOtherCondidateUsers {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        // 当前待办任务
        String taskId = "5002";
        // 任务负责人
        String userId = "xiaowang";
        // 校验userId是否是taskId的负责人，如果是负责人才可以归还组任务
        Task task = taskService.createTaskQuery().taskId(taskId)
                .taskAssignee(userId).singleResult();
        String processDefinitionKey = "holidayCondidateUsers";

        if (task != null) {
            // 将此任务交给其它候选人办理该 任务
            String condidateUser = "xiaozhao";

                // 才可以交接
                taskService.setAssignee(taskId, condidateUser);
                System.out.println("任务成功交接给：" + condidateUser);

        }
    }
}
