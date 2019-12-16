/**
 * 
 */
package com.rj.tax;

import org.springframework.stereotype.Service;

import com.rj.item.Item;

/**
 * @author raj
 *
 */
@Service
public interface TaxCalculator {

	public float calculateTax(Item item);
}
