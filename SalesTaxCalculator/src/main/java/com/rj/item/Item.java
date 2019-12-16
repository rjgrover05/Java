/**
 * 
 */
package com.rj.item;

import org.springframework.stereotype.Service;

import com.rj.inums.ItemType;

/**
 * @author raj
 *
 */
@Service
public interface Item {

	public String getItemDescription();

	public void setItemDescription(String description);

	public float getItemPrice();

	public void setItemPrice(float price);

	public void setItemType(ItemType itemType);

	public boolean isItemImported();

	public boolean isItemExempted();

	public float getItemPriceWithTax();

	public float getItemSaleTax();
}
