package com.teng.snake.v7.collide;

import com.teng.snake.v7.AbstractGameObject;

public interface Collider {
    void collide(AbstractGameObject go1, AbstractGameObject go2);
}
