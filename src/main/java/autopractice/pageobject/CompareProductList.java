package autopractice.pageobject;

public class CompareProductList {
	public static String xpathCompareProductContainer = "//td[contains(@class, 'product-block')]";
	
	public static CompareProductContainer product(int index) {
		String xpath = xpathCompareProductContainer;
		xpath = "(" + xpath + ")[" + index + "]";
		return new CompareProductContainer(xpath);		
	}
}
