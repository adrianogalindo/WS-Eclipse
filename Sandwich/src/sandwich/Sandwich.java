package sandwich;

public class Sandwich {

    private Sizes size;
    private boolean oignon;
    private boolean cheedar;
    private boolean mayonnaise;
    private boolean hamburguer;
    private boolean bacon;
    private boolean tomate;
    private boolean cornichon;
    private boolean jambon;
    private boolean laitue;

    public Sandwich() {
    }

    public Sandwich(Sizes size, boolean oignon, boolean cheedar, boolean mayonnaise, boolean hamburguer, boolean bacon, boolean tomate, boolean cornichon, boolean jambon, boolean laitue) {
        this.size = size;
        this.oignon = oignon;
        this.cheedar = cheedar;
        this.mayonnaise = mayonnaise;
        this.hamburguer = hamburguer;
        this.bacon = bacon;
        this.tomate = tomate;
        this.cornichon = cornichon;
        this.jambon = jambon;
        this.laitue = laitue;
    }

    public Sizes getSize() {
        return size;
    }

    public void setSize(Sizes size) {
        this.size = size;
    }

    public boolean isOignon() {
        return oignon;
    }

    public void setOignon(boolean oignon) {
        this.oignon = oignon;
    }

    public boolean isCheedar() {
        return cheedar;
    }

    public void setCheedar(boolean cheedar) {
        this.cheedar = cheedar;
    }

    public boolean isMayonnaise() {
        return mayonnaise;
    }

    public void setMayonnaise(boolean mayonnaise) {
        this.mayonnaise = mayonnaise;
    }

    public boolean isHamburguer() {
        return hamburguer;
    }

    public void setHamburguer(boolean hamburguer) {
        this.hamburguer = hamburguer;
    }

    public boolean isBacon() {
        return bacon;
    }

    public void setBacon(boolean bacon) {
        this.bacon = bacon;
    }

    public boolean isTomate() {
        return tomate;
    }

    public void setTomate(boolean tomate) {
        this.tomate = tomate;
    }

    public boolean isCornichon() {
        return cornichon;
    }

    public void setCornichon(boolean cornichon) {
        this.cornichon = cornichon;
    }

    public boolean isJambon() {
        return jambon;
    }

    public void setJambon(boolean jambon) {
        this.jambon = jambon;
    }

    public boolean isLaitue() {
        return laitue;
    }

    public void setLaitue(boolean laitue) {
        this.laitue = laitue;
    }

    @Override
    public String toString() {
        return "Sandwich: \n" +
                "size = " + size + "\n" +
                "oignon = " + oignon + "\n" +
                "cheedar = " + cheedar + "\n" +
                "mayonnaise = " + mayonnaise + "\n" +
                "hamburguer = " + hamburguer + "\n" +
                "bacon = " + bacon + "\n" +
                "tomate = " + tomate + "\n" +
                "cornichon = " + cornichon + "\n" +
                "jambon = " + jambon + "\n" +
                "laitue = " + laitue +
                '}';
    }
}
