package com.kty.favocritlistmap;

public class favorit_list_VO {
    String item;
    double x;
    double y;
    public String getItem() {
        return item;
    }

    public favorit_list_VO(String item, double x, double y) {
        this.item = item;
        this.x = x;
        this.y = y;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}
