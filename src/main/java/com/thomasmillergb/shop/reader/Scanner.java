package com.thomasmillergb.shop.reader;

import com.thomasmillergb.shop.item.Item;
import com.thomasmillergb.shop.offer.Offer;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author Thomas
 *         Created by Thomas on 07/12/2016.
 */
public class Scanner {

    private final static Logger LOGGER = Logger.getLogger(Scanner.class);
    private Map<String, Item> avliableItems_;
    private Map<Item, Offer> offer_;


    public Scanner(Map<String, Item> avliableItems, Map<Item, Offer> offer) {
        avliableItems_ = avliableItems;
        offer_ = offer;
    }

    /**
     *
     * @param items the input of items which have been sold
     * @return the total balance
     */
    public BigDecimal scan(String items) {
        List<Item> soldItems = Parser.parseItems(avliableItems_, items);
        //Set bucket to 10 to improve hashmap perforce
        Map<Item, Integer> sumItems = new HashMap<>(10);
        soldItems.forEach(item -> sumSoldItem(sumItems, item));
        LOGGER.info("Sold Items: " +sumItems);
        BigDecimal totalOutstandingBalance = totalOutstandingBalance(sumItems);
        LOGGER.info("Outstanding Balance: " +totalOutstandingBalance);
        return totalOutstandingBalance;
    }

    /**
     *
     * @param soldItems a map of sold items
     * @return the total outstanding balance
     */
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

    /**
     *
     * @param map a map of the sold items
     * @param item the item to sum
     */
    private void sumSoldItem(Map<Item, Integer> map, Item item) {
        if (map.containsKey(item)) {
            map.put(item, map.get(item) + 1);
        } else {
            map.put(item, 1);
        }
    }

}
