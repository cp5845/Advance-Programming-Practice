class SupermarketBill {
    public static void main(String[] args) {

        int[] price = {1000, 1200, 800, 1500, 700};
        int total = 0;

        for (int i = 0; i < 5; i++) {
            total += price[i];
        }

        System.out.println("Total Bill : " + total);

        if (total > 5000)
            System.out.println("Discount Applicable");
        else
            System.out.println("No Discount");
    }
}