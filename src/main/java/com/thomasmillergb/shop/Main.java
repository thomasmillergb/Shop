package com.thomasmillergb.shop;

import com.thomasmillergb.shop.item.Item;
import com.thomasmillergb.shop.offer.BuyOneGetOneFree;
import com.thomasmillergb.shop.offer.BuyTwoGetOneFree;
import com.thomasmillergb.shop.offer.Offer;
import com.thomasmillergb.shop.reader.Scanner;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class);
    // Scanner Test in reader.ScannerTest
    // Provide String of items ("apple,orange.ect")
    public static void main(String[] args) {
        if (args.length > 0) {
            //Set bucket to 10 to improve hashmap perforce
            Map<String, Item> items = new HashMap<>(10);
            Map<Item, Offer> offers = new HashMap<>(10);
            Item apple = new Item("apple", new BigDecimal("0.60"));
            Item orange = new Item("orange", new BigDecimal("0.25"));
            items.put("apple", apple);
            items.put("orange", orange);
            offers.put(apple, new BuyOneGetOneFree(apple));
            offers.put(orange, new BuyTwoGetOneFree(orange));
            Scanner  scanner = new Scanner(items, offers);

            scanner.scan(args[0]);
        }
        else{
            LOGGER.warn("Need items!");
        }
    }

}
