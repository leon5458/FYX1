package com.fyx.leon.fyx_leon.bean;

import java.io.Serializable;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/3/6<p>
 * <p>更改时间：2018/3/6<p>
 * <p>版本号：1<p>
 */
public class Card implements Serializable {
    private int CardType;//卡类型

    public int getCardType() {
        return CardType;
    }

    public void setCardType(int cardType) {
        CardType = cardType;
    }

    @Override
    public String toString() {
        return "Card{" +
                "CardType=" + CardType +
                '}';
    }
}
