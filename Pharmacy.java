import java.util.*;

public class Pharmacy {

    Scanner sc = new Scanner(System.in);

    List<String> medsList = new ArrayList<>(Arrays.asList("Calpol", "Paracetamol", "Syrup", "Capsules"));
    List<String> cartList = new ArrayList<>(Arrays.asList());

    public void getInput() {

        System.out.println("\tThese are the available Medicines,\n");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < medsList.size(); j++) {
                System.out.println("\t" + (j + 1) + " - " + medsList.get(j));
            }
            System.out.print("\n\tSelect one of these,\n\tChoose here: ");
            int med = sc.nextInt();
            if (med >= medsList.size() && med != 123) {
                System.out.println("\n\tInvalid input. Try again.");
            } else if (med == 123) {
                break;
            } else if (cartList.contains(medsList.get(med - 1))) {

                System.out.println("\n\tIt's already in the cart, try any other products.");
                System.out.println("\n\tType 123 to view your cart.\n");

            } else if (med < medsList.size()) {

            } else {
                cartList.add(medsList.get(med - 1));
                System.out.println("\n\tProduct added to cart successfully!!");
            }

        }

    }

    public static void main(String a[]) {

        Pharmacy obj = new Pharmacy();

        obj.getInput();
        if (obj.cartList.isEmpty()) {
            System.out.println("\n\tYour cart is empty.");
        } else {
            System.out.println("\tYour have " + obj.cartList.size() + " products in your cart:\n");
            for (int i = 0; i < obj.cartList.size(); i++)
                System.out.println("\t" + obj.cartList.get(i));
        }
    }
}
