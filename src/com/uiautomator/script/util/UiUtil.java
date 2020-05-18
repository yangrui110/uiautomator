package com.uiautomator.script.util;

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
            }catch (Exception e){
                judeOverTime(start);
            }
            judeOverTime(start);
        }
    }

    //超时直接退出
    private static void judeOverTime(long start){
        long end = System.currentTimeMillis();
        if((end-start)>time){
            throw new RuntimeException();
        }
    }
    // 出现异常，直接抛出
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
            judeOverTime(start);
        }
    }

    //这个方法用来判断，当前的界面是否存在该Selector
    public static boolean clickNoThrow(UiSelector selector) {
        boolean find = false;
        try {
            while (!find) {
                //当找不到的时候，下面这个语句会报错
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

    /**
     * @param selector 查找的元素
     * @param x 点击的x位置
     * @param y 点击的y位置
     * 如果存在该Selector，就点击x,y的位置
     * */
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
                judeOverTime(start);
            } catch (UiObjectNotFoundException e) {
               judeOverTime(start);
            }
        }
    }

    /**
     * @param selector 选择器
     * 查找到元素，并点击中心点
     * */
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
                judeOverTime(start);
            } catch (UiObjectNotFoundException e) {
                judeOverTime(start);
                //e.printStackTrace();
            }
        }
    }

    /**
     * @param text 需要设置的文本内容
     * @param selector 元素选择器
     * */
    public static void setSelectorText(String text, UiSelector selector) throws UiObjectNotFoundException {
        boolean find = false;
        long start = System.currentTimeMillis();
        while (!find) {
            UiCollection uiObject = new UiCollection(selector);
            find = uiObject.exists();
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

    /**
     * 间隔
     * */
    public static void sleepTime(long time) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取随机时长0-10秒
     * */
    public static long getRandTime() {
        int random = (int) (Math.random() * 10);
        return random * 1000;
    }
}
