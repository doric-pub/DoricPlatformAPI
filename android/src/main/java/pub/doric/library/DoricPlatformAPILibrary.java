package pub.doric.library;

import java.io.IOException;
import java.io.InputStream;

import pub.doric.Doric;
import pub.doric.DoricComponent;
import pub.doric.DoricLibrary;
import pub.doric.DoricRegistry;

@DoricComponent
public class DoricPlatformAPILibrary extends DoricLibrary {
    @Override
    public void load(DoricRegistry registry) {
        try {
            InputStream is = Doric.application().getAssets().open("bundle_doric-platform-api.js");
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            String content = new String(bytes);
            registry.registerJSBundle("doric-platform-api", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        registry.registerNativePlugin(DoricScreenKeepOnPlugin.class);
        registry.registerNativePlugin(DoricClipboardPlugin.class);
    }
}
