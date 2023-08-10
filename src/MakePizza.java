public class MakePizza {

    public enum Sauce {
        TOMATO, DANISH, BBQ
    }

    private final boolean thinCake;
    private final int quantityOfCheese;
    private final Sauce kindOfSauce;
    private final boolean withMeat;
    private final boolean withVegetables;

    public MakePizza (Builder builder) {
        this.thinCake = builder.thinCake;
        this.quantityOfCheese = builder.quantityOfCheese;
        this.kindOfSauce = builder.kindOfSauce;
        this.withMeat = builder.withMeat;
        this.withVegetables = builder.withVegetables;
    }

    private String getKindOfSauce(Sauce sauce) {
        StringBuilder nameOfSauce = new StringBuilder();
        switch (sauce) {
            case TOMATO:
                nameOfSauce.append("pomidorowy");
                break;
            case BBQ:
                nameOfSauce.append("BBQ");
                break;
            case DANISH:
                nameOfSauce.append("duński");
                break;
        }
        return nameOfSauce.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("na "+(thinCake ? "cienkim" : "grubym")+" cieście\n");
        stringBuilder.append("ilość sera  : "+quantityOfCheese+"\n");
        stringBuilder.append("rodzaj sosu : "+getKindOfSauce(kindOfSauce)+"\n");
        stringBuilder.append("dodatki : \n"+
                "mięso: "+(withMeat ?"tak" : "nie")+"\n"+
                "warzywa: "+(withVegetables ? "tak" : "nie")+"\n"
                );
        return stringBuilder.toString();
    }

    public static class Builder {
        private final boolean thinCake;
        private final int quantityOfCheese;
        private Sauce kindOfSauce = Sauce.TOMATO;
        private boolean withMeat = true;
        private boolean withVegetables = true;

        public Builder (boolean thinCake, int quantityOfCheese) {
            this.thinCake = thinCake;
            this.quantityOfCheese = quantityOfCheese;
        }

        public Builder setKindOfSauce (Sauce sauce) {
            this.kindOfSauce = sauce;
            return this;
        }

        public Builder setWithMeat (boolean withMeat) {
            this.withMeat = withMeat;
            return this;
        }

        public Builder setWithVegetables (boolean withVegetables) {
            this.withVegetables = withVegetables;
            return this;
        }

        public MakePizza build() {
            return new MakePizza(this);
        }
    }

}
