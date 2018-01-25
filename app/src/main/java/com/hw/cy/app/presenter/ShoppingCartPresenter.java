package com.hw.cy.app.presenter;

import com.htt.framelibrary.mvp.BasePresenter;
import com.hw.cy.app.model.ShoppingCartEntity;
import com.hw.cy.app.view.activity.ShoppingCartActivity;
import com.hw.cy.app.view.adapter.ShoppingCartAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ithtt on 2018/1/24.
 */

public class ShoppingCartPresenter extends BasePresenter<ShoppingCartActivity> {

    public List<ShoppingCartEntity> getUserShoppingCartList() {
        List<ShoppingCartEntity> list = new ArrayList<>(6);
        ShoppingCartEntity item;
        for (int j = 0; j < 20; j++) {
            item = new ShoppingCartEntity();
            item.setType(ShoppingCartAdapter.TYPE_SHOPPING_CART_GOOD);
            if (j % 2 == 0) {
                item.setPrices(129f);
                item.setGoodName("壳牌（Shell） 黄喜力矿物质机油 Helix HX510W -40 SN级 4L");
                item.setGoodIcon("https://img12.360buyimg.com/n2/jfs/t14227/138/1904944804/102214/b8ba90fa/5a67f608N759e2569.jpg");
            } else {
                item.setPrices(469f);
                item.setGoodName("固特异（Goodyear）轮胎/汽车轮胎 205/55R16 91W F1 Directional5 适配本田思...");
                item.setGoodIcon("https://img.alicdn.com/bao/uploaded/i4/1718241991/TB1l3j7atLO8KJjSZPcXXaV0FXa_!!0-item_pic.jpg_b.jpg");
            }
            list.add(item);
        }


        return list;
    }
}
