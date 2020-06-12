package com.teng.snake.v6;

import com.teng.snake.v6.collide.Collider;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Snake extends AbstractGameObject {
    //Snake是由一节一节的Node组成的
    //初始化蛇，由2个结点组成 head 和 tail
    public Node head;
    private Node tail;
    private int size;
    private Node node1 = new Node(10, 10, Dir.R);
    private Node node2 = new Node(10, 9, Dir.R);
    private Rectangle rectangle;

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Node getHead() {
        return head;
    }

    public Snake() {
        this.head = node1;
        this.tail = node2;
        //需要将这2个node通过指针关联起来
        head.next = tail;
        tail.prev = head;
        this.size = 2;
        this.rectangle = new Rectangle(50 + (head.col) * Yard.BLOCK_SIZE, 50 + (head.row) * Yard.BLOCK_SIZE, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
    }


    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        //根据蛇头的方向画出这个head
//        g.drawRect(50 + head.col * Yard.BLOCK_SIZE, 50 + head.row * Yard.BLOCK_SIZE, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
//        g.drawRect(rectangle.x, rectangle.y, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
        //根据蛇头的方向画出这个head
//        switch (head.dir) {
//            case L:
//                g.drawRect(50 + (head.col - 1) * Yard.BLOCK_SIZE, 50 + head.row * Yard.BLOCK_SIZE, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
//                break;
//            case U:
//                g.drawRect(50 + head.col * Yard.BLOCK_SIZE, 50 + (head.row - 1) * Yard.BLOCK_SIZE, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
//                break;
//            case R:
//                g.drawRect(50 + (head.col + 1) * Yard.BLOCK_SIZE, 50 + head.row * Yard.BLOCK_SIZE, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
//                break;
//            case D:
//                g.drawRect(50 + head.col * Yard.BLOCK_SIZE, 50 + (head.row + 1) * Yard.BLOCK_SIZE, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
//                break;
//        }
        g.drawRect(rectangle.x, rectangle.y, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
        g.setColor(c);

        System.out.println("paint!");
        if (size <= 0) return;
        //键盘控制的更加灵敏
        move();
        //从头开始遍历整个数组，将里面的每个node画出来
        for (Node n = head; n != null; n = n.next) {
            n.draw(g);
        }

    }


    //蛇的运动是关键
    public void move() {

        //移动后
        //根据Snake头的方向得到运动中的Snake的head的Rectangle
//       这样写是有bug的
//        rectangle.x = head.col * Yard.BLOCK_SIZE;
//        rectangle.y = head.row * Yard.BLOCK_SIZE;
        //此时只能根据Snake.head的方向来处理
        switch (head.dir) {
            case L:
                rectangle.x = 50 + (head.col - 1) * Yard.BLOCK_SIZE;
                rectangle.y = 50 + head.row * Yard.BLOCK_SIZE;
                break;
            case U:
                rectangle.x = 50 + head.col * Yard.BLOCK_SIZE;
                rectangle.y = 50 + (head.row - 1) * Yard.BLOCK_SIZE;
                break;
            case R:
                rectangle.x = 50 + (head.col + 1) * Yard.BLOCK_SIZE;
                rectangle.y = 50 + head.row * Yard.BLOCK_SIZE;
                break;
            case D:
                rectangle.x = 50 + head.col * Yard.BLOCK_SIZE;
                rectangle.y = 50 + (head.row + 1) * Yard.BLOCK_SIZE;
                break;
        }
        addToHead();
        deleteFromTail();

    }

    private void deleteFromTail() {
        //注意逻辑：
        //1、将tail的前一个节点，设为tail
        //2、将tail的节点的prev，设为null
        if (size == 0) return;
        tail = tail.prev;
        tail.next = null;
    }

    public void addToTail() {
        Node node = null;
        //根据尾巴节点的方向，增加新节点
        //注意：新增节点的位置和方向
        switch (tail.dir) {
            case L:
                node = new Node(tail.row, tail.col + 1, tail.dir);
                break;
            case U:
                node = new Node(tail.row + 1, tail.col, tail.dir);
                break;
            case R:
                node = new Node(tail.row, tail.col - 1, tail.dir);
                break;
            case D:
                node = new Node(tail.row - 1, tail.col, tail.dir);
                break;
        }
        //重点：
        //new出新节点后，需要移动前驱节点指针
        tail.next = node;//将new出来的node节点赋值给tail的next指针
        node.prev = tail;
        tail = node;
        size++;
    }

    public void addToHead() {
        Node node = null;
        switch (head.dir) {
            case L:
                node = new Node(head.row, head.col - 1, head.dir);
                break;
            case U:
                node = new Node(head.row - 1, head.col, head.dir);
                break;
            case R:
                node = new Node(head.row, head.col + 1, head.dir);
                break;
            case D:
                node = new Node(head.row + 1, head.col, head.dir);
                break;
        }
        node.next = head;   //指针：node next 指向 head
        head.prev = node;   //指针：head prev 指向 node
        head = node;        //head 指向  node
        size++;            //长度加 1
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                if(this.head.dir != Dir.R){
                    this.head.dir = Dir.L;
                }
                break;
            case KeyEvent.VK_UP:
                if(this.head.dir != Dir.D){
                    this.head.dir = Dir.U;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(this.head.dir != Dir.L){
                    this.head.dir = Dir.R;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(this.head.dir != Dir.U){
                    this.head.dir = Dir.D;
                }
                break;
        }
    }


    public class Node {
        //这个节点的位置
        public int row, col;
        private int w = Yard.BLOCK_SIZE;
        private int h = Yard.BLOCK_SIZE;
        private Dir dir;
        public Node prev;
        public Node next;

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

