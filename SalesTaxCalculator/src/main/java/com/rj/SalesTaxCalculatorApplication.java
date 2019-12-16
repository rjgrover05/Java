package com.rj;

import static com.rj.item.ItemDataStore.ITEM_LIST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rj.cart.Cart;
import com.rj.cart.CartImpl;
import com.rj.inums.ItemType;
import com.rj.item.Item;
import com.rj.item.ItemDataStore;

/**
 * 
 * @author raj
 *
 */
@SpringBootApplication
public class SalesTaxCalculatorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SalesTaxCalculatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hi raj here.......");
		
		List<Item> itemList = createItemList(ITEM_LIST);
		
		Cart cart = new CartImpl();
		for (Item item : itemList) {
			cart.addItemToCart(item);
		}
		cart.calculateAndPrintReceiptWithTax();
	}

	private static List<Item> createItemList(Object[][] data) {
		List<Item> list = new ArrayList<Item>();
		for (Object[] item : data) {
			list.add(ItemDataStore.createItem((String) item[0], (Float) item[1], (ItemType) item[2]));
		}
		return list;
	}
}
