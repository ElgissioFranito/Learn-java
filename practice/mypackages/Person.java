package mypackages;
public class Person 
{
    protected String name;
    protected int age;
    
    public Person() {
        System.out.println("Person created " + this);   // affiche l'adresse mémoire de l'instance
    }
    
    public Person(String name) {                        // surcharge de méthode
        this.name = name;
        System.out.println("Person created " + this);  
    }
    
    public Person(String name, int age) {               // surcharge de méthode
        this.name = name;
        this.age = age;
        System.out.println("Person created " + this);  
    }

    public String getName() {
        if (this.name == null) {
            return "Nom non défini";
        }
        return this.name;
    }
}
