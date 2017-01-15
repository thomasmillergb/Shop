package com.thomasmillergb.shop.reader;


import com.thomasmillergb.shop.item.Item;
import com.thomasmillergb.shop.offer.BuyOneGetOneFree;
import com.thomasmillergb.shop.offer.BuyTwoGetOneFree;
import com.thomasmillergb.shop.offer.Offer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author Thomas
 *         Created by Thomas on 07/12/2016.
 *         Some tests to make sure the app fits the spec
 */
public class ScannerTest {

    private Map<String, Item> items_;
    private Map<Item, Offer> offers_;
    private Scanner scanner_;

    @Before
    public void setUp(){
        //Set buckget to 10 to improve hashmap performce
        items_ = new HashMap<>(10);
        offers_ = new HashMap<>(10);
        Item apple = new Item("apple", new BigDecimal("0.60"));
        Item orange = new Item("orange", new BigDecimal("0.25"));
        items_.put("apple",apple);
        items_.put("orange", orange);
        offers_.put(apple, new BuyOneGetOneFree(apple));
        offers_.put(orange, new BuyTwoGetOneFree(orange));
        scanner_ = new Scanner(items_, offers_);
    }
    @Test
    public void scanApple(){
        Assert.assertEquals(new BigDecimal("0.60"),scanner_.scan("apple").setScale(2));

    }
    @Test
    public void scanAppleCap(){
        Assert.assertEquals(new BigDecimal("0.60"),scanner_.scan("Apple").setScale(2));

    }
    @Test
    public void scanOrange(){
        Assert.assertEquals(new BigDecimal("0.25"),scanner_.scan("orange").setScale(2));

    }
    @Test
    public void scanRubbish(){
        Assert.assertEquals(new BigDecimal("0.60"),scanner_.scan("apple,asda,adadadad").setScale(2));

    }
    @Test
    public void scanWhiteSpace(){
        Assert.assertEquals(new BigDecimal("0.60"),scanner_.scan("apple ,").setScale(2));

    }

    @Test
    public void scanApplyBuyOneGetOneFree(){
        Assert.assertEquals(new BigDecimal("1.20"),scanner_.scan("apple,apple,apple,apple").setScale(2));
    }

    @Test
    public void scanApplyBuyOneGetOneFreePlusOne(){
        Assert.assertEquals(new BigDecimal("1.80"),scanner_.scan("apple,apple,apple,apple,apple").setScale(2));
    }

    @Test
    public void scanOrangeDisscount(){
        Assert.assertEquals(new BigDecimal("0.50"),scanner_.scan("orange,orange,orange").setScale(2));

    }
    @Test
    public void scanOrangeDisscountPlusOne(){
        Assert.assertEquals(new BigDecimal("0.75"),scanner_.scan("orange,orange,orange,orange").setScale(2));

    }
    @Test
    public void scanAppleOrangeDisscount(){
        Assert.assertEquals(new BigDecimal("1.95"),scanner_.scan("apple,apple,apple,apple,orange,orange,orange,orange").setScale(2));

    }
}