package pub.doric.library;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;

import com.github.pengfeizhou.jscore.JavaValue;

import pub.doric.DoricContext;
import pub.doric.extension.bridge.DoricMethod;
import pub.doric.extension.bridge.DoricPlugin;
import pub.doric.extension.bridge.DoricPromise;
import pub.doric.plugin.DoricJavaPlugin;
import pub.doric.utils.ThreadMode;

@DoricPlugin(name = "screenKeepOn")
public class DoricScreenKeepOnPlugin extends DoricJavaPlugin {
    public DoricScreenKeepOnPlugin(DoricContext doricContext) {
        super(doricContext);
    }

    @DoricMethod(thread = ThreadMode.UI)
    public void enable(DoricPromise promise) {
        Context context = getDoricContext().getContext();
        if (context instanceof Activity) {
            ((Activity) context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            promise.resolve();
        } else {
            promise.reject(new JavaValue("Cannot set FLAG_KEEP_SCREEN_ON,please check context type"));
        }

    }

    @DoricMethod(thread = ThreadMode.UI)
    public void disable(DoricPromise promise) {
        Context context = getDoricContext().getContext();
        if (context instanceof Activity) {
            ((Activity) context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            promise.resolve();
        } else {
            promise.reject(new JavaValue("Cannot set FLAG_KEEP_SCREEN_ON,please check context type"));
        }
    }

    @DoricMethod(thread = ThreadMode.UI)
    public void isEnabled(DoricPromise promise) {
        Context context = getDoricContext().getContext();
        if (context instanceof Activity) {
            promise.resolve(new JavaValue((((Activity) context).getWindow().getAttributes().flags
                    & WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
                    == WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON));
        } else {
            promise.reject(new JavaValue("Cannot set FLAG_KEEP_SCREEN_ON,please check context type"));
        }
    }
}
