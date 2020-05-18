package com.uiautomator.script.process;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uiautomator.script.factory.ApplicationScriptFactory;
import com.uiautomator.script.factory.SimpleApplicationScriptFactory;
import com.uiautomator.script.other.TaskType;
import com.uiautomator.script.param.ExecuteParam;
import com.uiautomator.script.param.ResetIpParam;
import com.uiautomator.script.param.WechatsAppParam;
import com.uiautomator.script.task.Task;

import java.util.ArrayList;

/**
 * 总执行类
 * */
public class Proccess extends UiAutomatorTestCase {
    //执行的工厂类
    private ApplicationScriptFactory factory;

    public Proccess() {
        this.factory = new SimpleApplicationScriptFactory();
    }


    public void testProccessTask() throws Exception {
        ExecuteParam executeParam = new ExecuteParam();

        Task wakeUp = factory.createTask(TaskType.WakeUp.getValue());
        if(wakeUp!=null){
            wakeUp.execute(executeParam);
        }
        Task task = factory.createTask(TaskType.Postern.getValue());
        if(task!=null){
            task.execute(null);
        }
        Task task1 = factory.createTask(TaskType.ImportContact.getValue());
        if(task1!=null){
            task1.execute(null);
        }
        Task task2 = factory.createTask(TaskType.IMPORT_IMG.getValue());
        if(task2!=null){
            task2.execute(null);
        }
        Task task3 = factory.createTask(TaskType.WhatsApp.getValue());
        if(task3!=null){
            WechatsAppParam appParam = new WechatsAppParam();
            appParam.setPerson(10);
            ArrayList<String> msgs = new ArrayList();
            msgs.add("11111");
            msgs.add("22222");
            appParam.setMsgs(msgs);
            appParam.setPhone("5814734695");
            appParam.setUrl("");
            executeParam.setAppParam(appParam);
            task3.execute(executeParam);
        }
        Task task4 = factory.createTask(TaskType.SETTING.getValue());
        if(task4!=null){
            task4.execute(null);
        }
        Task task5 = factory.createTask(TaskType.ResetIp.getValue());
        if(task5!=null){
            ResetIpParam ipParam = new ResetIpParam();
            ipParam.setIp("47.244.167.69");
            ipParam.setPort(22999);
            ipParam.setPhonePort(24007);
            executeParam.setResetIpParam(ipParam);
            task5.execute(executeParam);
        }
        Task task6 = factory.createTask(TaskType.Diy.getValue());
        if(task6!=null){
            task6.execute(null);
        }

    }
}
