package org.blacksmith;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
    private JFrame jframe;
    private static Canvas canvas;
    private String title;
    private int width, height;

    public Display() {
        title = "LOL";
        width = 1700;
        height = 900;
        initCanvas();
    }

    private void initCanvas() {

        jframe = new JFrame(title);
        jframe.setSize(width, height);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        jframe.add(canvas);
        jframe.pack();

    }

    public Canvas getCanvas() {

        if(canvas == null)
        {
            System.out.println("Canvas is null");
            return null;
        }

        return canvas;
    }
}
