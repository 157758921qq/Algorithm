package com.teng.snake.v4;

public class Main {
    public static void main(String[] args) {
        Yard.INSTANCE.setVisible(true);

        new Thread(() -> {
            while (true) {
                Yard.INSTANCE.repaint();
                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
