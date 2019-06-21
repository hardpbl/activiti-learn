package com.hand.basic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * @author panbailiang
 * @version 1.0
 * @description:流程定义查询,比如请假流程被定义了一次，但是部署了多次
 * @date 2019/6/14 11:13
 */
public class ProcessDifinitionQuery {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 流程定义key
        String processDefinitionKey = "holiday";
        // 获取repositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 查询流程定义
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        //遍历查询结果
        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey(processDefinitionKey).orderByProcessDefinitionVersion().desc().list();
        for (ProcessDefinition processDefinition : list) {
            System.out.println("------------------------");
            System.out.println(" 流 程 部 署 id ： " + processDefinition.getDeploymentId());
            System.out.println("流程定义id：" + processDefinition.getId());
            System.out.println("流程定义名称：" + processDefinition.getName());
            System.out.println("流程定义key：" + processDefinition.getKey());
            System.out.println("流程定义版本：" + processDefinition.getVersion());
        }
    }

}
