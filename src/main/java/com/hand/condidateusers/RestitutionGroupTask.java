package com.hand.condidateusers;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * @author panbailiang
 * @version 1.0
 * @description:归还组任务，如果个人不想办理该组任务，可以归还组任务，归还后该用户不再是该任务的负责人，这样组内其他人才能拾取任务
 * @date 2019/6/20 22:44
 */
public class RestitutionGroupTask {
    public static void main(String[] args) {
       ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 查询任务使用TaskService
        TaskService taskService = processEngine.getTaskService();
        // 当前待办任务
        String taskId = "5002";
        // 任务负责人
        String userId = "xiaowang";
        // 校验userId是否是taskId的负责人，如果是负责人才可以归还组任务
        Task task = taskService.createTaskQuery().taskId(taskId)
                .taskAssignee(userId).singleResult();
        if (task != null) {
        // 如果设置为null，归还组任务,该 任务没有负责人,哈哈，看见代码是不是很假，只是把act_ru_task的assign字段设置为null而已，并不是什么骚操作
            taskService.setAssignee(taskId, null);
        }
    }
}
