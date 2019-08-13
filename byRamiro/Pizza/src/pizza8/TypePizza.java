package pizza8;

public enum TypePizza {
	
	Pepperoni,
	Fromage,
	Maison;
	
	public TypedPizza getTypedPizza(PizzaSize s) {
		
		Pizza p=null; 
		int size = s.getSize();
		
		if(this == TypePizza.Pepperoni) {
			p=new Pizza.Builder()
					  .size(size)
			          .pepperoni(true) 
			          .build();
		}
		else if (this == TypePizza.Fromage) {
			p=new Pizza.Builder()
					  .size(size)
			          .extra_cheese(true) 
			          .build();
		}
		else if (this == TypePizza.Maison) {
			p =new Pizza.Builder()	
					  .size(size)
			          .olives(true)
			          .extra_cheese(true)
			          .boiled_egg(true)
			          .anchovi(true)
			          .build();
		}
		return new TypedPizza(p,this);
		
	}

}
