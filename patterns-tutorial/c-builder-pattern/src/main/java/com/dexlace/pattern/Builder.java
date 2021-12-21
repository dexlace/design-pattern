package com.dexlace.pattern;


import com.dexlace.scene.ceiling.LevelOneCeiling;
import com.dexlace.scene.ceiling.LevelTwoCeiling;
import com.dexlace.scene.coat.DuluxCoat;
import com.dexlace.scene.coat.LiBangCoat;
import com.dexlace.scene.floor.ShengXiangFloor;
import com.dexlace.scene.tile.DongPengTile;
import com.dexlace.scene.tile.MarcoPoloTile;

public class Builder {

    /**
     * 以下即一些定制化的菜单
     * @param area 你自己选择即可 可以随意选择
     * @return 菜单
     */
    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                .appendCeiling(new LevelTwoCeiling())    // 吊顶，二级顶
                .appendCoat(new DuluxCoat())             // 涂料，多乐士
                .appendFloor(new ShengXiangFloor());     // 地板，圣象
    }

    public IMenu levelTwo(Double area){
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public IMenu levelThree(Double area){
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }

}
