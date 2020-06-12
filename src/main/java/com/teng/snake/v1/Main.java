package com.teng.snake.v1;

public class Main {
    public static void main(String[] args) {
       Yard.INSTANCE.setVisible(true);

        new Thread(() -> {
            try {
                Thread.sleep(350);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Yard.INSTANCE.repaint();
        } ).start();
    }
}
