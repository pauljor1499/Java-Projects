package main;

import java.util.ArrayList;

public class myProductList {

    //Container
    public static ArrayList<myProduct> list = new ArrayList<>();

    int count_list = 0;

    public void addProduct(String myName, String myPrice, String myQuantity, String myTotal) {

        list.add(new myProduct(myName, myPrice, myQuantity, myTotal));
    }

    public void addCart(String name) {
        for (myProduct myList : list) {
            System.out.println("My List1");

            if (myList.name.equals(name)) {
                System.out.println(
                        "Items: " + myList.name + ", "
                        + myList.price + myList.price + ", "
                        + myList.quantity + ", "
                        + myList.total
                );
                break;
            } else {
                System.out.println("HAHA");
                break;
            }
        }
    }

    public boolean findProductByName(String getName) {
        for (myProduct myList : list) {
            if (myList.name.equals(getName)) {
                System.out.println(
                        "Items: " + myList.name + ", "
                        + myList.price + ", "
                        + myList.quantity + ", "
                        + myList.total
                );
                return true;
            }
        }
        viewList();
        return false;
    }

    public boolean removeListByName(String getName) {
        for (myProduct myList : list) {
            if (myList.name.equals(getName)) {
                list.remove(myList);
                viewList();
                return true;
            }
        }
        viewList();
        return false;
    }

    public void viewList() {
        for (myProduct myList : list) {
            System.out.println(
                    "Item" + count_list + ": " + myList.name + ", "
                    + myList.price + ", "
                    + myList.quantity + ", "
                    + myList.total
            );
            count_list++;
        }
        System.out.println("Items: " + count_list);
        count_list = 0;
    }

}
