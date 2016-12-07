package com.thomasmillergb.shop;

import com.thomasmillergb.shop.item.Item;
import com.thomasmillergb.shop.offer.BuyOneGetOneFree;
import com.thomasmillergb.shop.offer.BuyTwoGetOneFree;
import com.thomasmillergb.shop.offer.Offer;
import com.thomasmillergb.shop.reader.Scanner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0) {
            Map<String, Item> items;
            Map<Item, Offer> offers;
            Scanner scanner;
            items = new HashMap<>();
            offers = new HashMap<>();
            Item apple = new Item("apple", new BigDecimal("0.60"));
            Item orange = new Item("orange", new BigDecimal("0.25"));
            items.put("apple", apple);
            items.put("orange", orange);
            offers.put(apple, new BuyOneGetOneFree(apple));
            offers.put(orange, new BuyTwoGetOneFree(orange));
            scanner = new Scanner(items, offers);

            scanner.scan(args[0]);
        }
        else{
            System.out.println("Need items!");
        }
    }

}
