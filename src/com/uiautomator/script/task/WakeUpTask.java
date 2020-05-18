package com.uiautomator.script.task;

import com.android.uiautomator.core.UiDevice;
import com.uiautomator.script.param.ExecuteParam;
import com.uiautomator.script.util.UiUtil;

public class WakeUpTask implements Task {
    @Override
    public void execute(ExecuteParam param) throws Exception{
        UiDevice device = UiDevice.getInstance();
        if(!device.isScreenOn()){
            device.wakeUp();
            UiUtil.sleepTime(UiUtil.getRandTime());
        }
        device.swipe(300,700,300,200,10);
        UiUtil.sleepTime(UiUtil.getRandTime());
    }
}
