package com.dexlace.pattern;

import com.dexlace.scene.Material;

public interface IMenu {

    /**
     * 吊顶
     */
    IMenu appendCeiling(Material material);

    /**
     * 涂料
     */
    IMenu appendCoat(Material material);

    /**
     * 地板
     */
    IMenu appendFloor(Material material);

    /**
     * 地砖
     */
    IMenu appendTile(Material material);

    /**
     * 明细
     */
    String getDetail();

}
