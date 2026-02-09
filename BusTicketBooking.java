import java.util.*;

class Bus {
    int busNo;
    String source;
    String destination;
    int seats;

    Bus(int busNo, String source, String destination, int seats) {
        this.busNo = busNo;
        this.source = source;
        this.destination = destination;
        this.seats = seats;
    }
}

public class BusTicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Predefined buses
        List<Bus> buses = new ArrayList<>();
        buses.add(new Bus(101, "Chennai", "Bangalore", 5));
        buses.add(new Bus(102, "Chennai", "Hyderabad", 3));
        buses.add(new Bus(103, "Bangalore", "Mumbai", 4));

        System.out.println("===== Bus Ticket Booking System =====");
        System.out.print("Enter Source: ");
        String source = sc.nextLine();

        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();

        boolean found = false;
        for (Bus bus : buses) {
            if (bus.source.equalsIgnoreCase(source) && bus.destination.equalsIgnoreCase(destination)) {
                System.out.println("\nBus Found!");
                System.out.println("Bus No: " + bus.busNo + " | Seats Available: " + bus.seats);

                System.out.print("Enter number of seats to book: ");
                int seatsToBook = sc.nextInt();

                if (seatsToBook <= bus.seats) {
                    bus.seats -= seatsToBook;
                    System.out.println("✅ Booking Successful!");
                    System.out.println("🧾 Ticket Details:");
                    System.out.println("Bus No: " + bus.busNo);
                    System.out.println("From: " + bus.source + " → To: " + bus.destination);
                    System.out.println("Seats Booked: " + seatsToBook);
                    System.out.println("Remaining Seats: " + bus.seats);
                } else {
                    System.out.println("❌ Not enough seats available.");
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ No buses available for the selected route.");
        }

        sc.close();
    }
}
