package com.uiautomator.script.task;

import android.os.RemoteException;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.uiautomator.script.param.ExecuteParam;

public interface Task {
    /** @pdOid 2b2acc45-2a05-41f1-bcdf-3acb16a3c9d1 */
    void execute(ExecuteParam param) throws Exception;

}