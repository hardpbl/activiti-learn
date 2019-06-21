package com.hand.demo2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * @author panbailiang
 * @version 1.0
 * @description:TODO
 * @date 2019/6/12 17:00
 */
public class InitDemo {

    public static void main(String[] args) {
        //创建ProcessEngineConfiguration
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        //通过ProcessEngineConfiguration创建ProcessEngine，此时会创建数据库
        ProcessEngine processEngine = configuration.buildProcessEngine();
//        processEngine.?
        System.out.println(processEngine);
    }
}
