package com.dexlace.pattern;


import com.dexlace.scene.Material;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 装修包
 */
public class DecorationPackageMenu implements IMenu {

    /**
     * 创造者模式最主要的东西就是把需要的物料随时组合起来并返回出去
     * 以下的list是组合的清单
     * 可以把想象成点餐的过程
     */
    private List<Material> list = new ArrayList<>();  // 装修清单
    private BigDecimal price = BigDecimal.ZERO;      // 装修价格

    private BigDecimal area;  // 面积
    private String grade;     // 装修等级；豪华欧式、轻奢田园、现代简约

    private DecorationPackageMenu() {
    }

    /**
     * 一个菜单的两个主要的参数
     * @param area 面积
     * @param grade 装修等级
     */
    public DecorationPackageMenu(Double area, String grade) {
        this.area = new BigDecimal(area);
        this.grade = grade;
    }

    /**
     * 以下几个方法就是模拟你在点餐的过程：不停的点菜
     * 即一个过程，或者说一个组合，记住
     * 创建者模式的关键词就是组合
     * 然后生成对象的方式是组合的结果
     * @param material 你点的东西
     * @return 每点一个都形成一个菜单
     */
    public IMenu appendCeiling(Material material) {
        list.add(material);
        price = price.add(area.multiply(new BigDecimal("0.2")).multiply(material.price()));
        return this;
    }

    public IMenu appendCoat(Material material) {
        list.add(material);
        price = price.add(area.multiply(new BigDecimal("1.4")).multiply(material.price()));
        return this;
    }

    public IMenu appendFloor(Material material) {
        list.add(material);
        price = price.add(area.multiply(material.price()));
        return this;
    }

    public IMenu appendTile(Material material) {
        list.add(material);
        price = price.add(area.multiply(material.price()));
        return this;
    }

    public String getDetail() {

        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "装修清单" + "\r\n" +
                "套餐等级：" + grade + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");

        for (Material matter: list) {
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、平米价格：").append(matter.price()).append(" 元。\n");
        }

        return detail.toString();
    }

}
