import { BridgeContext } from "doric";

export function screenKeepOn(context: BridgeContext) {
  return {
    enable: () => {
      return context.callNative("screenKeepOn", "enable") as Promise<void>;
    },

    disable: () => {
      return context.callNative("screenKeepOn", "disable") as Promise<void>;
    },

    isEnabled: () => {
      return context.callNative("screenKeepOn", "isEnabled") as Promise<boolean>;
    }
  };
}
