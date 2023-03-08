import {
  Panel,
  Group,
  vlayout,
  layoutConfig,
  Gravity,
  text,
  Color,
  navbar,
  modal,
  AssetsResource,
  image,
} from "doric";
import { screenKeepOn, clipboard } from "doric-platform-api";

@Entry
class Example extends Panel {
  onShow() {
    navbar(context).setTitle("Example");
  }
  build(rootView: Group) {
    vlayout([
      image({
        image: new AssetsResource("logo_doric.png"),
      }),
      text({
        text: "Start Keep Screen On",
        textSize: 20,
        backgroundColor: Color.parse("#70a1ff"),
        textColor: Color.WHITE,
        onClick: async () => {
          screenKeepOn(this.context).enable()
        },
        layoutConfig: layoutConfig().fit(),
        padding: { left: 20, right: 20, top: 20, bottom: 20 },
      }),
      text({
        text: "Stop Keep Screen On",
        textSize: 20,
        backgroundColor: Color.parse("#70a1ff"),
        textColor: Color.WHITE,
        onClick: async () => {
          screenKeepOn(this.context).disable()
        },
        layoutConfig: layoutConfig().fit(),
        padding: { left: 20, right: 20, top: 20, bottom: 20 },
      }),
      text({
        text: "Is Keep Screen On",
        textSize: 20,
        backgroundColor: Color.parse("#70a1ff"),
        textColor: Color.WHITE,
        onClick: async () => {
          const enable = await screenKeepOn(this.context).isEnabled();
          modal(this.context).alert(`ScreenKeepOn enable:${enable}`)
        },
        layoutConfig: layoutConfig().fit(),
        padding: { left: 20, right: 20, top: 20, bottom: 20 },
      }),
      text({
        text: "Read Clipboard",
        textSize: 20,
        backgroundColor: Color.parse("#70a1ff"),
        textColor: Color.WHITE,
        onClick: async () => {
          const content = await clipboard(this.context).read();
          modal(this.context).alert(`clipboard content:${content}`)
        },
        layoutConfig: layoutConfig().fit(),
        padding: { left: 20, right: 20, top: 20, bottom: 20 },
      }),
      text({
        text: "Write Clipboard",
        textSize: 20,
        backgroundColor: Color.parse("#70a1ff"),
        textColor: Color.WHITE,
        onClick: async () => {
          await clipboard(this.context).write("From doric plugin");
        },
        layoutConfig: layoutConfig().fit(),
        padding: { left: 20, right: 20, top: 20, bottom: 20 },
      }),
    ])
      .apply({
        layoutConfig: layoutConfig().fit().configAlignment(Gravity.Center),
        space: 20,
        gravity: Gravity.Center,
      })
      .in(rootView);
  }
}
