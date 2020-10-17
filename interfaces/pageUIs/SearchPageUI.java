package pageUIs;

public class SearchPageUI {
	public static final String SEARCH_KEYWORD_BUTTON = "//div[@class='search-input']//input[@value='Search']";
	public static final String WARNING_TEXT = "//div[@class='search-results']//div[@class='warning']";
	public static final String SEARCH_KEYWORD_TEXTBOX = "//input[@class='search-text']";
	public static final String NO_RESULT_TEXT = "//div[@class='no-result']";
	public static final String PRODUCT_NAME_1 = "//div[@class='item-box'][last()]//preceding-sibling::div//h2[@class='product-title']";
	public static final String PRODUCT_NAME_2 = "//div[@class='item-box'][last()]//h2[@class='product-title']";
	public static final String ONLY_PRODUCT_NAME = "//h2[@class='product-title']";
	public static final String SEARCH_ADVANCED_CHECKBOX = "//input[@id='adv']";
	public static final String CATEGORY_DROPDOWN = "//select[@id='cid']";
	public static final String AUTOMATICALLY_SEARCH_CHECKBOX = "//input[@id='isc']";
	public static final String MANUFACTURER_DROPDOWN = "//select[@id='mid']";
	public static final String PRICE_FROM_TEXTBOX = "//input[@class='price-from']";
	public static final String PRICE_TO_TEXTBOX = "//input[@class='price-to']";
	public static final String SEARCH_IN_PRODUCT_DESCRIPTIONS_CHECKBOX = "//input[@id='sid']";
}
