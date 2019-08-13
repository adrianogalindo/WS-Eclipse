package pizza6;

public enum PizzaPromotion {
	PromoPepperoni,
	PromoFromage;
	
	public TypedPizza[] getPizzaPromo() {
		 TypedPizza[] p=new TypedPizza[2];
		 switch (this) {
			case PromoPepperoni: {
				p[0]= TypePizza.Pepperoni.getTypedPizza(PizzaSize.large);
				p[1]= TypePizza.Maison.getTypedPizza(PizzaSize.moyenne);
				break;
			}
			case PromoFromage: {
				p[0]=TypePizza.Fromage.getTypedPizza(PizzaSize.large);
				p[1]=TypePizza.Maison.getTypedPizza(PizzaSize.moyenne);
				break;
			}
			}
		 return p;
	}
	
}
