package com.teng.snake.v1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Yard extends Frame {
    //写成单例
    public static final Yard INSTANCE = new Yard();

    private final static int ROWS = 20;
    private final static int COLS = 20;
    private final static int BLOCK_SIZE = 30;
    private final static int GAME_WIDTH = COLS * BLOCK_SIZE; //600
    private final static int GAME_HEIGHT = ROWS * BLOCK_SIZE; //600

    private Yard() {
        this.setTitle("贪吃蛇");
        this.setLocation(350, 10);
        //这个size需要比 GAME_WIDTH和GAME_HEIGHT大
        this.setSize(650, 675);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    //从写父类Frame中的paint()方法

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.headUp, 100, 100, null);
    }



    //消除闪烁，需要把位置定好
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(700, 650);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(25, 50, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }


}
