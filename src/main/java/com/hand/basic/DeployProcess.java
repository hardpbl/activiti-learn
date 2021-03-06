package com.hand.basic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * @author panbailiang
 * @version 1.0
 * @description:部署流程
 * @date 2019/6/13 15:05
 */
public class DeployProcess {
    public static void main(String[] args) {
        //流程定义部署
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //得到RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //进行部署
        Deployment deployment = (Deployment) repositoryService.createDeployment().addClasspathResource("bpmn/holiday.bpmn").name("请假流程申请").deploy();
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }
}
