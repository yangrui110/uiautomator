package com.uiautomator.script.task;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiSelector;
import com.uiautomator.script.param.ExecuteParam;
import com.uiautomator.script.util.UiUtil;

public class SettingTask implements Task {

    @Override
    public void execute(ExecuteParam param) {
        clearStorage();
    }

    public static void clearStorage(){
        //需要优先打开Setting应用
        UiDevice device = UiDevice.getInstance();
        //device.openQuickSettings();
        UiSelector text = new UiSelector().resourceId("android:id/title").text("Apps & notifications");
        UiUtil.clickSelector(text);
        //点击whatsapp应用
        UiSelector selector = new UiSelector().text("WhatsApp").resourceId("android:id/title");
        UiUtil.clickSelector(selector);
        //点击强制停止
        UiSelector selector1 = new UiSelector().text("Force stop").resourceId("com.android.settings:id/button2_negative");
        UiUtil.clickSelector(selector1);
        //点击OK
        UiSelector selector2 = new UiSelector().text("OK").resourceId("android:id/button1");
        UiUtil.clickSelector(selector2);
        //点击storage
        UiSelector selector3 = new UiSelector().text("Storage").resourceId("android:id/title");
        UiUtil.clickSelector(selector3);
        //点击清楚存储
        UiSelector selector4 = new UiSelector().text("Clear storage").resourceId("com.android.settings:id/button1_negative");
        UiUtil.clickSelector(selector4);
        //点击OK按钮
        UiSelector selector5 = new UiSelector().text("OK").resourceId("android:id/button1");
        UiUtil.clickSelector(selector5);
        //点击menu按钮
        device.pressHome();
    }
}
