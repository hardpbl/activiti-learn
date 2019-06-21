package com.hand.demo2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author panbailiang
 * @version 1.0
 * @description:开启流程实例并初始化流程变量
 * @date 2019/6/13 15:57
 */
public class StartInstance {
    public static void main(String[] args) {
        //得到processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //得到RuntimeService方法
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //流程启动的时候设置流程变量
        //定义流程变量
        Map<String, Object> variables = new HashMap<String, Object>();
        //设置流程变量 原理是因为startProcessInstanceByKey存在重载方法
        variables.put("employee", "张三");
        variables.put("deptManager","李四");
        variables.put("generalManager","王五");
        //第一个参数流程图key，第二个参数businesskey，第三个参数流程变量
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holidayEUL","10",variables);
        System.out.println(processInstance.getId());
        System.out.println(processInstance.getDeploymentId());
        System.out.println(processInstance.getActivityId());
    }
}
