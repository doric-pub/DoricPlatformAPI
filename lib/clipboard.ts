import { BridgeContext } from "doric";

export function clipboard(context: BridgeContext) {
  return {
    write: (content: string) => {
      return context.callNative("clipboard", "write", content) as Promise<boolean>;
    },
    read: () => {
      return context.callNative("clipboard", "read") as Promise<string>;
    },
  };
}
