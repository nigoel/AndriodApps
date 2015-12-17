package com.example.nigoel.stayintouch;

import android.graphics.Color;
import android.widget.Button;

/**
 * Created by nigoel on 12/17/2015.
 */
public class CardPrint {
    private String icon;
    private int color;

    public CardPrint(int i) {
        icon = Integer.toString(i);
        color = i;
    }

    public static CardPrint getNewCardPrint() {
        return new CardPrint(0);
    }

    public Button buttonView(MainActivity mainActivity) {
        Button button = new Button(mainActivity);
        button.setId(color);
        button.setBackgroundColor(color);
        button.setText(icon);
        return button;
    }
};
