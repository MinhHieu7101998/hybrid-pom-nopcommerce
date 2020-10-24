package pageUIs;

public class AbstractPageUI {
	public static final String CUSTOMER_INFO_LINK = "//a[text()='Customer info']";
	public static final String ADDRESSES_LINK = "//div[@class='listbox']//a[text()='Addresses']";
	public static final String ORDERS_LINK = "//div[@class='listbox']//a[text()='Orders']";
	public static final String DOWNLOADABLE_PRODUCTS_LINK = "//a[text()='Downloadable products']";
	public static final String BACK_IN_STOCK_SUBSCRIPTIONS_LINK = "//a[text()='Back in stock subscriptions']";
	public static final String REWARD_POINTS_LINK = "//a[text()='Reward points']";
	public static final String CHANGE_PASSWORD_LINK = "//a[text()='Change password']";
	public static final String MY_PRODUCT_REVIEWS = "//a[text()='My product reviews']";
	
	public static final String DYNAMIC_LINK = "//a[text()='%s']";
	public static final String UPLOAD_FILE_TYPE = "//input[@type='file']";
	public static final String AJAX_LOADING_ICON = "//span[@id='ajaxBusy']";
	
	public static final String DYANMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_BUTTON_BY_VALUE = "//input[@value='%s']";
	public static final String DYNAMIC_CHECKBOX_OR_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
}
