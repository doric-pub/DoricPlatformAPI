#import "DoricPlatformAPILibrary.h"
#import "DoricClipboardPlugin.h"
#import "DoricKeepScreenOnPlugin.h"

@implementation DoricPlatformAPILibrary
- (void)load:(DoricRegistry *)registry {
    NSString *path = [[NSBundle mainBundle] bundlePath];
    NSString *fullPath = [path stringByAppendingPathComponent:@"bundle_doric-platform-api.js"];
    NSString *jsContent = [NSString stringWithContentsOfFile:fullPath encoding:NSUTF8StringEncoding error:nil];
    [registry registerJSBundle:jsContent withName:@"doric-platform-api"];
    [registry registerNativePlugin:DoricClipboardPlugin.class withName:@"clipboard"];
    [registry registerNativePlugin:DoricKeepScreenOnPlugin.class withName:@"screenKeepOn"];
}
@end