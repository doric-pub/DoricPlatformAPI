'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

function screenKeepOn(context) {
    return {
        enable: () => {
            return context.callNative("screenKeepOn", "enable");
        },
        disable: () => {
            return context.callNative("screenKeepOn", "disable");
        },
        isEnabled: () => {
            return context.callNative("screenKeepOn", "isEnabled");
        }
    };
}

function clipboard(context) {
    return {
        write: (content) => {
            return context.callNative("clipboard", "write", content);
        },
        read: () => {
            return context.callNative("clipboard", "read");
        },
    };
}

exports.clipboard = clipboard;
exports.screenKeepOn = screenKeepOn;
//# sourceMappingURL=bundle_doric-platform-api.js.map
