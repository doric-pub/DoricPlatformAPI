#import "DoricClipboardPlugin.h"

@implementation DoricClipboardPlugin

- (void)write:(NSString *)content withPromise:(DoricPromise *)promise {
    dispatch_async(dispatch_get_main_queue(), ^{
        UIPasteboard *pasteboard = [UIPasteboard generalPasteboard];
        [pasteboard setString:content];
        [promise resolve:nil];
    });
}

- (void)read:(NSDictionary *)dic withPromise:(DoricPromise *)promise {
    dispatch_async(dispatch_get_main_queue(), ^{
        UIPasteboard *pasteboard = [UIPasteboard generalPasteboard];
        [promise resolve:pasteboard.string];
    });
}

@end