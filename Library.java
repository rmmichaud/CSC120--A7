/* This is a stub for the Library class */
import java.util.*;
public class Library extends Building {
    private Hashtable<String, Boolean> collection;
    /**
     * overloaded constructor with only address
     * @param address
     */
    public Library(String address) {
      super(address);
      this.address = address;
      this.nFloors = 1;
      }
    /** 
     * overloaded constructor with name, address 
    *@param name Name of the Cafe
    * @param address Address of the Cafe
    */
    public Library(String name, String address) {
        super(name,address);
        this.nFloors = 1;
    }
    private boolean hasElevator;
    /**
     * initializes building and collection
     * @param hasElevator
     */
    public Library(boolean hasElevator) {
      super("Nielson", "Chapin Way", 5);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
    }
    /**
     * returns boolean depending on whether the building has an elevator 
     * @return hasElevator
     */
    public boolean hasElevator(){
      return hasElevator;
    } 
    /**
     * adds titles to the collection
     * @param title
     */
    public void addTitle(String title) {
      this.collection.put(title, true);
      System.out.println(title + " is added to the collection.");
    }
    /**
     * removes titles from collection, returns title 
     * @param title
     * @return 
     */
    public String removeTitle(String title) {
      this.collection.remove(title, true);
      System.out.println(title + " is removed from the collection.");
      return title;
    }
    /**
     * checks out titles from collection by changing value to false
     * @param title
     */
    public void checkOut(String title) {
      boolean defVal = this.collection.getOrDefault(title, false);
      if (defVal == true) {
        this.collection.replace(title, true, false);
        System.out.println(title +  " is now checked out.");
      } else {
        System.out.println(title + " is not available.");
      }
    }
    /**
     * returns title to collection by value to true 
     * @param title
     */
    public void returnBook(String title) {
      this.collection.replace(title, false, true);
      System.out.println(title + " has been returned.");
    }
    /**
     * checks if boook is in collection, returns false if not
     * @param title
     * @return
     */
    public boolean containsTitle(String title) {
      if (this.collection.containsKey(title)) {
        System.out.println(title + " is in the collection.");
        return true;
      } else {
        System.out.println(title + " is currently not in the collection.");
        return false;
      }
    }
    /**
     * checks if boook is in collection, returns false if checked out 
     * @param title
     * @return
     */
    public boolean isAvailable(String title) {
      boolean defVal = this.collection.getOrDefault(title, false);
      if (defVal == true) {
        return true;
      } else {
        return false;
      }
    }
    /**
     * prints collection
     */
    public void printCollection(){
      System.out.println(this.collection.toString());
    }
    /**
     * overrides the showOptions method to display the methods available in this class
     * @param Library
     */
    public void showOptions(Object Library) {
      System.out.println("Available options at " + this.name + ":\n + addTitle(Str) \n + removeTitle(Str) \n + checkOut(Str) \n + returnBook(Str)\n + containsTitle(Str)\n + isAvailable(Str)");
    }
    /** 
     * @param floorNum the floor number to go to
     * @throws RuntimeException If customer asks to go to a different floor
     */
    public void goToFloor(int floorNum) {
      if (this.hasElevator == true){
        super.goToFloor(floorNum);
      }
      if (this.hasElevator == false && (floorNum == activeFloor + 1 || floorNum == activeFloor -1 || floorNum == activeFloor)){
        super.goToFloor(floorNum);
      }else if(this.hasElevator == false) {
        throw new RuntimeException("Invalid floor number. This house has no elevator");
      }
    }

    /**
     * declares new library and tests methods 
     * @param args
     */
    public static void main(String[] args) {
      Library neilson = new Library(true);
      System.out.println(neilson);
      String title1 = "Great Gatsby";
      String title2 = "The Art of War";
      String title3 = "Moby Dick";
      String title4 = "War and Peace";
      neilson.addTitle(title1);
      neilson.addTitle(title2);
      neilson.addTitle(title3);
      neilson.addTitle(title4);
      neilson.printCollection();
      neilson.checkOut(title1);
      neilson.containsTitle(title1);
      neilson.checkOut(title4);
      neilson.returnBook(title1);
      neilson.containsTitle(title4);
      neilson.printCollection();
      neilson.returnBook(title4);
      neilson.removeTitle(title3);
      neilson.removeTitle(title1);
      neilson.printCollection();
      neilson.enter();
      neilson.goToFloor(5);

    }
  
  }