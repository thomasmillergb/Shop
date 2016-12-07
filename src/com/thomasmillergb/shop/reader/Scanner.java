package com.thomasmillergb.shop.reader;

import com.thomasmillergb.shop.item.Item;
import com.thomasmillergb.shop.offer.Offer;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author Thomas
 *         Created by Thomas on 07/12/2016.
 */
public class Scanner {

    private Map<String, Item> avliableItems_;
    private Map<Item, Offer> offer_;

    public Scanner(Map<String, Item> avliableItems, Map<Item, Offer> offer) {
        avliableItems_ = avliableItems;
        offer_ = offer;
    }

    public BigDecimal scan(String items) {
        List<Item> soldItems = Parser.parseItems(avliableItems_, items);
        Map<Item, Integer> sumItems = new HashMap<>();
        soldItems.forEach(item -> sumSoldItem(sumItems, item));
        System.out.println("Sold Items: " +sumItems);
        BigDecimal totalOutstandingBalance = totalOutstandingBalance(sumItems);
        System.out.println("Outstanding Balance: " +totalOutstandingBalance);
        return totalOutstandingBalance;
    }

    private BigDecimal totalOutstandingBalance(Map<Item, Integer> soldItems) {
        BigDecimal totalBalance = new BigDecimal(0);
        for (Item item : soldItems.keySet()) {
            Integer sold = soldItems.get(item);
            if (offer_.containsKey(item)) {
                totalBalance = totalBalance.add(offer_.get(item).execute(sold));
            } else {
                totalBalance = totalBalance.add(item.getAmount().multiply(new BigDecimal(sold)));
            }
        }
        return totalBalance;
    }

//    public BigDecimal totalOutstandingBalance(List<Item> soldItems){
//
//        return soldItems.stream()
//                .map(Item::getAmount)
//                .reduce(BigDecimal::add)
//                .get();
//    }

    private void sumSoldItem(Map<Item, Integer> map, Item item) {
        if (map.containsKey(item)) {
            map.put(item, map.get(item) + 1);
        } else {
            map.put(item, 1);
        }
    }

}
