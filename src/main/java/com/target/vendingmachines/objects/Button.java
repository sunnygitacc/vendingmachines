package com.target.vendingmachines.objects;

/**
 * Created by Sunil Kata on 7/14/2017.
 */
public class Button {
    int buttonId;
    boolean isPressed = false;

    public Button(int buttonId) {
        this.buttonId = buttonId;
    }

    public int getButtonId() {
        return buttonId;
    }

    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }
}
