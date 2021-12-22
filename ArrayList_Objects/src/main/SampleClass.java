package main;

import java.util.Scanner;

public class SampleClass {

    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);

        myProductList s = new myProductList();

        System.out.println("My List" + s.list);

//        s.addProduct("P0", "P00", "P000", "P0000");
//        s.addProduct("P1", "P11", "P111", "P1111");
//        s.addProduct("P2", "P22", "P222", "P2222");
        System.out.println("My List" + s.list);

        if (s.list.isEmpty()) {
            s.addProduct("P2", "P22", "P222", "P2222");
            System.out.println("Empty!");
        }

        System.out.println("My List" + s.list);

        System.out.println("Your action: [a=add, r=remove, f=find, s=show c=cart]");
        String action = x.next();

        if (action.equals("a")) {
            s.viewList();
            System.out.println("Name:");
            String name = x.next();

            System.out.println("Price:");
            String price = x.next();

            System.out.println("Quantity:");
            String quantity = x.next();

            System.out.println("Total:");
            String total = x.next();

            s.addProduct(name, price, quantity, total);
            s.viewList();

        } else if (action.equals("r")) {
            System.out.println("Remove:");
            String name = x.next();
            if (!s.removeListByName(name)) {
                System.out.println("No result.");
            }

        } else if (action.equals("f")) {
            System.out.println("Find:");
            String name = x.next();
            if (!s.findProductByName(name)) {
                System.out.println("No result.");
            }

        } else if (action.equals("s")) {
            s.viewList();

        } else if (action.equals("q")) {
            System.exit(0);
        } else if (action.equals("c")) {
            System.out.println("Add to Cart:");
            String name = x.next();
            s.addCart(name);
        }

    }

}
