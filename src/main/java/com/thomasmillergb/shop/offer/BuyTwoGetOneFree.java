package com.thomasmillergb.shop.offer;

import com.thomasmillergb.shop.item.Item;
import com.thomasmillergb.shop.reader.Scanner;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author Thomas
 *         Created by Thomas on 07/12/2016.
 */
public class BuyTwoGetOneFree implements Offer {

    private Item item_;

    public BuyTwoGetOneFree(Item item) {
        item_ = item;
    }

    @Override
    public BigDecimal execute(int amountItems) {
        int setOfThree = (int) Math.floor((double)amountItems / 3);
        int remainder = amountItems % 3;
        BigDecimal discounted = item_.getAmount()
                .multiply(new BigDecimal(setOfThree))
                .multiply(new BigDecimal(2));
        BigDecimal notDiscounted = item_.getAmount().multiply(new BigDecimal(remainder));
        return discounted.add(notDiscounted);
    }
}
