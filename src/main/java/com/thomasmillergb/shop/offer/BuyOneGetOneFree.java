package com.thomasmillergb.shop.offer;

import com.thomasmillergb.shop.item.Item;

import java.math.BigDecimal;

/**
 * @author Thomas
 *         Created by Thomas on 07/12/2016.
 */
public class BuyOneGetOneFree implements Offer {

    private Item item_;

    public BuyOneGetOneFree(Item item) {
        item_ = item;
    }

    @Override
    public BigDecimal execute(int amountItems) {
        return item_.getAmount().multiply(BigDecimal.valueOf(Math.ceil((double) amountItems / 2)));
    }
}
