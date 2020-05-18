package com.uiautomator.script.task;

import com.alibaba.fastjson.JSONObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.uiautomator.script.param.ExecuteParam;
import com.uiautomator.script.param.ResetIpParam;
import com.uiautomator.script.util.HttpClientHelper;

public class ResetIpTask implements Task {
    @Override
    public void execute(ExecuteParam param) throws UiObjectNotFoundException {
        resetIp(param.getResetIpParam());
    }

    private void resetIp(ResetIpParam param){
        String url = "http://%s:%d/api/refresh_sessions/%d";
        String format = String.format(url, param.getIp(), param.getPort(), param.getPhonePort());
        String sendPost = HttpClientHelper.sendPost(format, new JSONObject());
        System.out.println("重置IP成功");
    }
}
