package ru.gb.jtwo.la.online.circles;

import java.awt.*;

public class Background {


    protected void setColor(MainCanvas canvas){
        Color color = new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255)
        );

        canvas.setBackground(color);

    }

}
