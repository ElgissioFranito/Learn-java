package mypackages;
public class Player extends Person{
    private int level;

    public Player() {
        super();                                        // utiliser le constructor de la classe parent
        this.level = 1;
        System.out.println(this.name + " - Level : " + this.level);
    }
    
    public Player(String name) {                            // surcharge de méthode
        super(name);                                        // utiliser le constructor de la classe parent
        this.level = 1;
        System.out.println(this.name + " - Level : " + this.level);
    }
    
    public Player(String name, int level) {                 // surcharge de méthode
        super(name);                                        // utiliser le constructor de la classe parent
        this.level = level;
        System.out.println(this.name + " - Level : " + this.level);
    }
    
    public Player(String name, int age, int level) {        // surcharge de méthode
        super(name, age);                                   // utiliser le constructor de la classe parent
        this.level = level;
        System.out.println(this.name + " - Level : " + this.level);
    }

    public void attack() {
        System.out.println(this.name + " attaque !");
    }
}
