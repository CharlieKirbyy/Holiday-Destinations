public class Destination {
  // The name, capacity, latitude and longitude variables of the destination
  private String name;
  private int capacity; 
  private double latitude;
  private double longitude;

  // Constructor to create the new Destination object
  public Destination(String name, int capacity, double latitude, double longitude) {
    this.name = name;
    this.capacity = capacity;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  // Getter for the name of the destination
  public String getName() {
    return name;
  }

  // Getter for the capacity of the destination
  public int getCapacity() {
    return capacity;
  }

  // Getter for the latitude of the destination
  public double getLatitude() {
    return latitude;
  }

  // Getter for the longitude of the destination
  public double getLongitude() {
    return longitude;
  }
}