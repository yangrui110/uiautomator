package com.uiautomator.script.other;

public enum  TaskType {

    IMPORT_IMG("importImg","导入图片"),
    SETTING("setting","设置"),
    WhatsApp("whatsApp","whatsApp应用"),
    Diy("diy","diy应用"),
    Postern("postern","postern应用"),
    ImportContact("importContact","联系人"),
    ResetIp("resetIp","重置手机IP"),
    WakeUp("wakeUp","解锁手机");

    private String value;
    private String desc;

    TaskType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
