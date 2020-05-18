@echo on
adb shell uiautomator dump /sdcard/app3.uix
adb pull /sdcard/app3.uix C:\userData\idea-data\uiautomator2\app3.uix
adb shell screencap -p /sdcard/app3.png
adb pull /sdcard/app3.png C:\userData\idea-data\uiautomator2\app3.png