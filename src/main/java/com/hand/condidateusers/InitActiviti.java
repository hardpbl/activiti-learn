package com.hand.condidateusers;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * @author panbailiang
 * @version 1.0
 * @description:初始化数据库
 * @date 2019/6/12 17:00
 */
public class InitActiviti {

    public static void main(String[] args) {
        //创建ProcessEngineConfiguration
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        //通过ProcessEngineConfiguration创建ProcessEngine，此时会创建数据库
        ProcessEngine processEngine = configuration.buildProcessEngine();
//        processEngine.?
        System.out.println(processEngine);
    }
}
