package com.uiautomator.script.factory;

import com.uiautomator.script.task.Task;

public interface ApplicationScriptFactory {
    Task createTask(String type);
}
