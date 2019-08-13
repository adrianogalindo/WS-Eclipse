package pizza6;

public class TypedPizza {

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

}
