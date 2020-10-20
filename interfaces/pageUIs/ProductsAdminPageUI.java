package pageUIs;

public class ProductsAdminPageUI {
	public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON = "//button[@id='search-products']";
	public static final String DYNAMIC_COLUMN_NAME = "//tr[@role='row']//th[text()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_VALUE_AT_COLUMN_NAME_AND_ROW_NUMBER = "//tr[%s]//td[%s][contains(text(),'%s')]";
}
