package com.teng.snake.v6.collide;

import com.teng.snake.v6.AbstractGameObject;

public interface Collider {
    void collide(AbstractGameObject go1, AbstractGameObject go2);
}
