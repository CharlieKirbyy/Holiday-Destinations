// This imports the folder with all the individual classes that we will need
import CSCM41_956306.*;
/*Imports the tools necessary to the program, these two will be in almost every class 
and will not need commenting on again! */
import java.util.List;
import java.util.Scanner;



public class Booking {
  // Creates a Scanner object to read the users input
  private static Scanner scanner = new Scanner(System.in);

  // Creates a Continent object
  private static Continent continent = new Continent();

  // The main method that will run when you start the program
  public static void main(String[] args) {
    // Enters a loop that displays the main menu and waits for user input
    while (true) {
      printMenu();
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 1:
          // Takes you to the method to add a new country to a continent and runs that
          addCountry();
          break;
        case 2:
          // Takes you to the method to add new details of a destination and runs that
          addDestination();
          break;
        case 3:
          // Takes you to the method to show all country statistics and runs that
          showStatistics();
          break;
        case 4:
          // Exits the program entirely
          return;
        default:
          /*
           * If the user fails to input a valid number they will be met with an error
           * message and prompted to try again.
           */
          System.out.println("Invalid choice. Please try again.");
          break;
      }
    }
  }

  // Prints out the main menu that the user will see when opening the program
  private static void printMenu() {
    System.out.println("Menu:");
    System.out.println("1. Add a new country to a continent");
    System.out.println("2. Add new details of a destination");
    System.out.println("3. Show country statistics");
    System.out.println("4. Exit");
    System.out.print("Input a number between 1 and 4: ");
  }

  /*
   * A method that allows the user to add a country to a continent and also the
   * language they speak and whether they are open to tourists
   */
  private static void addCountry() {
    /*
     * Enter a loop that continues until the user decides to stop adding
     * countries/until the enter the correct number
     */
    while (true) {
      // Prompt the user to choose a continent for the country
      System.out.println("Which continent is your country on? \nInput a number between 1 and 7:");
      System.out.println("1. Africa");
      System.out.println("2. Antarctica");
      System.out.println("3. Asia");
      System.out.println("4. Europe");
      System.out.println("5. North America");
      System.out.println("6. Australia");
      System.out.println("7. South America");
      int continentDecision = scanner.nextInt();
      scanner.nextLine();
      // Process the user's continent choice
      switch (continentDecision) {
        case 1:
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          break;
        case 7:
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
          return;
      }

      /*
       * Asks the user for inputs of country, language and open to tourists and stores
       * them in their assigned variables
       */
      System.out.print("Enter the name of the your country: ");
      String name = scanner.nextLine();
      System.out.print("Enter the language spoken in your country: ");
      String language = scanner.nextLine();
      System.out.print("Are they are open to tourists? Input yes or no: ");
      String allowTourists = scanner.nextLine();
      // Information is stored into a new Country object using user input from above
      Country country = new Country(name, language, allowTourists);
      continent.addCountry(country);
      System.out.println("Country added successfully.");

      System.out.println("Would you like to add another country? yes or no : \n1. Yes \n2. No ");
      String anotherCountry = scanner.nextLine();
      /*
       * If the user does not want to add another country this takes them back to the
       * main menu
       */
      if (anotherCountry.equalsIgnoreCase("no")) {
        break;
      }
    }
  }

  /*
   * Method which allows the user to add new details about a destination within a
   * country
   */
  private static void addDestination() {
    /*
     * Prompt the user to enter the name of the country and checks if the country
     * name exists in the list of countries
     */
    System.out.print("Enter the name of the country: ");
    String countryName = scanner.nextLine();
    Country country = continent.getCountry(countryName);

    /*
     * If the entered country name does not exist, display an error message and
     * return to the main menu
     */
    if (country == null) {
      System.out.println("Country not found.");
      return;
    }
    /*
     * Prompt the user to enter the name, capacity, latitude and longitude of the
     * destination.
     */
    System.out.print("Enter the name of the destination: ");
    String name = scanner.nextLine();
    System.out.print("Enter the capacity of the destination: ");
    int capacity = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter the latitude of the destination: ");
    double latitude = scanner.nextDouble();
    System.out.print("Enter the longitude of the destination: ");
    double longitude = scanner.nextDouble();
    // Information is stored into a new Country object using user input from above
    Destination destination = new Destination(name, capacity, latitude, longitude);
    // Adds the new destination to its country
    country.addDestination(destination);
    System.out.println("Destination added successfully.");
  }

  private static void showStatistics() {
    while (true) {
      // Prints out the statistics menu
      System.out.println("Statistics menu:");
      System.out.println("IMPORTANT \n*Only look at statistics once they have been inputted in the destinations section!*");
      System.out.println("1. Show country with highest average destination capacity");
      System.out.println("2. Show destination with highest capacity");
      System.out.println("3. Show country with highest number of destinations");
      System.out.println("4. Search for destinations with capacity over a certain number");
      System.out.println("5. Go back to main menu");
      System.out.print("Enter your choice of number between 1 and 5: ");
      int choice = scanner.nextInt();
      // Clears the buffer
      scanner.nextLine();
      // Use a switch statement to allow the user to choose a menu option
      switch (choice) {
        case 1:
          /*
           * Get the country with the highest average destination capacity and print the
           * name of the country
           */
          Country highestAvgCapacityCountry = continent.getCountryWithHighestAvgDestinationCapacity();
          System.out.println("Country with highest average destination capacity: "
                            + highestAvgCapacityCountry.getName());
          break;
        case 2:
          /*
           * Get the destination with the highest capacity and print the name of the
           * destination
           */
          Destination highestCapacityDestination = continent.getDestinationWithHighestCapacity();
          System.out.println("Destination with highest capacity: " 
              + highestCapacityDestination.getName());
          break;
        case 3:
          /*
           * Get the country with the highest number of destinations and print the name of
           * the country
           */
          Country highestNumDestinationsCountry = continent.getCountryWithHighestNumDestinations();
          System.out.println("Country with highest number of destinations: "
              + highestNumDestinationsCountry.getName());      
          break;
        case 4:
          // Gets the user to enter a minimum capacity
          System.out.print("Enter the minimum capacity: ");
          int minCapacity = scanner.nextInt();
          // Clears the buffer
          scanner.nextLine();
          /*
           * Get the list of destinations with capacity over the minimum capacity and
           * prints the list of destinations
           */
          List<Destination> destinationsWithCapacityOver = continent
                            .getDestinationsWithCapacityOver(minCapacity);
          System.out.println("Destinations with capacity over " + minCapacity + ":");
          for (Destination destination : destinationsWithCapacityOver) {
            System.out.println("- " + destination.getName() + " (" + destination.getCapacity() + ")");
          }
          break;
        case 5:
          return;
        default:
          /*
           * If the user fails to input a valid number they will be met with an error
           * message and prompted to try again.
           */
          System.out.println("Invalid choice. Please try again.");
          break;
      }
    }
  }
}