import java.util.Scanner;

class Room {

    private int roomNumber;
    private String roomType;
    private String customerName;
    private int numberOfDays;
    private double pricePerDay;
    private boolean bookingStatus;

    static int totalBookings = 0;

    // Parameterized constructor
    Room(int roomNumber, String roomType, double pricePerDay) {

        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerDay = pricePerDay;
        this.bookingStatus = false;
        this.customerName = "";
        this.numberOfDays = 0;
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean getBookingStatus() {
        return bookingStatus;
    }

    // Setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    // Book room
    public void bookRoom(String customerName, int numberOfDays) {

        if (bookingStatus == false) {

            this.customerName = customerName;
            this.numberOfDays = numberOfDays;
            this.bookingStatus = true;

            totalBookings++;

            System.out.println("Room booked successfully.");

        } else {
            System.out.println("Room is already booked.");
        }
    }

    // Display room details
    public void displayDetails() {

        System.out.println("Room Number   : " + roomNumber);
        System.out.println("Room Type     : " + roomType);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Number of Days: " + numberOfDays);
        System.out.println("Price Per Day : ₹" + pricePerDay);
        System.out.println("Booking Status: " + bookingStatus);
    }

    // Calculate bill
    public void calculateBill() {

        double bill = numberOfDays * pricePerDay;

        System.out.println("Total Bill    : ₹" + bill);
    }

    // Cancel booking
    public void cancelBooking() {

        if (bookingStatus == true) {

            bookingStatus = false;
            customerName = "";
            numberOfDays = 0;

            System.out.println("Booking cancelled successfully.");

        } else {
            System.out.println("Room is not booked.");
        }
    }
}

public class HotelBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Room room1 = new Room(101, "Standard", 2000);
        Room room2 = new Room(205, "Deluxe", 3500);
        Room room3 = new Room(301, "Premium", 5000);

        while (true) {

            System.out.println();
            System.out.println("===== Hotel Room Booking System =====");
            System.out.println("1. Book Room");
            System.out.println("2. Display Room Details");
            System.out.println("3. Calculate Bill");
            System.out.println("4. Check Room Status");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Display Total Bookings");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter room number: ");
                    int roomNumber = sc.nextInt();

                    Room selectedRoom = null;

                    if (roomNumber == 101) {
                        selectedRoom = room1;
                    } else if (roomNumber == 205) {
                        selectedRoom = room2;
                    } else if (roomNumber == 301) {
                        selectedRoom = room3;
                    } else {
                        System.out.println("Room not found.");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter number of days: ");
                    int days = sc.nextInt();

                    System.out.println();
                    System.out.println("===== Booking Confirmation =====");

                    selectedRoom.bookRoom(name, days);

                    if (selectedRoom.getBookingStatus()) {
                        System.out.println("Room Number   : " + selectedRoom.getRoomNumber());
                        System.out.println("Room Type     : " + selectedRoom.getRoomType());
                        System.out.println("Customer Name : " + selectedRoom.getCustomerName());
                        System.out.println("Number of Days: " + selectedRoom.getNumberOfDays());
                        System.out.println("Price Per Day : ₹" + selectedRoom.getPricePerDay());

                        System.out.println();
                        selectedRoom.calculateBill();
                    }

                    break;

                case 2:

                    System.out.print("Enter room number: ");
                    int room2Number = sc.nextInt();

                    if (room2Number == 101) {
                        room1.displayDetails();
                    } else if (room2Number == 205) {
                        room2.displayDetails();
                    } else if (room2Number == 301) {
                        room3.displayDetails();
                    } else {
                        System.out.println("Room not found.");
                    }

                    break;

                case 3:

                    System.out.print("Enter room number: ");
                    int billRoom = sc.nextInt();

                    if (billRoom == 101) {
                        room1.calculateBill();
                    } else if (billRoom == 205) {
                        room2.calculateBill();
                    } else if (billRoom == 301) {
                        room3.calculateBill();
                    } else {
                        System.out.println("Room not found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter room number: ");
                    int statusRoom = sc.nextInt();

                    if (statusRoom == 101) {

                        if (room1.getBookingStatus()) {
                            System.out.println("Room is booked.");
                        } else {
                            System.out.println("Room is available.");
                        }

                    } else if (statusRoom == 205) {

                        if (room2.getBookingStatus()) {
                            System.out.println("Room is booked.");
                        } else {
                            System.out.println("Room is available.");
                        }

                    } else if (statusRoom == 301) {

                        if (room3.getBookingStatus()) {
                            System.out.println("Room is booked.");
                        } else {
                            System.out.println("Room is available.");
                        }

                    } else {
                        System.out.println("Room not found.");
                    }

                    break;

                case 5:

                    System.out.print("Enter room number: ");
                    int cancelRoom = sc.nextInt();

                    if (cancelRoom == 101) {
                        room1.cancelBooking();
                    } else if (cancelRoom == 205) {
                        room2.cancelBooking();
                    } else if (cancelRoom == 301) {
                        room3.cancelBooking();
                    } else {
                        System.out.println("Room not found.");
                    }

                    break;

                case 6:

                    System.out.println("Total Bookings: " + Room.totalBookings);
                    break;

                case 7:

                    System.out.println("Thank you! Exiting the program.");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

