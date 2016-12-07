package com.thomasmillergb.shop.reader;

import com.thomasmillergb.shop.item.Item;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Thomas
 *         Created by Thomas on 07/12/2016.
 */
public class Parser {

    public static List<Item> parseItems(Map<String, Item> avliableItems, String stringItems) {
        List<Item> items = new LinkedList<>();
        Arrays.stream(stringItems.split(","))
                .forEach(strItem -> {
                            String formated = strItem.replace(" ", "");
                            if (avliableItems.containsKey(formated))
                                items.add(avliableItems.get(formated));
                        }
                );
        return items;

    }


}
