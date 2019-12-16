package com.rj.cart;

import com.rj.item.Item;

/**
 * 
 * @author raj
 *
 */
public interface Cart {
	public void addItemToCart(Item item);

	public void calculateAndPrintReceiptWithTax();

	public float getTotalCost();

	public float getSalesTax();
}
