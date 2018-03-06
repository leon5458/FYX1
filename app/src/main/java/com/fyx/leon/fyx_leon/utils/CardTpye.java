package com.fyx.leon.fyx_leon.utils;

import com.fyx.leon.fyx_leon.ui.R;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/3/6<p>
 * <p>更改时间：2018/3/6<p>
 * <p>版本号：1<p>
 */
public class CardTpye {

    public static int getCardUse(int cardType) {
        int type = R.mipmap.bg;

        switch (cardType) {
            case 1:
                type = R.mipmap.img;
                break;
            case 2:
                type = R.mipmap.imgs;
                break;
            case 3:
                type = R.mipmap.bg;
                break;
            case 4:
                type = R.mipmap.imgs;
                break;
        }
        return type;
    }

}
