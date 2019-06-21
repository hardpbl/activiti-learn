package com.hand.condidateusers;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @author panbailiang
 * @version 1.0
 * @description:开启流程实例
 * @date 2019/6/13 15:57
 */
public class StartInstance {
    public static void main(String[] args) {
        //得到processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //得到RuntimeService方法
        RuntimeService runtimeService = processEngine.getRuntimeService();

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holidayCondidateUsers");
        System.out.println(processInstance.getId());
        System.out.println(processInstance.getDeploymentId());
        System.out.println(processInstance.getActivityId());
    }
}
