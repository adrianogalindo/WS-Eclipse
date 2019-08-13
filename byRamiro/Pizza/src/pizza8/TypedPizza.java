package pizza8;

public class TypedPizza implements IPizza {

	private Pizza pizza;
	private TypePizza type;

	public TypedPizza(Pizza p, TypePizza tp) {
		this.pizza = p;
		this.type = tp;
	}

	public Pizza getPizza() {
		return this.pizza;
	}

	public TypePizza getType() {
		return this.type;
	}
	
	public int getSize() { return this.pizza.getSize();}
    public boolean hasExtra_Cheese(){ return this.pizza.hasExtra_Cheese();}
    public boolean hasPepperoni(){ return this.pizza.hasPepperoni();}
    public boolean hasBacon(){ return this.pizza.hasBacon();}
    public boolean hasOlives(){ return this.pizza.hasOlives();}
    public boolean hasChicken(){ return this.pizza.hasChicken();}
    public boolean hasSauce(){ return this.pizza.hasSauce();}
    public boolean hasBoiled_egg(){ return this.pizza.hasBoiled_egg();}
    public boolean hasAnchovy(){ return this.pizza.hasAnchovy();}

}
