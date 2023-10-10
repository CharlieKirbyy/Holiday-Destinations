import java.util.ArrayList;
import java.util.List;

public class Country {
  /*
   * Instance variables for name, language, tourist status, and list of
   * destinations
   */
  private String name;
  private String language;
  private String allowTourists;
  private List<Destination> destinations;

  // Constructor to initialize instance variables
  public Country(String name, String language, String allowTourists2) {
    this.name = name;
    this.language = language;
    this.allowTourists = allowTourists2;
    this.destinations = new ArrayList<>();
  }

  // Method to calculate total capacity of all destinations in a given country
  public int getTotalCapacity() {
    int totalCapacity = 0;
    for (Destination destination : destinations) {
      totalCapacity += destination.getCapacity();
    }
    return totalCapacity;
  }

  // Getter method for name
  public String getName() {
    return this.name;
  }

  // Getter method for language
  public String getLanguage() {
    return this.language;
  }

  // Getter method for tourists status
  public String isOpenToTourists() {
    return this.allowTourists;
  }

  // Method to add a destination to the list of destinations
  public void addDestination(Destination destination) {
    this.destinations.add(destination);
  }

  // Getter method for the list of destinations
  public List<Destination> getDestinations() {
    return this.destinations;
  }

  // Method to find the destination with the highest capacity
  public Destination getDestinationWithHighestCapacity() {
    Destination highestCapacityDestination = null;
    int highestCapacity = Integer.MIN_VALUE;
    for (Destination destination : this.destinations) {
      int capacity = destination.getCapacity();
      if (capacity > highestCapacity) {
        highestCapacity = capacity;
        highestCapacityDestination = destination;
      }
    }
    return highestCapacityDestination;
  }

  /*
   * Method to calculate the average capacity of all destinations in the country
   * by dividing total capacity by number of destinations
   */
  public double getAvgDestinationCapacity() {
    if (this.destinations.isEmpty()) {
      return 0;
    }
    double totalCapacity = 0;
    // Iterate through all destinations and add their capacities to totalCapacity
    for (Destination destination : this.destinations) {
      totalCapacity += destination.getCapacity();
    }
    return totalCapacity / this.destinations.size();
  }

  // Method to find destinations with capacity greater than a given value
  public List<Destination> getDestinationsWithCapacityGreaterThan(int capacity) {
    List<Destination> highCapacityDestinations = new ArrayList<>();
    for (Destination destination : this.destinations) {
      if (destination.getCapacity() > capacity) {
        highCapacityDestinations.add(destination);
      }
    }
    return highCapacityDestinations;
  }
}