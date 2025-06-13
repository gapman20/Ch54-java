package com.zoo;

final public class Leopardo extends Feline{
    private String name;
    private boolean isWild;
    
    public Leopardo( String name, String gender, boolean isWild, double age ) {
        super(age);
        this.name = name;
        this.isWild = isWild;
        super.setCommonName("Leopardo");
        super.setScientificName("Leopardus");
    }
    
    @Override
    public String noise() {
        return "RAULLL";
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final boolean isWild() {
        return isWild;
    }

    public final void setWild(boolean isWild) {
        this.isWild = isWild;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString() );
        builder.append("Leopardo [name=");
        builder.append(name);
        builder.append(", isWild=");
        builder.append(isWild);
        builder.append("]");
        return builder.toString();
    }
}