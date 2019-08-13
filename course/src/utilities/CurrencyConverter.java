package utilities;

public class CurrencyConverter {

	public static double conversion(double dollarValue, double quantityDollars) {
		return dollarValue * quantityDollars + (dollarValue * quantityDollars * 6 / 100); 
	}
}
