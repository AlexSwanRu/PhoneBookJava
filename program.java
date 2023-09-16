package Home5;

import java.util.*;

// Задание

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена
// с разными телефонами, их необходимо считать, как одного человека с разными телефонами.



public class u {

    // -----  The sortedPrint() method sorts and prints data by subscribers -----
    static void sortedPrint(Map<String, ArrayList> map) {

        // We get a set of all abon keys
        Set<String> keySet = map.keySet();

        // We find the minimum and maximum values
        int maxCount = 0;
        int minCount = 1_000_000;

        for (var item : map.entrySet()) {
            if (maxCount < item.getValue().size())
                maxCount = item.getValue().size();
            if (minCount > item.getValue().size())
                minCount = item.getValue().size();

        }
        // We form a stack starting from the minimum number of numbers
        Stack<String> st = new Stack<>();
        int num = minCount;
        while (num <= maxCount) {
            // System.out.println(map);
            for (var item : map.entrySet()) {
                if (item.getValue().size() == num) {
                    st.push(item.getKey());
                }
            }
            num += 1;
        }
        // Print out the pairs in the order of the keys in the stack
        String name;
        for (int i = 0; i < keySet.size(); i++) {
            name = st.pop();
            for (var item : map.entrySet()) {
                if (name == item.getKey()) {
                    System.out.printf("%8s: ", item.getKey());
                    System.out.println(item.getValue());
                }
            }
        }
        System.out.println();
    }


    // ------------- the main part ----------------------------------
    public static void main(String[] args) {
        // Initializing the initial list
        Map<String, ArrayList> abon = new HashMap<>() {
            {
                put("Kropotkin", new ArrayList<Integer>() {
                    {
                        add(797834554);
                        add(734577);
                        add(797061424);
                    }
                });
                put("Machno", new ArrayList<Integer>() {
                    {
                        add(333464);
                    }
                });
                put("Trotskiy", new ArrayList<Integer>() {
                    {
                        add(1347747);
                        add(2538765);

                    }
                });
                put("Stalin", new ArrayList<Integer>() {
                    {
                        add(79654722);
                        add(15141844);
                        add(22465799);
                        add(95451654);
                    }
                });
            }
        };
        System.out.println();
        // Printing the original data set
        System.out.println("Initial data: ");
        sortedPrint(abon);

        // Creating a cyclic menu
        Scanner scan = new Scanner(System.in, "cp866");
        Boolean getOut = false;
        String st;
        while (!getOut) {
            System.out.println("Enter the action number (A - add a subscriber, Q - exit the program):");
            st = scan.nextLine();
            String name = "";
            String phString;
            switch (st) {
                case "A": {
                    System.out.println("Enter the subscriber's last name:");
                    name = scan.nextLine();
                    if (abon.containsKey(name)) {
                        System.out.println("Such a surname is already in the directory!");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Enter phone numbers separated by commas: ");
                        phString = scan.nextLine();
                        String[] arr = phString.split(",");
                        ArrayList<Integer> arrInt = new ArrayList<>();
                        for (String item: arr) {
                            arrInt.add(Integer.parseInt(item.trim())) ;
                        }
                        abon.put(name, arrInt);
                        System.out.println();
                        sortedPrint(abon);
                        break;
                    }
                }
                case "Q": {
                    getOut = true;
                    System.out.println();
                    System.out.println("Buy!");
                    System.out.println();
                    break;
                }


            }
        }
    }

}