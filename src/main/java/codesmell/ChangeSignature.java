package codesmell;

public class ChangeSignature {

    /** change signature extract variable */
    public int myMethod(int base, int price) {
        System.out.println("value = " + base);
        System.out.println("valu1e = " + base);

        System.out.println("price = " + price);
        int total = base + price;
        System.out.println("total = " + total);
        return total;
    }
}
