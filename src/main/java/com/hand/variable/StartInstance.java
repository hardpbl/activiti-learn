package com.hand.variable;

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
        Holiday holiday = new Holiday();
        holiday.setId("1");
        holiday.setDay("13");
        //设置流程变量 原理是因为startProcessInstanceByKey存在重载方法
        variables.put("employee", "张三");
        variables.put("deptManager","李四");
        variables.put("generalManager","王五");
        variables.put("personnel","赵六");
        //因为在bpmn图中我们使用了eul表达式的对象.属性的形式，所以我们可以直接传对象进去，但是需要注意的是业务类需要实现序列化
        variables.put("holiday",holiday);
        //第一个参数流程图key，第二个参数businesskey，第三个参数流程变量
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holidayVariable",holiday.getId(),variables);
        System.out.println(processInstance.getId());
        System.out.println(processInstance.getDeploymentId());
        System.out.println(processInstance.getActivityId());


    }
}
