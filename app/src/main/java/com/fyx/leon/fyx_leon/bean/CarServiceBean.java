package com.fyx.leon.fyx_leon.bean;

import java.io.Serializable;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/6<p>
 * <p>更改时间：2018/2/6<p>
 * <p>版本号：1<p>
 */
public class CarServiceBean implements Serializable{
    private int img;
    private String text;


    public CarServiceBean(int img, String text){
        this.img = img;
        this.text = text;

    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
