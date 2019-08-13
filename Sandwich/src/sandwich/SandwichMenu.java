package sandwich;

import builders.SandwichBuilder;

public class SandwichMenu {

    private Sandwich sandwich;
    private SandwichType sandwichType;

    public SandwichMenu(SandwichType sandwichType_, Sizes sizes_) {
        if (sandwichType_ == SandwichType.BLT) {
            this.sandwich = SandwichBuilder.build(sizes_).hasLaitue().hasBacon().hasTomate().now();
        } else if (sandwichType_ == SandwichType.Hamburguer) {
            this.sandwich = SandwichBuilder.build(sizes_).hasHamburguer().hasCornichon().now();
        } else if (sandwichType_ == SandwichType.CheeseBurguer) {
            this.sandwich = SandwichBuilder.build(sizes_).hasHamburguer().hasCornichon().hasCheedar().now();
        } else if (sandwichType_ == SandwichType.XAll) {
            this.sandwich = SandwichBuilder.build(sizes_).hasHamburguer().hasCornichon().hasCheedar().hasBacon().hasJambom().hasLaitue().hasMayonnaise().hasOignon().hasTomate().now();
        }
    }

    public Sandwich getSandwich(){
        return this.sandwich;
    }



}
