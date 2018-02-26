package com.fyx.leon.fyx_leon.utils;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/23<p>
 * <p>更改时间：2018/2/23<p>
 * <p>版本号：1<p>
 */
public class Contact {
    private String index;
    private String name;
    public Contact(String index,String name){
        this.index = index;
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
