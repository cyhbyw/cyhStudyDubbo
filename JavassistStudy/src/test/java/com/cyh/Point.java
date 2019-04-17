package com.cyh;

/**
 * @author: yanhua.chen
 * @date: 2019/4/17 17:21
 */
public class Point {

    int x, y;

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
        System.out.println(dx + "---->" + dy);
    }

}
