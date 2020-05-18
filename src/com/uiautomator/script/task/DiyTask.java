package com.uiautomator.script.task;

import com.android.uiautomator.core.UiSelector;
import com.uiautomator.script.param.ExecuteParam;
import com.uiautomator.script.util.UiUtil;

public class DiyTask implements Task {
    @Override
    public void execute(ExecuteParam param) {
        clickDiy();
    }

    private static void clickDiy() {
        //需要在此处编写打开Diy应用代码
        UiSelector uiSelector1 = new UiSelector().className("android.widget.ImageView").index(2);
        UiUtil.clickSelector(uiSelector1);
        //查找新机
        UiSelector selector = new UiSelector().text("新机");
        UiUtil.clickSelector(selector);
        // 查找确定
        UiSelector selector2 = new UiSelector().text("确定");
        UiUtil.clickSelector(selector2);
    }
}
