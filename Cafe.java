/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;
 
    /**
     * Overloaded constructor with adress
     * @param address Address of the Cafe
     */
    public Cafe(String address) {
        super(address);
        this.address = address;
        this.nFloors = 1;
        }
    /** Overloaded constructor with name, address 
    *@param name Name of the Cafe
    * @param address Address of the Cafe
    */
    public Cafe(String name, String address) {
        super(name,address);
        this.nFloors = 1;
    }
    /**
     * initializes variables 
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     * @param name
     * @param address
     * @param nFloors
     */
    public Cafe(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, String name, String address, int nFloors) {
        super(name, address, nFloors);
        //super("Compass", "Chapin Way", 2);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }
    /**
     * selling coffee, restocking when necessary
     * @param size
     * @param nSugarPackets
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size) {
            restock(100, 0, 0, 0);
        }
        this.nCoffeeOunces -= size;
        if (this.nSugarPackets < nSugarPackets) {
            restock(0, 60, 0, 0);
        }
        this.nSugarPackets -= nSugarPackets;
        if (this.nCreams < nCreams) {
            restock(0, 0, 60, 0);
        }
        this.nCreams -= nCreams;
        if (this.nCups == 0) {
            restock(0, 0, 0, 60);
        }
        this.nCups -= 1;
        System.out.println(String.valueOf(nCoffeeOunces) + " ounces, " + String.valueOf(nCups) + " cups, "
         + String.valueOf(nCreams) + " creams, and " + String.valueOf(nSugarPackets) + " sugar packets remain in stock.");
    }
    /**
     * 
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        if (nCoffeeOunces != 0) {
            this.nCoffeeOunces = nCoffeeOunces;
        }
        if (nSugarPackets != 0) {
            this.nSugarPackets = nSugarPackets;
        }
        if (nCreams != 0) {
            this.nCreams = nCreams;
        }
        if (nCups != 0) {
            this.nCups = nCups;
        }
    }

   /** Keeps the person on floor one
     * @param floorNum the floor number to go to
     * @throws RuntimeException If customer asks to go to a different floor
     */
   public void goToFloor(int floorNum) {
        if (floorNum != this.nFloors){
            throw new RuntimeException("Invalid floor number. You may only stay in the first floor");
        }
    }

    /**
     * testing methods 
     * @param args
     */
    public static void main(String[] args) {
        Cafe compass = new Cafe(20, 10, 5, 3, "compass", "1 Chapin Way", 1);
        System.out.println(compass);
        compass.sellCoffee(12, 02, 03);
        compass.sellCoffee(25, 03, 05);
        compass.sellCoffee(12, 03, 05);
        compass.enter();
        compass.exit();
    }
    
}
