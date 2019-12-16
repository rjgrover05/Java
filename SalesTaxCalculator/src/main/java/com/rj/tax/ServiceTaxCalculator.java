package com.rj.tax;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rj.inums.TaxType;
import com.rj.item.Item;

/**
 * 
 * @author raj
 *
 */
@Service
public class ServiceTaxCalculator implements TaxCalculator {
	private static final float ROUNDOFF = 0.05f;

	private TaxType getItemTaxType(Item item) {
		if (item.isItemImported() && !item.isItemExempted()) {
			return TaxType.BOTH;
		} else if (item.isItemImported() && item.isItemExempted()) {
			return TaxType.IMPORTED;
		} else if (!item.isItemImported() && !item.isItemExempted()) {
			return TaxType.BASIC;
		}
		return TaxType.NA;
	}

	private float roundOffTax(float tax) {
		return (float) Math.ceil(tax / ROUNDOFF) * ROUNDOFF;
	}

	@Override
	public float calculateTax(Item item) {
		return roundOffTax(getItemTaxType(item).getApplicableTax() * item.getItemPrice());
	}
}
