package com.teng.snake.v6;

import com.teng.snake.v6.collide.Collider;
import com.teng.snake.v6.collide.SnakeCollidesWithFood;
import com.teng.snake.v6.collide.SnakeCollidesWithSnakeBody;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GameModel {
    public static final GameModel INSTANCE = new GameModel();
    //初始化一条Snake
    private List<AbstractGameObject> objects;
    private Snake snake;
    private Food food;
    private Collider SnakeCollidesWithFood = new SnakeCollidesWithFood();
    private SnakeCollidesWithSnakeBody scsb = new SnakeCollidesWithSnakeBody();


    private GameModel() {
        snake = new Snake();
        food = new Food();
        initGame();
    }

    private void initGame() {
        objects = new ArrayList<>();
        objects.add(snake);
        objects.add(food);
    }


    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.DARK_GRAY);
        //画出格子
        //1、先画出横行
//        g.drawLine(50+0,50+0, 50+BLOCK_SIZE * COLS, 50+0);

        //2、画出竖行
//        g.drawLine(50 +0, 50 + 0, 50+0, 50+BLOCK_SIZE * ROWS);

        //对于小白，可以先手动画出一根根的线
        //画对了，再寻求通过循环来画出所有的横线和竖线
        // 循序渐进
        for (int i = 0; i <= Yard.ROWS; i++) {
            //第一条线的起始坐标(50，50) ----终点坐标（675，50）
            g.drawLine(50, 50 + Yard.BLOCK_SIZE * i, 50 + Yard.COLS * Yard.BLOCK_SIZE, 50 + Yard.BLOCK_SIZE * i);
        }

        for (int i = 0; i <= Yard.COLS; i++) {
            g.drawLine(50 + Yard.BLOCK_SIZE * i, 50, 50 + Yard.BLOCK_SIZE * i, 50 + Yard.BLOCK_SIZE * Yard.ROWS);
        }
        g.setColor(c);



        for (int i = 0; i < objects.size(); i++) {
            AbstractGameObject go1 = objects.get(i);
            if (go1 instanceof Snake) {
                Snake s = (Snake) go1;
                s.draw(g);
            }
            if (go1 instanceof Food) {
                Food f = (Food) go1;
                f.draw(g);
            }
        }

        //蛇和Food画出来后，检测蛇和Food的碰撞
        for (int i = 0; i < objects.size(); i++) {
            AbstractGameObject go1 = objects.get(i);
            scsb.collide(go1);
            for (int j = 0; j < objects.size(); j++) {
                AbstractGameObject go2 = objects.get(j);
                this.SnakeCollidesWithFood.collide(go1, go2);
            }
        }
    }


    public Snake getSnake() {
        return this.snake;
    }
}

