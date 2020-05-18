package com.uiautomator.script.task;

import com.android.uiautomator.core.*;
import com.uiautomator.script.param.ExecuteParam;
import com.uiautomator.script.param.WechatsAppParam;
import com.uiautomator.script.util.UiUtil;

import java.util.List;

public class WhatsAppTask implements Task {
    @Override
    public void execute(ExecuteParam param) throws UiObjectNotFoundException {
        //点击进入APP
        clickApp(param.getAppParam());
        //发送消息
        sendMsg(param.getAppParam());
    }

    private static void clickApp(WechatsAppParam appParam) throws UiObjectNotFoundException, UiObjectNotFoundException {
        UiSelector uiSelector = new UiSelector().resourceId("com.whatsapp:id/eula_accept");
        UiUtil.clickSelector(uiSelector);
        //设置国家
        UiSelector uiSelector0 = new UiSelector().resourceId("com.whatsapp:id/registration_cc");
        setCountry(appParam.getCountry(),uiSelector0);
        //输入手机号
        UiSelector uiSelector1 = new UiSelector().resourceId("com.whatsapp:id/registration_phone");
        UiUtil.setSelectorText(appParam.getPhone(),uiSelector1);
        //点击下一步
        UiSelector uiSelector2 = new UiSelector().resourceId("com.whatsapp:id/registration_submit");
        UiUtil.clickSelector(uiSelector2);
        //点击OK
        UiSelector uiSelector3 = new UiSelector().resourceId("android:id/button1");
        UiUtil.clickSelector(uiSelector3);
        //点击continue，可能不存在
        UiSelector uiSelectorContinue = new UiSelector().resourceId("com.whatsapp:id/submit");
        boolean aThrow = UiUtil.clickNoThrow(uiSelectorContinue);
        if(aThrow){
            //点击Allow
            UiSelector uiSelectorAllow = new UiSelector().resourceId("com.android.packageinstaller:id/permission_allow_button");
            UiUtil.clickSelector(uiSelectorAllow);
        }
        //设置验证码(此处获取验证码并进行验证)
        UiSelector uiSelector6 = new UiSelector().resourceId("com.whatsapp:id/verify_sms_code_input");
        UiUtil.setSelectorText("212329",uiSelector6);
        //设置资料
        UiSelector uiSelector7 = new UiSelector().resourceId("com.whatsapp:id/change_photo_btn");
        UiUtil.clickSelector(uiSelector7);
        //点击图片
        UiSelector uiSelector8 = new UiSelector().resourceId("com.whatsapp:id/icon");
        UiUtil.clickSelector(uiSelector8);
        //点击allow
        UiSelector uiSelector9 = new UiSelector().resourceId("com.android.packageinstaller:id/permission_allow_button");
        UiUtil.clickSelector(uiSelector9);
        //点击图片集合
        UiSelector uiSelector10 = new UiSelector().resourceId("com.whatsapp:id/thumbnail");
        UiUtil.clickSelector(uiSelector10,100,300);
        //点击图片
        UiSelector uiSelector11 = new UiSelector().description("Photo").className("android.widget.ImageView");
        UiUtil.clickSelectorCenter(uiSelector11);
        //点击完成
        UiSelector uiSelector12 = new UiSelector().resourceId("com.whatsapp:id/ok_btn");
        UiUtil.clickSelector(uiSelector12);
        //设置昵称
        UiSelector uiSelector13 = new UiSelector().resourceId("com.whatsapp:id/registration_name");
        UiUtil.setSelectorText("9981",uiSelector13);
        //点击下一步
        UiSelector uiSelector14 = new UiSelector().resourceId("com.whatsapp:id/register_name_accept");
        UiUtil.clickSelector(uiSelector14);
        //获取到验证码
        /*String sendGet = HttpClientHelper.sendGet("http://47.107.117.56:23456/getsms?token=88BFD0766AC84CCA8CF0B7FED31E891861923EC57814A0F3F652EE0F53F179247494B61C90C5815E");
        System.out.println("结果是："+sendGet);
        JSONObject jsonObject = JSONObject.parseObject(sendGet, JSONObject.class);
        Boolean flag = jsonObject.getBoolean("flag");
        if(flag){
            System.out.println("结果正确");
            String message = jsonObject.getString("message");
            int of = message.indexOf("-");
            if(of!=-1){
                String result = message.substring(of-3,of+3);
                String code = result.replace("-", "");
                System.out.println("我是正常得到编码："+code);

            }else {
                System.out.println(message);
            }
        }else {
            System.out.println("结果错误");
        }*/
    }

    private static void setCountry(String text, UiSelector selector) throws UiObjectNotFoundException {
        boolean find = false;
        //List<UiSelector> andOther = getSureAndOther();
        long start = System.currentTimeMillis();
        while (!find) {
            UiCollection uiObject = new UiCollection(selector);
            find = uiObject.exists();
            //clickListSelector(andOther);
            if (find) {
                uiObject.clearTextField();
                UiUtil.sleepTime(1000);
                if(uiObject.getText()==null||"".equals(uiObject.getText())){
                    uiObject.setText(text);
                    UiUtil.sleepTime(UiUtil.getRandTime());
                }
            } else {
                System.out.println("我没找到===" + uiObject.getText());
            }
            UiUtil.sleepTime(100);
            long end = System.currentTimeMillis();
            if((end-start)>120*1000){
                find=false;
            }
        }
    }

    //发送信息
    public static void sendMsg(WechatsAppParam appParam) throws UiObjectNotFoundException {
        //点击信息图表
        UiSelector uiSelector1 = new UiSelector().resourceId("com.whatsapp:id/fab");
        UiSelector uiSelector2 = new UiSelector().resourceId("android:id/list");
        UiSelector uiSelector3 = new UiSelector().text("Invite friends");
        for(int i=1;i<appParam.getPerson();i++){
            UiUtil.clickSelectorCenter(uiSelector1);
            boolean contacts = clickContacts(uiSelector2, i, uiSelector3,appParam.getMsgs());
            if(!contacts){
                break;
            }
        }
    }

    /**
     * @param selector 选择器
     * @param count 遍历的第几个
     * @param contact 发现新朋友的结束判断标志
     * @param texts 需要发送的文本消息
     * */
    public static boolean clickContacts(UiSelector selector, int count, UiSelector contact, List<String> texts) throws UiObjectNotFoundException {
        boolean find = false;
        long start = System.currentTimeMillis();
        UiDevice instance = UiDevice.getInstance();
        while (!find) {
            UiCollection uiObject = new UiCollection(selector);
            find = uiObject.exists();
            //clickListSelector(andOther);
            if (find) {
                // 首先查找当前是否存在允许按钮
                UiSelector allow = new UiSelector().resourceId("com.android.packageinstaller:id/permission_allow_button");
                UiUtil.clickNoThrow(allow); //点击允许按钮
                int startY = (count + 2) * 168+210-84;
                int startX = 600;
                if(count<7){
                    if(!judeOverFriend(count,contact)) {
                        //直接点击
                        instance.click(startX, startY);
                        UiUtil.sleepTime(1000);
                        //点击发送消息逻辑
                        detailSendMsg(texts);
                    }else return false;
                }else {
                    //向上滑动count-7个距离
                    System.out.println("滑动：y1="+((count+2)*168+210)+" y2="+(9*168+210-84));
                    swipeScreen((count+2)*168+210,9*168+210,instance);
                    boolean friend = existFindFriend(contact);
                    //如果存在，就挨个点击
                    if (friend) {
                        System.out.println("存在friend标签");
                        return false;
                    }else {
                        instance.click(startX,9*168+210-84);
                        System.out.println("点击位置："+(9*168+210-84));
                        UiUtil.sleepTime(1000);
                        //点击发送消息逻辑
                        detailSendMsg(texts);
                    }
                }
            } else {
                System.out.println("我没找到===" + uiObject.getText());
            }
            UiUtil.sleepTime(100);
            long end = System.currentTimeMillis();
            if((end-start)>120*1000){
                find=false;
            }
        }
        return true;
    }

    private static boolean judeOverFriend(int count,UiSelector contact) throws UiObjectNotFoundException {
        int startY = (count + 2) * 168+210-84;
        for (int i =0;i<10;i++) {
            UiObject uiObject1 = new UiObject(contact);
            if (uiObject1.exists()) {
                int centerY = uiObject1.getBounds().top;
                if(startY>centerY){
                    return true;
                }
                break;
            }
        }
        return false;
    }

    /**
     * 滑动屏幕,按照滑动屏幕的大小进行确定
     * */
    private static void swipeScreen(int startY, int endY,UiDevice device){
        int screenY = 1794-210;
        int diff = startY-endY;
        while (diff>screenY){
            diff = diff%screenY;
            swipeScreen(screenY,210,device);
        }
        if(startY>1794){
            startY = 1794;
            endY = 1794-diff;
        }
        System.out.println("转换后："+startY+"---"+endY);
        device.swipe(500,startY,500,endY,10);
        UiUtil.sleepTime(100);
    }

    private static void detailSendMsg(List<String> msgs) throws UiObjectNotFoundException {
        for(String msg: msgs) {
            UiSelector uiSelector1 = new UiSelector().resourceId("com.whatsapp:id/entry");
            UiUtil.setSelectorText(msg, uiSelector1);
            UiSelector uiSelector2 = new UiSelector().resourceId("com.whatsapp:id/send");
            UiUtil.clickSelectorCenter(uiSelector2);
            UiUtil.sleepTime(1000);
        }
        UiDevice instance = UiDevice.getInstance();
        instance.click(50, 150); //点击返回
        UiUtil.sleepTime(1000);
    }
    private static boolean existFindFriend(UiSelector contact){
        //10次查找确定是否存在发现朋友
        boolean exist = false;
        for (int i =0;i<10;i++) {
            UiObject uiObject1 = new UiObject(contact);
            if (uiObject1.exists()) {
                exist = true;
                break;
            }
        }
        return exist;
    }
}
