package main;

import java.util.ArrayList;

public class Practice {

    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Cow");
        animals.add("Cat");
        animals.add("Dog");
        for (String language : animals) {
            if (language.equals("Cow")) {
                animals.set(0, "Moo");
            } else if (language.equals("Cat")) {
                animals.set(1, "Meow");
            } else if (language.equals("Dog")) {
                animals.set(2, "Aww");
            } else {
                animals.replaceAll((t) -> {
                    return "Empty";
                });
            }
        }
        System.out.println("Updated ArrayList: " + animals);
    }
}
