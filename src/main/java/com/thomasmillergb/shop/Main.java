package com.thomasmillergb.shop;

import com.thomasmillergb.shop.item.Item;
import com.thomasmillergb.shop.offer.BuyOneGetOneFree;
import com.thomasmillergb.shop.offer.BuyTwoGetOneFree;
import com.thomasmillergb.shop.offer.Offer;
import com.thomasmillergb.shop.reader.Scanner;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class);

    @Autowired
    Scanner scanner_;
    private Main(String[] args){
        go(args);
    }

    private void go(String[] args){
        if (args.length > 0) {
            //Set bucket to 10 to improve hashmap perforce
            Scanner  scanner = new Scanner();
            Item apple = new Item("apple", new BigDecimal("0.60"));
            Item orange = new Item("orange", new BigDecimal("0.25"));
            scanner.addAvliableItem("apple", apple);
            scanner.addAvliableItem("orange", orange);
            scanner.addOffer(apple, new BuyOneGetOneFree(apple));
            scanner.addOffer(orange, new BuyTwoGetOneFree(orange));


            scanner.scan(args[0]);
        }
        else{
            LOGGER.warn("Need items!");
        }
    }

    // Scanner Test in reader.ScannerTest
    // Provide String of items ("apple,orange.ect")
    public static void main(String[] args) {
        Main Main = new Main(args);
    }

}
