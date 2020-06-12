package com.teng.snake.v6;

import java.awt.*;
import java.util.Random;

public class Food extends AbstractGameObject {
    private int row, col;
    private int width;
    private int height;
    private Rectangle rectangle;
    private static Random r = new Random();


    public Food() {
        //这个行、列怎么定？
        this(r.nextInt(Yard.ROWS - 5) + 3, r.nextInt(Yard.COLS - 5) + 3);
    }

    //Food的位置是不变的
    public Food(int row, int col) {
        this.row = row;
        this.col = col;
        this.width = Yard.BLOCK_SIZE;
        this.height = Yard.BLOCK_SIZE;
        this.rectangle = new Rectangle(Yard.BLOCK_SIZE * col, Yard.BLOCK_SIZE * row, width, height);
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.drawRect(Yard.BLOCK_SIZE * col, Yard.BLOCK_SIZE * row, width, height);
        g.setColor(c);
        g.drawImage(ResourceMgr.food, Yard.BLOCK_SIZE * col, Yard.BLOCK_SIZE * row, null);
    }

    //新出现一个Food
    public void reAppear() {
        this.row = r.nextInt(Yard.ROWS - 5) + 3;
        this.col = r.nextInt(Yard.COLS - 5) + 3;
        this.rectangle.x = Yard.BLOCK_SIZE * col;
        this.rectangle.y = Yard.BLOCK_SIZE * row;
    }
}
