package com.teng.snake.v5;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Yard extends Frame {
    //写成单例
    public static final Yard INSTANCE = new Yard();
    public final static int ROWS = 25;
    public final static int COLS = 25;
    public final static int BLOCK_SIZE = 25;
    private final static int GAME_WIDTH = COLS * BLOCK_SIZE; //600
    private final static int GAME_HEIGHT = ROWS * BLOCK_SIZE; //600



    private Yard() {
        this.setTitle("贪吃蛇");
        this.setLocation(350, 10);
        //这个size需要比 GAME_WIDTH和GAME_HEIGHT大
        this.setSize(700, 700);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //对键盘的监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                GameModel.INSTANCE.getSnake().keyPressed(e);
            }
        });
    }


    //从写父类Frame中的paint()方法

    @Override
    public void paint(Graphics g) {
        GameModel.INSTANCE.draw(g);
    }


    //消除闪烁，需要把位置定好
    //这个窗体 距离  Frame窗口的右上角坐标是（50， 50）
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(50 + GAME_WIDTH, 50 + GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.WHITE);
        gOffScreen.fillRect(50, 50, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }


}
