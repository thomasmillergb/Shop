package com.thomasmillergb.shop.offer;

import java.math.BigDecimal;

/**
 * @author Thomas
 *         Created by Thomas on 07/12/2016.
 */
public interface Offer {
    BigDecimal execute(int amountItems);
}
