package com.thomasmillergb.shop.reader;


import com.thomasmillergb.shop.item.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Thomas
 *         Created by Thomas on 07/12/2016.
 */
public class ScannerTest {

    private Map<String, Item> items_;
    private Scanner scanner_;

    @Before
    public void setUp() {
        items_ = new HashMap<>();
        Item apple = new Item("apple", new BigDecimal("0.60"));
        Item orange = new Item("orange", new BigDecimal("0.25"));
        items_.put("apple", apple);
        items_.put("orange", orange);
        scanner_ = new Scanner(items_);
    }

    @Test
    public void scanApple() {
        Assert.assertEquals(new BigDecimal("0.60"), scanner_.scan("apple").setScale(2));

    }

    @Test
    public void scanOrange() {
        Assert.assertEquals(new BigDecimal("0.25"), scanner_.scan("orange").setScale(2));

    }

    @Test
    public void scanRubbish() {
        Assert.assertEquals(new BigDecimal("0.60"), scanner_.scan("apple,asda,adadadad").setScale(2));

    }

    @Test
    public void scanWhiteSpace() {
        Assert.assertEquals(new BigDecimal("0.60"), scanner_.scan("apple ,").setScale(2));

    }


}