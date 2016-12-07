package com.thomasmillergb.shop.item;

import java.math.BigDecimal;

/**
 * @author Thomas
 *         Created by Thomas on 07/12/2016.
 */
public class Item {
    private String name_;
    private BigDecimal amount_;

    public Item(String name, BigDecimal amount) {
        name_ = name;
        amount_ = amount;
    }

    public String getName() {
        return name_;
    }

    public BigDecimal getAmount() {
        return amount_;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name_='" + name_ + '\'' +
                ", amount_=" + amount_ +
                '}';
    }
}
