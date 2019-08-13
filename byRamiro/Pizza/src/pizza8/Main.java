package pizza8;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Pizza p = new Pizza(15, true , )
		Pizza p =new Pizza.Builder()
				          .size(12)
				          .olives(true)
				          .extra_cheese(true)
				          .boiled_egg(true)
				          .anchovi(true)
				          .build();
		
		System.out.println("p");
		System.out.println(" Size? "+p.getSize());
		System.out.println(" Extra cheese? "+p.hasExtra_Cheese());
		System.out.println(" Pepperoni? "+p.hasPepperoni());
		
		
		Pizza p1 = TypePizza.Maison.getTypedPizza(PizzaSize.large).getPizza();
		System.out.println("p1");
		System.out.println(" Size? "+p1.getSize());
		System.out.println(" Extra cheese? "+p1.hasExtra_Cheese());
		System.out.println(" Pepperoni? "+p1.hasPepperoni());
		
		TypedPizza p3 = TypePizza.Pepperoni.getTypedPizza(PizzaSize.large);
		System.out.println("p3");
		System.out.println(" Size? "+p3.getSize());
		System.out.println(" Type = "+p3.getType());
		System.out.println(" Extra cheese? "+p3.hasExtra_Cheese());
		System.out.println(" Pepperoni? "+p3.hasPepperoni());
		
		TypedPizza[]p2=PizzaPromotion.PromoPepperoni.getPizzaPromo();
		System.out.println("p2[0]");
		System.out.println(" Size? "+p2[0].getSize());
		System.out.println(" Type = "+p2[0].getType());
		System.out.println(" Extra cheese? "+p2[0].hasExtra_Cheese());
		System.out.println(" Pepperoni? "+p2[0].hasPepperoni());
		System.out.println("p2[1]");
		System.out.println(" Size? "+p2[1].getSize());
		System.out.println(" Type = "+p2[1].getType());
		System.out.println(" Extra cheese? "+p2[1].hasExtra_Cheese());
		System.out.println(" Pepperoni? "+p2[1].hasPepperoni());
		

	}

}
