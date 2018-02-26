package com.fyx.leon.fyx_leon.bean;

import java.io.Serializable;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/23<p>
 * <p>更改时间：2018/2/23<p>
 * <p>版本号：1<p>
 */
public class Hpbean implements Serializable{
    private int type = 1;//默认是1  加载item

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
