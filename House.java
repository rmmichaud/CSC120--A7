/* This is a stub for the House class */
//import java.lang.reflect.Array;
import java.util.*;
//import javax.management.RuntimeErrorException;
public class House extends Building {
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Overrides house constructor with house
   * @param address - the address of the house
   */
  public House(String address) {
    super(address);
    this.address = address;
    this.nFloors = 1;
    this.residents = new ArrayList<String>();
  }

  /**
   * Overrides House constructor with name and adress
   * @param name - name of the house
   * @param address - adress of the house
   */
  public House(String name, String address) {
    super(name,address);
    this.name = name;
    this.address = address;
    this.nFloors = 1;
    this.residents = new ArrayList<String>();
  }
  /**
   * initializes variables 
   * @param residents
   * @param hasDiningRoom
   * @param hasElevator
   * @param name
   * @param address
   * @param nFloors
   */
  public House (ArrayList<String> residents, boolean hasDiningRoom, boolean hasElevator, String name, String address, int nFloors) {
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
    this.residents = new ArrayList<String>(residents);
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }
  /**
   * returns number of residents in a house 
   * @param residents
   * @return
   */
  public int nResidents(ArrayList<String> residents) {
    return this.residents.size();
  }
  /**
   * returns boolean depending on whether the house has a dining room
   * @return
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
  } 
  public boolean hasElevator(){
    return hasElevator;
  } 
  /**
   * moves a student into a house if they don't already live there
   * @param Resident
   */
  public void moveIn(String Resident) {
    if (this.residents.contains(Resident)) {
      System.out.println(Resident + " already lives here.");
    } else {
      this.residents.add(Resident);
    } 
  }
  /**
   * moves a student out of the house if they already live there
   * @param Resident
   * @return
   */
  public String moveOut(String Resident) {
    if (this.residents.contains(Resident)) {
      this.residents.remove(Resident);
    } else {
      System.out.println(Resident + " does not live here.");
    } 
    return Resident;
  }
  /**
   * returns a boolean depending on whether a student lives in the house 
   * @param Resident
   * @return
   */
  private boolean isResident(String Resident) {
    return this.residents.contains(Resident);
    }
  /**
   * Goes into the dining room
   * @throws RuntimeException If user asks to go to a dining hall when house has no dining hall 
   */
  public void goToDiningRoom(){
    if(hasDiningRoom == false){
        throw new RuntimeException("This house has no dining room.");
    }else{
        System.out.println("You are now in the dining hall.");
    }
  }
  /**
   * If the House has an elevator it will go to that floor
   * @param floorNum - the desired floor 
   * @throws RuntimeException If user asks to go to a different floor
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
   * overrides the showOptions method to display the methods available in this class
   * @param House
   */
  public void showOptions(Object House) {
    System.out.println("Available options at " + this.name + ":\n + nResidents() \n + moveOut(Str) \n + moveIn(Str) \n + hasElevator\n + hasDiningRoom()\n + goToFloor(n) + goToDiningHall(boolean)");
  }

  /**
   * testing out the different methods 
   * @param args
   */
  public static void main(String[] args) {
    ArrayList<String> residents1 = new ArrayList<String>();
    residents1.add("Rachel");
    residents1.add("Lily");
    residents1.add("Marybella");
    residents1.add("Angelina");
    House sessions = new House(residents1, false, false, "Sessions", "10 Elm St", 4);
    System.out.println(sessions);
    sessions.moveOut("Rachel");
    sessions.moveOut("Rachel");
    System.out.println(sessions.isResident("Rachel"));
    sessions.moveIn("Rachel");
    System.out.println(sessions.nResidents(residents1));
    sessions.enter();
    sessions.goToFloor(2);
  }

}

