package pub.doric.library;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.TextUtils;

import com.github.pengfeizhou.jscore.JavaValue;

import pub.doric.DoricContext;
import pub.doric.extension.bridge.DoricMethod;
import pub.doric.extension.bridge.DoricPlugin;
import pub.doric.extension.bridge.DoricPromise;
import pub.doric.plugin.DoricJavaPlugin;
import pub.doric.utils.ThreadMode;

@DoricPlugin(name = "clipboard")
public class DoricClipboardPlugin extends DoricJavaPlugin {
    public DoricClipboardPlugin(DoricContext doricContext) {
        super(doricContext);
    }

    @DoricMethod(thread = ThreadMode.UI)
    public void write(String content, DoricPromise promise) {
        ClipboardManager clipboardManager = (ClipboardManager) getDoricContext().getContext()
                .getSystemService(Activity.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("Data", content);
        clipboardManager.setPrimaryClip(clipData);
        promise.resolve();
    }

    @DoricMethod(thread = ThreadMode.UI)
    public void read(DoricPromise promise) {
        ClipboardManager clipboardManager = (ClipboardManager) getDoricContext().getContext()
                .getSystemService(Activity.CLIPBOARD_SERVICE);
        ClipData clipData = clipboardManager.getPrimaryClip();
        if (clipData != null && clipData.getItemAt(0) != null) {
            ClipData.Item item = clipData.getItemAt(0);
            if (!TextUtils.isEmpty(item.getText())) {
                promise.resolve(new JavaValue(item.getText().toString()));
                return;
            }
        }
        promise.resolve();
    }
}
