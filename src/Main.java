public class Main {

    public static void main(String[] args) {
        System.out.println("Zastosowanie wzorca Builder.\n");
        System.out.println("Przygotowujemy pizze:");
        System.out.println("============================\n");

        MakePizza pizza = new MakePizza.Builder(true, 20)
                .setKindOfSauce(MakePizza.Sauce.BBQ)
                .setWithMeat(true)
                .setWithVegetables(true)
                .build();

        System.out.println(pizza);
    }
}
