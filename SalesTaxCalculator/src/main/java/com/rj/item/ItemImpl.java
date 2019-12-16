package com.rj.item;

import org.springframework.stereotype.Service;

import com.rj.inums.ItemType;
import com.rj.tax.ServiceTaxCalculator;
import com.rj.tax.TaxCalculator;

/**
 * 
 * @author raj
 *
 */
@Service
public class ItemImpl implements Item {

	private TaxCalculator calculator = new ServiceTaxCalculator();

	private String itemName;
	private float itemPrice;
	private ItemType type;

	/**
	 * 
	 *  @return item name
	 *  
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * 
	 * @param itemName set
	 * 
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * 
	 * @return itemType
	 */
	public ItemType getType() {
		return type;
	}

	/**
	 * 
	 * @param set item type
	 */
	public void setType(ItemType type) {
		this.type = type;
	}

	/**
	 * 
	 * @return item description
	 */
	@Override
	public String getItemDescription() {
		return itemName;
	}

	/**
	 * @param description
	 */
	@Override
	public void setItemDescription(String description) {
		this.itemName = description;
	}

	/**
	 * 
	 * @return item price
	 */
	@Override
	public float getItemPrice() {
		return itemPrice;
	}

	/**
	 * 
	 * @param item price
	 */
	@Override
	public void setItemPrice(float price) {
		this.itemPrice = price;
	}

	/**
	 * 
	 * @param set item type
	 */
	@Override
	public void setItemType(ItemType itemType) {
		this.type = itemType;
	}

	/**
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isItemImported() {
		return type.isImported();
	}

	/**
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isItemExempted() {
		return type.isExempted();
	}

	/**
	 * 
	 * @return itemsaletax + itemprice
	 */
	@Override
	public float getItemPriceWithTax() {
		return getItemSaleTax() + getItemPrice();
	}
	
	/**
	 * 
	 * @return item sale tax
	 */
	@Override
	public float getItemSaleTax() {
		return calculator.calculateTax(this);
	}

	@Override
	public String toString() {
		return "ItemImpl [1 " + itemName + ", itemPrice=" + itemPrice + ", type=" + type + "]";
	}
}
