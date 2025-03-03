package services;

import enums.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Vector;        // Obsolete Collection
import mypackages.Person;
import mypackages.Player;
import mypackages.Software;

class App {

    // quand on étend "Thread" il faut redéfinir la methode run()
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
        System.out.println("tab = tabX est " + Arrays.equals(tabX, tab));

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

        // System.out.println("BufferReader");
        // InputStreamReader isr = new InputStreamReader(System.in);
        // BufferedReader br = new BufferedReader(isr);
        // System.out.print("Quel est votre nom ? ");
        // String name = br.readLine();
        // System.out.println("Bonjour " + name);
        // System.out.println("-----------------------");
        // System.out.println("Scanner");
        // Scanner sc = new Scanner(System.in);                    // Convert to try-with-resources
        // System.out.print("Quel est votre age ? ");
        // int age = sc.nextInt();
        // System.out.println("Vous avez " + age + " ans ");
        // sc.close();
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
        System.out.println("Les List : LinkedList");

        LinkedList<Software> linkedList = new LinkedList<>();
        linkedList.add(software1);
        linkedList.addFirst(software2);
        linkedList.addLast(software3);

        System.out.println("myFirst element by getFirst() : " + linkedList.getFirst());

        // for (Software element : linkedList) {
        //     System.out.println("le licence du logiciel est dans linkedList[" + list.indexOf(element) + "] : " + element.getLicence());
        // }
        ListIterator<Software> iter = linkedList.listIterator();
        while (iter.hasNext()) {
            Software element = iter.next();
            System.out.println("le licence du logiciel est : " + element.getLicence());
        }

        System.out.println("-----------------------");
        System.out.println("Les List : Stack");

        Stack<Player> stack = new Stack<>();
        stack.push(player1);
        stack.push(player2);
        stack.push(player3);

        System.out.println("myLast element by peek() : " + stack.peek().getName());
        stack.pop();

        ListIterator<Player> iterStack = stack.listIterator();
        while (iterStack.hasNext()) {
            Player element = iterStack.next();
            System.out.println("l' element est : " + element.getName());
        }

        System.out.println("-----------------------");
        System.out.println("Les File : ArrayDeque");

        ArrayDeque<Player> deque = new ArrayDeque<>();

        deque.addLast(player1);
        deque.addLast(player2);
        deque.addLast(player3);

        Iterator<Player> iteraDeq = deque.iterator();

        while (iteraDeq.hasNext()) {
            System.out.println(iteraDeq.next().getName());
        }

        System.out.println("-----------------------");
        System.out.println("Les Enums");

        Color rouge = Color.RED;
        System.out.println(rouge);       // LUNDI

        // System.out.println("-----------------------");
        // System.out.println("Les Threads : ");

        // MyThread thread1 = new MyThread();
        // Thread thread2 = new Thread(new MyRunnable());

        // thread1.start();
        // thread2.start();

        // System.out.println("-----------------------");
        // System.out.println("Les Executor : newSingleThreadExecutor ");
        
        // ExecutorService ex = Executors.newSingleThreadExecutor();
        
        // Runnable task3 = () -> {                     // expression lambda
        //     for (int i = 0; i < 3; i++) {
        //         System.out.println(i + " - Exécuté par le thread : " + Thread.currentThread().getName());
        //         try {
        //             Thread.sleep(500);
        //         } catch (InterruptedException e) {
        //         }
        //     }
        // };

        // Runnable task4 = () -> {                     // expression lambda
        //     for (int i = 3; i < 6; i++) {
        //         System.out.println(i + " - Exécuté par le thread : " + Thread.currentThread().getName());
        //         try {
        //             Thread.sleep(500);
        //         } catch (InterruptedException e) {
        //         }
        //     }
        // };
        
        // ex.execute(task3);      // executer avant
        // ex.execute(task4);      // executer après (parce que c'est un seul thread)
        // ex.shutdown();
        
        // System.out.println("Les Executor : newCachedThreadPool ");
        
        // ExecutorService exCached = Executors.newCachedThreadPool();
        
        // exCached.execute(task3);      // executer en meme temps
        // exCached.execute(task4);      // executer en meme temps (parce que c'est multiple thread)
        // exCached.shutdown();

        // System.out.println("Les Executor : newFixedThreadPool ");
        
        // ExecutorService exFixed = Executors.newFixedThreadPool(4);

        // Future<?> fut2 = exFixed.submit(task4);
        
        // while(!fut2.isDone()) {             // tant que le traitement "fut2" n'est pas fini
        //     System.out.println("waiting...");
        //     try {
        //         Thread.sleep(1000);
        //     } catch (InterruptedException e) {
        //     }
        // }
        
        // if (fut2.isDone()) {
        //     System.out.println("Future 2 est términé!!!");
        // }
        
        // Future<String> fut1 = exFixed.submit(task3,"Je suis la Future1 qui est termine!!!!!!!!!!!!!!!");
        
        // if (fut1.isDone()) {
        //     try {
        //         System.out.println(fut1.get());
        //     } catch (Exception e) {
        //     }
        // }

        // exFixed.shutdown();
        


        System.out.println("-----------------------");
        System.out.println("Les JDBC : sqlite ");
        System.out.println("-----------------------");
        
        // Connection conn = null;
        try {
            // Charger le driver JDBC pour SQLite
            // Class.forName("org.sqlite.JDBC");
            
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Elgissio\\Desktop\\Learn-java\\practice\\services\\products.db");     
            
            System.out.println("Connexion réussie !");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");
            while (rs.next()) {
                System.out.println(rs.getInt("product_id") + " - " + rs.getString("product_name"));
            }
            System.out.println("-----------------------");
            
            String req = "DELETE FROM products WHERE product_id = 9";
            stmt.executeUpdate(req);
            
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM products");
            while (rs2.next()) {
                System.out.println(rs2.getInt("product_id") + " - " + rs2.getString("product_name"));
            }
            
            // rs.close();
            // stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // extracted(conn);
            System.out.println("Connexion fermée !");
        }


        System.out.println("-----------------------");
        System.out.println("Les JDBC : MySQL ");
        System.out.println("-----------------------");
        
        // Connection conn = null;
        try {
            // Charger le driver JDBC pour MySQL
            // Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3301/gestion_stock_db?useSSL=false", "root", "");    
            
            System.out.println("Connexion réussie !");

            Statement stmt2 = conn2.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT * FROM users");
            while (rs2.next()) {
                System.out.println(rs2.getInt("id_user") + " - " + rs2.getString("nom_user"));
            }
            System.out.println("-----------------------");
            
            String req = "DELETE FROM users WHERE id_user = 9";
            stmt2.executeUpdate(req);
            
            ResultSet rs3 = stmt2.executeQuery("SELECT * FROM users");
            while (rs3.next()) {
                System.out.println(rs3.getInt("id_user") + " - " + rs3.getString("nom_user"));
            }
            
            // rs.close();
            // stmt2.close();
            conn2.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // extracted(conn);
            System.out.println("Connexion fermée !");
        }


    }

    // private static void extracted(Connection conn) throws SQLException {
    //     conn.close();
    // }

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
