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
public class Parser
{
    /**
     * @param avliableItems the aviable items
     * @param stringItems the string of items which have been sold
     * @return all the items which are aviable
     */
    public static List<Item> parseItems(Map<String, Item> avliableItems, final String stringItems)
    {
        List<Item> items = new LinkedList<>();
        Arrays.stream(stringItems.split(",")).forEach(strItem -> {
            String formated = strItem.replace(" ", "").toLowerCase();
            if (avliableItems.containsKey(formated))
                items.add(avliableItems.get(formated));
            else {
                System.out.println(formated + " cannot be found, will ignore item");
            }
        });
        return items;
    }
}
