package test;

import com.android.uiautomator.core.*;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import test.util.UiUtil;

import java.io.IOException;

public class BaseTest extends UiAutomatorTestCase {

    public void testDemo() throws UiObjectNotFoundException, InterruptedException, IOException {
        // device.wait(Until.hasObject(By.pkg(packageName).depth(0)),LAUNCH_TIMEOUT);

        //ShellUtils.execCmd("curl -X POST \"http://127.0.0.1:22999/api/refresh_sessions/24007\" -H \"accept: application/json# Describe your paths here\"",false);
        //clickDiy();
        //clickApp();
        //sendMsg();
        // post = HttpClientHelper.sendPost("http://47.244.167.69:22999/api/refresh_sessions/24007", new JSONObject());
        //System.out.println("返回结果："+post);
        clearStorage();
    }

    private static void clickApp() throws UiObjectNotFoundException, IOException {
        UiSelector uiSelector = new UiSelector().resourceId("com.whatsapp:id/eula_accept");
        UiUtil.clickSelector(uiSelector);
        //设置国家
        UiSelector uiSelector0 = new UiSelector().resourceId("com.whatsapp:id/registration_cc");
        setCountry("1",uiSelector0);
        //输入手机号
        UiSelector uiSelector1 = new UiSelector().resourceId("com.whatsapp:id/registration_phone");
        UiUtil.setSelectorText("7828318683",uiSelector1);
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
        //设置验证码
        UiSelector uiSelector6 = new UiSelector().resourceId("com.whatsapp:id/verify_sms_code_input");
        UiUtil.setSelectorText("686367",uiSelector6);
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
    /**
     * 清楚缓存
     * */
    public static void clearStorage(){
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

    //发送信息
    public static void sendMsg() throws UiObjectNotFoundException {
        //点击信息图表
        UiSelector uiSelector1 = new UiSelector().resourceId("com.whatsapp:id/fab");
        UiSelector uiSelector2 = new UiSelector().resourceId("android:id/list");
        UiSelector uiSelector3 = new UiSelector().text("Invite friends");
        for(int i=1;i<10;i++){
            UiUtil.clickSelectorCenter(uiSelector1);
            boolean contacts = clickContacts(uiSelector2, i, uiSelector3);
            if(!contacts){
                break;
            }
        }
    }

    private static void clickDiy() {
        UiSelector uiSelector1 = new UiSelector().className("android.widget.ImageView").index(2);
        UiUtil.clickSelector(uiSelector1);
        //查找新机
        UiSelector selector = new UiSelector().text("新机");
        UiUtil.clickSelector(selector);
        // 查找确定
        UiSelector selector2 = new UiSelector().text("确定");
        UiUtil.clickSelector(selector2);
    }

    public static void setCountry(String text, UiSelector selector) throws UiObjectNotFoundException {
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

    /**
     * @param selector 选择器
     * @param count 遍历的第几个
     * @param contact 发现新朋友
     * */
    public static boolean clickContacts(UiSelector selector, int count,UiSelector contact) throws UiObjectNotFoundException {
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
                        detailSendMsg();
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
                        detailSendMsg();
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

    private static void detailSendMsg() throws UiObjectNotFoundException {
        UiSelector uiSelector1 = new UiSelector().resourceId("com.whatsapp:id/entry");
        UiUtil.setSelectorText("22",uiSelector1);
        UiSelector uiSelector2 = new UiSelector().resourceId("com.whatsapp:id/send");
        UiUtil.clickSelectorCenter(uiSelector2);
        UiUtil.sleepTime(1000);
        UiDevice instance = UiDevice.getInstance();
        instance.click(50,150); //点击返回
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
