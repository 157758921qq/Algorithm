package com.teng.snake.v6.collide;

import com.teng.snake.v6.AbstractGameObject;

import com.teng.snake.v6.Main;
import com.teng.snake.v6.Snake;

public class SnakeCollidesWithSnakeBody {

    public void collide(AbstractGameObject go1) {
        if (go1 instanceof Snake) {
            Snake snake = (Snake) go1;
            for (Snake.Node n = snake.head.next; n != null; n = n.next) {
                if (snake.head.row == n.row && snake.head.col == n.col) {
                    //蛇头与蛇身发生碰撞
                    System.out.println("Snake Collides with SnakeBody");
                }
            }
        }
    }
}
