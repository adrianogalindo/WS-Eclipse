package application;

import builders.SandwichBuilder;
import sandwich.Sandwich;
import sandwich.SandwichMenu;
import sandwich.SandwichType;
import sandwich.Sizes;

public class program {
    public static void main (String[] args){
        Sandwich sand01 = SandwichBuilder.build(Sizes.grand).hasHamburguer().hasMayonnaise().now();
        System.out.println("p");
        System.out.println(" Size? " + sand01.getSize());
        System.out.println(" Hamburguer? " + sand01.isHamburguer());
        System.out.println(" Mayonnaise? " + sand01.isMayonnaise());





        Sandwich sand02 = new SandwichMenu(SandwichType.CheeseBurguer, Sizes.geant).getSandwich();
        System.out.println("p");
        System.out.println(" Size? " + sand02.getSize());
        System.out.println(" Hamburguer? " + sand02.isHamburguer());
        System.out.println(" Cheese? " + sand02.isCheedar());
        System.out.println(" Cornichon? " + sand02.isCornichon());


        System.out.println();
        System.out.println(sand02.toString());


    }
}
