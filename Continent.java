import java.util.ArrayList;
import java.util.List;

public class Continent {
  // A list to store the countries on this continent
  private List<Country> countries;

  /*
   * Constructor to create a new Continent object, this initializes the list of
   * countries
   */
  public Continent() {
    this.countries = new ArrayList<>();
  }

  // Method to add a new country to this continent
  public void addCountry(Country country) {
    this.countries.add(country);
  }

  /*
   * Method to get a country on this continent by its name and checks if the
   * current country's name matches the input name
   */
  public Country getCountry(String name) {
    for (Country country : countries) {
      if (country.getName().equalsIgnoreCase(name)) {
        return country;
      }
    }
    // Return null if no matching country is found
    return null;
  }

  /*
   * Method to get the country on this continent with the highest average
   * destination capacity
   */
  public Country getCountryWithHighestAvgDestinationCapacity() {
    Country highestAvgCapacityCountry = null;
    double highestAvgCapacity = Double.MIN_VALUE;
    for (Country country : this.countries) {
      double avgCapacity = country.getAvgDestinationCapacity();
      if (avgCapacity > highestAvgCapacity) {
        highestAvgCapacity = avgCapacity;
        highestAvgCapacityCountry = country;
      }
    }
    return highestAvgCapacityCountry;
  }

  /*
   * A method to get the destination with the highest by looking for it and
   * storing it in highestCapacityDestination
   */
  public Destination getDestinationWithHighestCapacity() {
    Destination highestCapacityDestination = null;
    int highestCapacity = Integer.MIN_VALUE;
    for (Country country : this.countries) {
      for (Destination destination : country.getDestinations()) {
        /*
         * If the capacity is greater than the highest capacity found so far, update the
         * variables
         */
        int capacity = destination.getCapacity();
        if (capacity > highestCapacity) {
          highestCapacity = capacity;
          highestCapacityDestination = destination;
        }
      }
    }
    return highestCapacityDestination;
  }

  // A method to get the country with the highest amount of destinations
  public Country getCountryWithHighestNumDestinations() {
    Country highestNumDestinationsCountry = null;
    int highestNumDestinations = 0;
    for (Country country : countries) {
      int numDestinations = country.getDestinations().size();
      /*
       * If the number of destinations in the current country is greater than the
       * highest number of destinations found so far, update the variables
       */
      if (numDestinations > highestNumDestinations) {
        highestNumDestinations = numDestinations;
        highestNumDestinationsCountry = country;
      }
    }
    return highestNumDestinationsCountry;
  }

  /*
   * A method to return the list of destinations with capacity over or equal to
   * the minimum capacity
   */
  public List<Destination> getDestinationsWithCapacityOver(int minCapacity) {
    List<Destination> destinationsWithCapacityOver = new ArrayList<>();
    for (Country country : countries) {
      for (Destination destination : country.getDestinations()) {
        /*
         * If the capacity of the current destination is greater than or equal to the
         * minimum capacity, add the destination to the list
         */
        if (destination.getCapacity() >= minCapacity) {
          destinationsWithCapacityOver.add(destination);
        }
      }
    }
    return destinationsWithCapacityOver;
  }

}
