package entities;

public class RectangleStatic {
	
	public static double area(double width, double height) {
		return width * height;
	}
	
	public static double perimeter(double width, double height) {
		return width * 2 + height * 2;
	}
	
	public static double diagonal(double width, double height) {
		return Math.sqrt(width * width + height * height);
	}
	
}
