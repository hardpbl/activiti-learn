package com.hand.demo2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;

/**
 * @author panbailiang
 * @version 1.0
 * @description:查询流程的运行状态，当前运行节点等信息
 * @date 2019/6/15 12:34
 */
public class queryProcessInstance {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 流程定义key
        String processDefinitionKey = "holiday";
        // 获取RunTimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        List<ProcessInstance> list = runtimeService
                .createProcessInstanceQuery()
                .processDefinitionKey(processDefinitionKey)//
                .list();
        for (ProcessInstance processInstance : list) {
            System.out.println("----------------------------");
            System.out.println("流程实例id：" + processInstance.getProcessInstanceId());
            System.out.println("所属流程定义id：" + processInstance.getProcessDefinitionId());
            System.out.println("是否执行完成：" + processInstance.isEnded());
            System.out.println("是否暂停：" + processInstance.isSuspended());
            System.out.println(" 当 前 活 动 标 识 ： " + processInstance.getActivityId());
            //businessKey在工作流中通常翻译为业务主键，比如我们的请假工作流，activiti是没有存储具体请假事项的，这就需要我们自己建立
            //业务表来存储。而businessKey就是业务表的主键
            String businessKey = processInstance.getBusinessKey();
            System.out.println("流程实例：businessKey:" + businessKey);
        }
    }
}
