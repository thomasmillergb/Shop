package com.thomasmillergb.shop.item;

import java.math.BigDecimal;

/**
 * @author Thomas
 *         Created by Thomas on 07/12/2016.
 */
public class Item
{
    private String     name_;
    private BigDecimal amount_;

    public Item(String name, BigDecimal amount)
    {
        name_ = name;
        amount_ = amount;
    }

    public String getName()
    {
        return name_;
    }

    public BigDecimal getAmount()
    {
        return amount_;
    }

    //Override default equals
    @Override
    public boolean equals(Object obj)
    {
        if (obj != null && obj instanceof Item) {
            Item item = (Item)obj;
            return name_.equals(item.getName()) && amount_.equals(item.getAmount());
        }
        else {
            return false;
        }
    }

    //Override hashcode, would normally use apache commons for guava for this
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (name_ != null ? name_.hashCode() : 0);
        result = 31 * result + (amount_ != null ? amount_.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Item{" + "name_='" + name_ + '\'' + ", amount_=" + amount_ + '}';
    }
}
