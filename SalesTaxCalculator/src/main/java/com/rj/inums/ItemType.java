/**
 * 
 */
package com.rj.inums;

/**
 * @author raj
 *
 */
public enum ItemType {

	BOOK(true, false),
	MEDICAL(true, false),
	FOOD(true, false),
	OTHERS(false, false),
	IMPORTED_BOOK(true, true),
	IMPORTED_MEDICAL(true, true),
	IMPORTED_FOOD(true, true),
	IMPORTED_OTHERS(false, true);
	
	private boolean isExempted;
	private boolean isImported;

	private ItemType(boolean exepmted, boolean imported) {
		isExempted = exepmted;
		isImported = imported;
	}

	public boolean isExempted() {
		return isExempted;
	}

	public void setExempted(boolean isExempted) {
		this.isExempted = isExempted;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
}
