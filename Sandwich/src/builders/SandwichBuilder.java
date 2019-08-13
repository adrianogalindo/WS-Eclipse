package builders;

import sandwich.Sandwich;
import sandwich.Sizes;

public class SandwichBuilder {
    private Sandwich sandwich;


    public SandwichBuilder(){
    }

    public static SandwichBuilder build(Sizes size_){
        SandwichBuilder builder = new SandwichBuilder();
        builder.sandwich = new Sandwich();
        builder.sandwich.setSize(size_);
        builder.sandwich.setBacon(false);
        builder.sandwich.setCheedar(false);
        builder.sandwich.setCornichon(false);
        builder.sandwich.setHamburguer(false);
        builder.sandwich.setJambon(false);
        builder.sandwich.setLaitue(false);
        builder.sandwich.setMayonnaise(false);
        builder.sandwich.setOignon(false);
        builder.sandwich.setTomate(false);

        return builder;
    }

    public SandwichBuilder hasSize(Sizes size_){
        sandwich.setSize(size_);
        return this;
    }
    public SandwichBuilder hasBacon(){
        sandwich.setBacon(true);
        return this;
    }
    public SandwichBuilder hasCheedar(){
        sandwich.setCheedar(true);
        return this;
    }
    public SandwichBuilder hasCornichon(){
        sandwich.setCornichon(true);
        return this;
    }
    public SandwichBuilder hasHamburguer(){
        sandwich.setHamburguer(true);
        return this;
    }
    public SandwichBuilder hasJambom(){
        sandwich.setJambon(true);
        return this;
    }
    public SandwichBuilder hasLaitue(){
        sandwich.setLaitue(true);
        return this;
    }
    public SandwichBuilder hasMayonnaise(){
        sandwich.setMayonnaise(true);
        return this;
    }
    public SandwichBuilder hasOignon(){
        sandwich.setOignon(true);
        return this;
    }
    public SandwichBuilder hasTomate(){
        sandwich.setTomate(true);
        return this;
    }

    public Sandwich now() {
        return sandwich;
    }

}
