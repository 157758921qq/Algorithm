package com.teng.snake.v7.collide;

import com.teng.snake.v7.AbstractGameObject;
import com.teng.snake.v7.Food;
import com.teng.snake.v7.Snake;

public class SnakeCollidesWithFood implements Collider {
    @Override
    public void collide(AbstractGameObject go1, AbstractGameObject go2) {
        if(go1 instanceof Snake && go2 instanceof Food){
            Snake s = (Snake) go1;
            Food f = (Food) go2;
            //蛇头和Food的发生碰撞
            if (s.getRectangle().intersects(f.getRectangle())){
                f.reAppear();
                s.addToHead();
            }

        }
        if(go1 instanceof Food && go2 instanceof Snake){
            collide(go2, go1);
        }

    }
}
