package com.thomasmillergb.shop.reader;

import com.thomasmillergb.shop.item.Item;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Thomas Created by Thomas on 07/12/2016.
 */
public class Parser
{
    private final static Logger LOGGER = Logger.getLogger(Parser.class);

    /**
     * @param avliableItems the aviable items
     * @param stringItems   the string of items which have been sold
     * @return all the items which are aviable
     */
    public static List<Item> parseItems(Map<String, Item> avliableItems, final String stringItems)
    {
        List<Item> items = new LinkedList<>();
        Arrays.stream(stringItems.split(",")).forEach(strItem -> {
            String formated = strItem.replace(" ", "").toLowerCase();
            if (avliableItems.containsKey(formated)) {
                items.add(avliableItems.get(formated));
            } else {
                LOGGER.error(formated + " cannot be found, will ignore item");
            }
        });
        return items;
    }
}
