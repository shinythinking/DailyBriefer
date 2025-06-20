package shinythinking.view;

import java.awt.*;

enum Status {
    DONE("Done!!", Color.GREEN),
    NOT_YET("NOT YET!", Color.RED),
    WRONG("WRONG URL!", Color.MAGENTA);

    private final String msg;
    private final Color color;

    Status(String msg, Color color) {
        this.msg = msg;
        this.color = color;
    }

    public String getMsg() {
        return msg;
    }

    public Color getColor() {
        return color;
    }
}