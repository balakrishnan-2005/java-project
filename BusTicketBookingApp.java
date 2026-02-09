import java.util.*;
//class
class Bus {
    private int busNo;
    private String source;
    private String destination;
    private int seats;
    //constructor declaration
    public Bus(int busNo, String source, String destination, int seats) {
        this.busNo = busNo;
        this.source = source;
        this.destination = destination;
        this.seats = seats;
    }

    // Getters
    public int getBusNo() { return busNo; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getSeats() { return seats; }

    // Method to display bus details
    public void displayInfo() {
        System.out.println("Bus No: " + busNo + " | From: " + source + " | To: " + destination + " | Seats Available: " + seats);
    }

    // Method to book seats
    public boolean bookSeats(int count) {
        if (count <= seats) {
            seats -= count;
            return true;
        }
        return false;
    }
}
//class list of bus
class BusService {
    private List<Bus> buses = new ArrayList<>();

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public Bus findBus(String source, String destination) {
        for (Bus bus : buses) {
            if (bus.getSource().equalsIgnoreCase(source) && bus.getDestination().equalsIgnoreCase(destination)) {
                return bus;
            }
        }
        return null;
    }

    // Show all available buses
    public void showAllBuses() {
        System.out.println("\n=== Available Buses ===");
        //for each loop are uesd
        for (Bus bus : buses) {
            bus.displayInfo();
        }
        System.out.println("========================\n");
    }
}
//main class
public class BusTicketBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BusService service = new BusService();

        // Adding predefined buses
        service.addBus(new Bus(46, "JJCET", "Manapparai", 5));
        service.addBus(new Bus(62, "Srirangam", "JJCET", 3));
        service.addBus(new Bus(67, "JJCET", "KK Nagar", 4));
        service.addBus(new Bus(70, "Karaikudi", "JJCET", 2));
        service.addBus(new Bus(75, "Kolachale", "JJCET", 10));
        service.addBus(new Bus(61, "Thanjavur", "JJCET", 5));

        System.out.println("===== BALAKRISHNAN Travels Bus Ticket Booking System =====");

        // Display all buses first
        service.showAllBuses();

        System.out.print("Enter Source: ");
        String source = sc.nextLine();
        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();

        Bus bus = service.findBus(source, destination);

        if (bus != null) {
            bus.displayInfo();
            System.out.print("Enter number of seats to book: ");
            int seatsToBook = sc.nextInt();

            if (bus.bookSeats(seatsToBook)) {
                System.out.println("\n✅ Booking Successful!");
                System.out.println("🧾 Ticket Details:");
                System.out.println("Bus No: " + bus.getBusNo());
                System.out.println("From: " + bus.getSource() + " → To: " + bus.getDestination());
                System.out.println("Seats Booked: " + seatsToBook);
                System.out.println("Remaining Seats: " + bus.getSeats());
            } else {
                System.out.println("Not enough seats available.");
            }
        } else {
            System.out.println("No buses available for the selected route.");
        }

        sc.close();
    }
}
