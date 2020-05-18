package com.uiautomator.script.factory;

import com.uiautomator.script.other.TaskType;
import com.uiautomator.script.task.*;

public class SimpleApplicationScriptFactory implements ApplicationScriptFactory {
    @Override
    public Task createTask(String type) {
        if(TaskType.Diy.getValue().equals(type)){
            return new DiyTask();
        } else if(TaskType.SETTING.getValue().equals(type)){
            return new SettingTask();
        } else if(TaskType.WhatsApp.getValue().equals(type)){
            return new WhatsAppTask();
        } else if (TaskType.IMPORT_IMG.getValue().equals(type)){
            return new ImportImgTask();
        } else if(TaskType.ImportContact.getValue().equals(type)){
            return new ImportContactTask();
        } else if(TaskType.Postern.getValue().equals(type)){
            return new PosternTask();
        } else if(TaskType.ResetIp.getValue().equals(type)){
            return new ResetIpTask();
        } else if(TaskType.WakeUp.getValue().equals(type)){
            return new WakeUpTask();
        }
        return null;
    }
}
