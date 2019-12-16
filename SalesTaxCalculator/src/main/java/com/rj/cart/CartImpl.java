package com.rj.cart;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rj.item.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 
 * @author raj
 *
 */
@Component
public class CartImpl implements Cart {

	private List<Item> itemList;
	private float saleTax;
	private float totalCost;
	private static final Format FORMATTER = new DecimalFormat("0.00");

	/**
	 * 
	 * @return item list
	 * 
	 */
	public List<Item> getItemList() {
		return itemList;
	}

	/**
	 * 
	 * @param itemList
	 * 
	 */
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	/**
	 * 
	 * @return sale tax
	 * 
	 */
	public float getSaleTax() {
		return saleTax;
	}

	/**
	 * 
	 * @param saleTax
	 * 
	 */
	public void setSaleTax(float saleTax) {
		this.saleTax = saleTax;
	}

	/**
	 * 
	 * @param totalCost
	 * 
	 */
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public CartImpl() {
		this.itemList = new ArrayList<Item>();
	}

	/**
	 * 
	 * @param item
	 * 
	 */
	@Override
	public void addItemToCart(Item item) {
		itemList.add(item);
	}

	/**
	 * method to calculate and return the receipt with tax
	 * 
	 */
	@Override
	public void calculateAndPrintReceiptWithTax() {
		resetCart();
		StringBuilder buffer = new StringBuilder();
		itemList.stream().forEach(item -> {
			buffer.append("\n").append(item.toString());
			totalCost += item.getItemPriceWithTax();
			saleTax += item.getItemSaleTax();
		});

		buffer.append("\nSales Tax:" + FORMATTER.format(saleTax));
		buffer.append("\nTotal :" + totalCost);
		System.out.println("*********************************************");
		System.out.println("Value:" + buffer.toString());
	}

	private void resetCart() {
		totalCost = 0.0f;
		saleTax = 0.0f;
	}

	/**
	 * 
	 * @return totalCost
	 * 
	 */
	@Override
	public float getTotalCost() {
		return totalCost;
	}

	/**
	 * 
	 * @return salesTax
	 * 
	 */
	@Override
	public float getSalesTax() {
		return Float.valueOf(FORMATTER.format(saleTax));
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		itemList.stream().forEach(item -> buffer.append("\n").append(item.toString()));
		return buffer.toString();
	}
}
