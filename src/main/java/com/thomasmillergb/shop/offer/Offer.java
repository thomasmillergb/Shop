package com.thomasmillergb.shop.offer;

import java.math.BigDecimal;

/**
 * @author Thomas
 *         Created by Thomas on 07/12/2016.
 *         A iterfance to excute offers
 */
public interface Offer {
    // Execute the office
    BigDecimal execute(int amountItems);
}
