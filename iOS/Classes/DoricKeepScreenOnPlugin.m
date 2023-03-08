//
//  DoricKeepScreenOnPlugin.m
//  DoricPlatformAPI
//
//  Created by pengfei.zhou on 2023/3/8.
//

#import "DoricKeepScreenOnPlugin.h"

@implementation DoricKeepScreenOnPlugin

- (void)enable:(NSDictionary *)dic withPromise:(DoricPromise *)promise {
    dispatch_async(dispatch_get_main_queue(), ^{
        [UIApplication sharedApplication].idleTimerDisabled = YES;
        [promise resolve:nil];
    });
}

- (void)disable:(NSDictionary *)dic withPromise:(DoricPromise *)promise {
    dispatch_async(dispatch_get_main_queue(), ^{
        [UIApplication sharedApplication].idleTimerDisabled = NO;
        [promise resolve:nil];
    });
}

- (void)isEnabled:(NSDictionary *)dic withPromise:(DoricPromise *)promise {
    dispatch_async(dispatch_get_main_queue(), ^{
        [promise resolve:@([UIApplication sharedApplication].idleTimerDisabled)];
    });
}
@end
