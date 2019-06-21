package com.hand.listen;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * @author panbailiang
 * @version 1.0
 * @description:通过监听器来初始化部门经理审批的流程变量
 * @date 2019/6/19 23:19
 */
public class UseListenInitVar implements TaskListener {

    public void notify(DelegateTask delegateTask) {
        System.out.println("监听器执行...");
        delegateTask.setAssignee("李四");
    }
}
