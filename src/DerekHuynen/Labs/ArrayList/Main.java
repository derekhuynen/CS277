package DerekHuynen.Labs.ArrayList;

import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        System.out.println("Step 0: the list names looks like:\n");
        names.forEach(System.out::println);
        names.add("Alice");
        names.add("Bob");
        names.add("Connie");
        names.add("David");
        names.add("Edward");
        names.add("Fran");
        names.add("Gomez");
        names.add("Harry");
        System.out.println("Step 1:\nafter performing the first list of add:");
        names.forEach(System.out::println);
        System.out.println("Step 2:\nList size:\n" + names.size());
        System.out.println("Step 3:\n The list first name is " + names.get(0));
        System.out.println("The list last name is  " + names.get(names.size() - 1));
        names.set(0, "Alice B. Toklas");
        System.out.println("Step 4:\nthe list names looks like:");
        names.forEach(System.out::println);
        names.add(names.indexOf("David") + 1, "Doug");
        System.out.println("Step 5:\nthe list names looks like:");
        names.forEach(System.out::println);
        ArrayList<String> names2 = new ArrayList<>(names);
        System.out.println("Step 6:\nthe list names looks like:");
        names2.forEach(System.out::println);
        names.remove(0);
        System.out.println("Step 7:\nthe list names after removing the first element looks like:");
        names.forEach(System.out::println);
        System.out.println("the list names that has been copy looks like:");
        names2.forEach(System.out::println);
    }
}
