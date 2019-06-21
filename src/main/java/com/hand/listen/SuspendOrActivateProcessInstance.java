package com.hand.listen;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

/**
 * @author panbailiang
 * @version 1.0
 * @description:挂起或者激活流程实例,当流程挂起的时候再去执行流程会抛出异常 org.activiti.engine.ActivitiException: Cannot complete a suspended task
 * @date 2019/6/15 12:44
 */
public class SuspendOrActivateProcessInstance {
    //全部流程挂起，主要是采用的是流程定义的唯一key来进行操作
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 流程定义id
        String processDefinitionKey = "holiday";
        RepositoryService repositoryService = processEngine
                .getRepositoryService();
        // 获得流程定义
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionKey(processDefinitionKey).singleResult();
        //是否暂停
        boolean suspend = processDefinition.isSuspended();
        if(suspend){
            //如果暂停则激活，这里将流程定义下的所有流程实例全部激活
            repositoryService.activateProcessDefinitionByKey(processDefinitionKey, true, null);
            System.out.println("流程key为"+processDefinitionKey + "激活");
        }else{
            //如果激活则挂起，这里将流程定义下的所有流程实例全部挂起
            repositoryService.suspendProcessDefinitionByKey(processDefinitionKey, true, null);
            System.out.println("流程key为"+processDefinitionKey + "挂起");
        }
    }

    //既然有全部流程挂起，那么必然有单个流程挂起的骚操作，代码如下
    @Test
    public void suspendOrActiveProcessInstance() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 流程实例id
        String processInstanceId = "";
        // 获取RunTimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //根据流程实例id查询流程实例
        ProcessInstance processInstance =
                runtimeService.createProcessInstanceQuery()
                        .processInstanceId(processInstanceId).singleResult();
        boolean suspend = processInstance.isSuspended();
        if(suspend){
            //如果暂停则激活
            runtimeService.activateProcessInstanceById(processInstanceId);
            System.out.println("流程实例："+processInstanceId+"激活");
        }else{
            //如果激活则挂起
            runtimeService.suspendProcessInstanceById(processInstanceId);
            System.out.println("流程实例："+processInstanceId+"挂起");
        }
    }
}
