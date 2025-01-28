package services;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Vector;        // Obsolete Collection

import mypackages.Person;
import mypackages.Player;
import mypackages.Software;

class App {

    public static void main(String[] args) throws Exception {
        int a = 1_333_088;
        System.out.println("Bonjour tout \nle \tmonde ! :)");
        System.out.println("a = " + a);

        // condition
        int value = 25;

        if (value == 24 || value == 16) {
            System.out.println("Oui !");
        } else {
            System.out.println("value ne vaut ni 24 ni 16");
        }

        for (int i = 0; i <= 4; i++) {
            System.out.print(i + "\t");
        }
        System.out.println("");

        // Objet "Person"   
        Person person3 = new Person("name", 15);     // instance de la class Person   
        System.out.println("-----------------------");

        System.out.println(getName());
        System.out.println(sayHello("Patrick"));
        System.out.println("-----------------------");

        // Objet "Player"
        Player player1 = new Player();                           // instance de la class Player
        Player player2 = new Player("Robert");
        Player player3 = new Player("Franck", 25);
        player3.attack();
        System.out.println("-----------------------");

        // Objet "Software"
        Software software1 = new Software("MIT");
        System.out.println("licence de software1 : " + software1.getLicence());
        software1.setLicence("GNU");
        System.out.println("licence de software1 devient : " + software1.getLicence());
        System.out.println("-----------------------");
        Software software2 = new Software("HFJ");
        Software software3 = new Software("KDS");
        System.out.println("-----------------------");

        // Objet "Array"
        int[] tab = new int[3];                 // length = 3, instance d'un Array
        int[] tabX = {81, 25, 37, 48};

        // tab1 = new int[3]{ 81, 25, 37 };     // OK
        // tab1 = { 81, 25, 37 };               // OK
        System.out.println("tab length est " + tab.length);
        System.out.println("tabX length est " + tabX.length);
        System.out.println("tab = tabX est " + tabX.equals(tab));

        for (int element : tabX) {                // foreach
            System.out.println(element);
        }

        System.out.println("-----------------------");

        System.out.println("Tableau a deux dimensions");

        // int[][] tabY = new int[2][3];        // tableau à deux dimensions
        int[][] tabY = {{81, 25, 37}, {32, 86, 74}};        // tableau à deux dimensions
        System.out.println("tabY length est " + tabY.length);   // affiche 2
        // parce que 
        // tabY = {                          // les éléments du tableau tabY sont deux tableaux
        //     { 81, 25, 37 }, 
        //     { 32, 86, 74 }
        // };

        System.out.println(tabY[1][1]);   // affiche 86 : parce que c'est le 2è element du 2è tableau

        System.out.println("-----------------------");
        System.out.println("Parcours des tableaux a deux dimensions");

        // for(int i = 0; i < tabY.length; i++) {
        //     for(int j = 0; j < tabY[i].length; j++) {
        //         System.out.println(tabY[i][j]);
        //     }
        // }  
        //  
        //  OU
        for (int[] row : tabY) {
            for (int col : row) {
                System.out.println(col);
            }
        }

        System.out.println("-----------------------");
        System.out.println("String");
        
        String str1 = "Hello";                      
        String str2 = new String("world");          // Warning : String str1 = "Hello" est plus optimisé
        
        System.out.println(str1.concat(" ").concat(str2));
        
        String str3 = "See/you/soon";
        System.out.println(str3.replaceAll("/", " "));

        String[] tokens = str3.split("/");
        for (String token : tokens) {
            System.out.println(token);
        }
        System.out.println("-----------------------");
        System.out.println("String Builder");
        
        StringBuilder sb = new StringBuilder();
        sb.append("Bonjour ");
        sb.append("ici c'est le StringBuilder");
        System.out.println(sb);
        System.out.println("-----------------------");

        System.out.println("BufferReader");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        System.out.print("Quel est votre nom ? ");
        String name = br.readLine();
        System.out.println("Bonjour " + name);
        System.out.println("-----------------------");
        
        System.out.println("Scanner");
        Scanner sc = new Scanner(System.in);                    // Convert to try-with-resources
        
        System.out.print("Quel est votre age ? ");
        int age = sc.nextInt();
        System.out.println("Vous avez " + age + " ans ");
        sc.close();
        
        System.out.println("-----------------------");
        System.out.println("Les List : ArrayList & Vector");
        
        ArrayList<Player> list = new ArrayList<>(10);
        list.add(player1);
        list.add(player2);
        
        for (Player element : list) {
            System.out.println("le nom du player est dans list[" + list.indexOf(element) + "] : " + element.getName());
        }
        
        System.out.println("count == length == size : " + list.size());

        // trier la "list"
        Vector<String> vector = new Vector<String>();         // warning : Obsolete Collection

        vector.add("Rabe");
        vector.add("Feno");
        vector.add("Aina");

        Collections.sort(vector);

        System.out.println("Vector liste trié : ");

        for (String element : vector) {
            System.out.println(element);
        }

        
        System.out.println("-----------------------");
        System.out.println("Les List : ArrayList & Vector");
        
        LinkedList<Software> linkedList = new LinkedList<>();
        linkedList.add(software1);
        linkedList.addFirst(software2);
        
        System.out.println("myFirst element by getFirst() : " + linkedList.getFirst());

        // for (Software element : linkedList) {
        //     System.out.println("le licence du logiciel est dans linkedList[" + list.indexOf(element) + "] : " + element.getLicence());
        // }
        
        ListIterator<Software> iter = linkedList.listIterator();         
        while (iter.hasNext()) {
            Software element = iter.next();
            System.out.println("le licence du logiciel est : " + element.getLicence());
        }

    }


    // -------------------------------------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------------------------------------



    public static String getName() {
        return "David";
    }

    public static String sayHello(String name) {
        return "Hello " + name + " ! How are you ? ";
    }

    public static void showArrayValues(int[] tabNumber) {
        for (int element : tabNumber) {
            System.out.println(element);
        }
    }

}
