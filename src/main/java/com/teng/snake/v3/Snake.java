package com.teng.snake.v3;

import java.awt.*;

public class Snake {
    //Snake是由一节一节的Node组成的
    //初始化蛇，由2个结点组成 head 和 tail
    private Node head;
    private Node tail;
    private int size;

    Node node1 = new Node(10, 10, Dir.R);
    Node node2 = new Node(10, 9, Dir.R);

    public Snake() {
            this.head = node1;
            this.tail = node2;
            //需要将这2个node通过指针关联起来
            head.next = tail;
            tail.prev = head;
            this.size = 2;
    }


    public void draw(Graphics g) {
        if (size <= 0) return;
        //键盘控制的更加灵敏

        //从头开始遍历整个数组，将里面的每个node画出来
        for (Node n = head; n != null; n = n.next) {
            n.draw(g);
        }
    }


    //内部类
    class Node {
        //这个节点的位置
        private int row, col;
        private int w = Yard.BLOCK_SIZE;
        private int h = Yard.BLOCK_SIZE;
        private Dir dir;
        private Node prev;
        private Node next;

        //初始化
        public Node(int row, int col, Dir dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
        }

        //画自己
        public void draw(Graphics g) {
            //如果这个节点没有前驱，那就是头结点
            //头结点，根据方向画出蛇头的图片
            if (this.prev == null) {
                switch (dir) {
                    case L:
                        g.drawImage(ResourceMgr.headLeft, 50 + Yard.BLOCK_SIZE * col, 50 + Yard.BLOCK_SIZE * row, null);
                        break;
                    case U:
                        g.drawImage(ResourceMgr.headUp, 50 + Yard.BLOCK_SIZE * col, 50 + Yard.BLOCK_SIZE * row, null);
                        break;
                    case R:
                        g.drawImage(ResourceMgr.headRight, 50 + Yard.BLOCK_SIZE * col, 50 + Yard.BLOCK_SIZE * row, null);
                        break;
                    case D:
                        g.drawImage(ResourceMgr.headDown, 50 + Yard.BLOCK_SIZE * col, 50 + Yard.BLOCK_SIZE * row, null);
                        break;
                }
            } else //非蛇头，则画蛇身，这里没有区分，蛇身和蛇尾
                g.drawImage(ResourceMgr.body, 50 + Yard.BLOCK_SIZE * col, 50 + Yard.BLOCK_SIZE * row, null);

        }
    }


}

