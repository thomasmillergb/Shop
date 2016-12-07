package com.thomasmillergb.shop.reader;

import com.thomasmillergb.shop.item.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Thomas
 *         Created by Thomas on 07/12/2016.
 */
public class Scanner {

    private Map<String, Item> avliableItems_;

    public Scanner(Map<String, Item> avliableItems) {
        avliableItems_ = avliableItems;
    }

    public BigDecimal scan(String items) {
        List<Item> soldItems = Parser.parseItems(avliableItems_, items);
        BigDecimal totalOutstandingBalance = totalOutstandingBalance(soldItems);
        System.out.println("Outstanding Balance: " + totalOutstandingBalance);
        return totalOutstandingBalance;
    }

    public BigDecimal totalOutstandingBalance(List<Item> soldItems) {

        return soldItems.stream()
                .map(Item::getAmount)
                .reduce(BigDecimal::add)
                .get();
    }


}
