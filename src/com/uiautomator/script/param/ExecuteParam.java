package com.uiautomator.script.param;

public class ExecuteParam {

    private WechatsAppParam appParam = new WechatsAppParam();

    private ResetIpParam resetIpParam = new ResetIpParam();

    public WechatsAppParam getAppParam() {
        return appParam;
    }

    public void setAppParam(WechatsAppParam appParam) {
        this.appParam = appParam;
    }

    public ResetIpParam getResetIpParam() {
        return resetIpParam;
    }

    public void setResetIpParam(ResetIpParam resetIpParam) {
        this.resetIpParam = resetIpParam;
    }
}
