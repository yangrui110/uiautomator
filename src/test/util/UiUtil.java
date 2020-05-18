package test.util;

import android.graphics.Rect;
import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

import java.util.ArrayList;
import java.util.List;

public class UiUtil {

    public static long time = 60 *1000;

    public static void clickSelector(UiSelector selector) {
        boolean find = false;
        long start = System.currentTimeMillis();
        while (!find) {
            try {
                UiCollection uiObject = new UiCollection(selector);
                find = uiObject.exists();
                if (find) {
                    uiObject.click();
                    sleepTime(getRandTime());
                } else {
                    System.out.println("我没找到-----" + uiObject.getText());
                }
                sleepTime(100);
            } catch (UiObjectNotFoundException e) {
                //e.printStackTrace();
            }
            long end = System.currentTimeMillis();
            if((end-start)>time){
                find=false;
            }
        }
    }

    public static void clickSelectorThrow(UiSelector selector) throws UiObjectNotFoundException {
        boolean find = false;
        long start = System.currentTimeMillis();
        while (!find) {
            UiCollection uiObject = new UiCollection(selector);
            find = uiObject.exists();
            if (find) {
                uiObject.click();
                sleepTime(getRandTime());
            } else {
                System.out.println("我没找到-----" + uiObject.getText());
            }
            sleepTime(100);
            long end = System.currentTimeMillis();
            if((end-start)>time){
                find=false;
            }
        }
    }

    public static boolean clickNoThrow(UiSelector selector) {
        boolean find = false;
        try {
            while (!find) {
                UiCollection uiObject = new UiCollection(selector);
                find = uiObject.exists();
                if (find) {
                    uiObject.click();
                    sleepTime(getRandTime());
                } else {
                    System.out.println("我没找到-----" + uiObject.getText());
                }
                sleepTime(100);
            }
        } catch (UiObjectNotFoundException e) {
            //e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void clickSelector(UiSelector selector, int x, int y) {
        boolean find = false;
        UiDevice instance = UiDevice.getInstance();
        long start = System.currentTimeMillis();
        while (!find) {
            try {
                UiCollection uiObject = new UiCollection(selector);
                find = uiObject.exists();
                if (find) {
                    instance.click(x, y);
                    sleepTime(getRandTime());
                } else {
                    System.out.println("我没找到-----" + uiObject.getText());
                }
                sleepTime(100);
                long end = System.currentTimeMillis();
                if((end-start)>time){
                    find=false;
                }
            } catch (UiObjectNotFoundException e) {
                //e.printStackTrace();
                long end = System.currentTimeMillis();
                if((end-start)>time){
                    find=false;
                }
            }
        }
    }

    public static void clickSelectorCenter(UiSelector selector){
        boolean find = false;
        UiDevice instance = UiDevice.getInstance();
        long start = System.currentTimeMillis();
        while (!find) {
            try {
                UiCollection uiObject = new UiCollection(selector);
                find = uiObject.exists();
                if (find) {
                    Rect bounds = uiObject.getBounds();
                    instance.click(bounds.centerX(), bounds.centerY());
                    sleepTime(getRandTime());
                } else {
                    System.out.println("我没找到-----" + uiObject.getText());
                }
                sleepTime(100);
                long end = System.currentTimeMillis();
                if ((end - start) > time) {
                    find = false;
                }
            } catch (UiObjectNotFoundException e) {
                long end = System.currentTimeMillis();
                if((end-start)>time){
                    find=false;
                }
                //e.printStackTrace();
            }
        }
    }

    public static void setSelectorText(String text, UiSelector selector) throws UiObjectNotFoundException {
        boolean find = false;
        //List<UiSelector> andOther = getSureAndOther();
        long start = System.currentTimeMillis();
        while (!find) {
            UiCollection uiObject = new UiCollection(selector);
            find = uiObject.exists();
            //clickListSelector(andOther);
            if (find) {
                uiObject.clearTextField();
                sleepTime(1000);
                uiObject.setText(text);
                sleepTime(getRandTime());
            } else {
                System.out.println("我没找到===" + uiObject.getText());
            }
            sleepTime(100);
            long end = System.currentTimeMillis();
            if((end-start)>time){
                find=false;
            }
        }
    }

    public static void sleepTime(long time) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static long getRandTime() {
        int random = (int) (Math.random() * 10);
        return random * 1000;
    }


    //确定以及其它流程
    public static List<UiSelector> getSureAndOther() {
        ArrayList<UiSelector> list = new ArrayList<UiSelector>();
        UiSelector uiSelector3 = new UiSelector().resourceId("android:id/button1");
        list.add(uiSelector3);
        //点击继续（可能不存在）
        UiSelector uiSelector4 = new UiSelector().text("CONTINUE");
        list.add(uiSelector4);
        //点击允许（可能不存在）
        UiSelector uiSelector5 = new UiSelector().text("ALLOW");
        list.add(uiSelector5);
        return list;
    }

    //遍历点击
    public static void clickListSelector(List<UiSelector> selectorList) throws UiObjectNotFoundException {
        for (UiSelector selector : selectorList) {
            UiCollection uiObject = new UiCollection(selector);
            if (uiObject.exists()) {
                uiObject.click();
                sleepTime(getRandTime());
            } else {
                System.out.println("我没找到-----" + uiObject.getText());
            }
            sleepTime(100);
        }
    }
}
