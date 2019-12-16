package com.rj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rj.cart.Cart;
import com.rj.cart.CartImpl;
import com.rj.inums.ItemType;
import com.rj.item.Item;
import com.rj.item.ItemDataStore;
import static com.rj.item.ItemDataStore.ITEM_LIST;

@RunWith(Parameterized.class)
public class CartTest {
	private List<Item> itemList ;
	private float expectedTotalSalexTax;
	private float exptecdTotalCost;

	public CartTest(List<Item> list , float totalCost , float totalSalexTax){
		itemList = list;
		exptecdTotalCost = totalCost;
		expectedTotalSalexTax = totalSalexTax;
	}

	@Parameterized.Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] {
				   { createItemList(new Object[][]{ITEM_LIST[0], ITEM_LIST[1], ITEM_LIST[2]}), 29.83f , 1.50f},
				   { createItemList(new Object[][]{ITEM_LIST[3], ITEM_LIST[4]}), 65.15f , 7.65f},
				   { createItemList(new Object[][]{ITEM_LIST[5], ITEM_LIST[6], ITEM_LIST[7], ITEM_LIST[8]}), 74.68f , 6.70f} 
			   };
	   return Arrays.asList(data);
	 }

	 private static List<Item> createItemList(Object[][] data){
		 List<Item> list = new ArrayList<Item>();
		 for(Object[] item: data){
			 list.add(ItemDataStore.createItem((String)item[0],(Float)item[1], (ItemType)item[2]));
		 }
		 return list;
	 }

	 @Test
	 public void testCartCostAndTax(){
		 Cart cart = new CartImpl();
		 for(Item item : itemList){
			 cart.addItemToCart(item);
		 }
		 cart.calculateAndPrintReceiptWithTax();
		 Assert.assertEquals("test failed for sales tax" , expectedTotalSalexTax ,cart.getSalesTax(), 0.0f );
		 Assert.assertEquals("test failed for total cost" , exptecdTotalCost ,cart.getTotalCost(), 0.0f );
	 }	

}