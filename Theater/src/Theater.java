import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Theater {

    //initializing variables
    static int s, r;
    static int[] row1 = new int[12];
    static int[] row2 = new int[16];
    static int[] row3 = new int[20];
    static ArrayList<Ticket> ticket_list = new ArrayList<>();

    // method buy ticket, where the user put his/her info and book the ticket
    public static void buy_ticket() {
        // taking information from the user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String person_name = input.nextLine();
        System.out.println("Enter the email: ");
        String person_email = input.nextLine();
        System.out.println("Enter the surname: ");
        String person_sure_name = input.nextLine();

        // putting users' information in to the person java file
        Person person = new Person(person_email, person_name, person_sure_name);
        double price;

        // try-catch block to give a warning for entering an invalid input
        try {
            System.out.println("Enter the row number (1-3):");
            r = input.nextInt();
            //row validation
            if (r >= 1 && r <= 3) {

                    if (r == 1) {
                        System.out.println("Enter the seat number (1-12):");

                        // subtracting 1 from the seat number because of the array index starts from zero
                        s = input.nextInt() - 1;

                        //checking seat availability and booking the seat if available
                        if (row1[s] == 1) {

                            System.out.println("Seat not available");
                        } else {
                            System.out.println("Seat available");
                            row1[s] = 1;

                            // taking the ticket price from the user
                            System.out.println("Please enter the ticket price: ");
                            price = input.nextDouble();
                            System.out.println("You have successfully booked your seat!");


                            // adding the users' information, row number, seat number and the price to the array list
                            Ticket ticket = new Ticket(r, s + 1, price, person);
                            ticket_list.add(ticket);
                        }
                    }

                    if (r == 2) {
                        System.out.println("Enter the seat number (1-16):");

                        s = input.nextInt() - 1;

                        if (row2[s] == 1) {
                            System.out.println("Seat not available");
                        } else {
                            System.out.println("Seat available");
                            row2[s] = 1;

                            System.out.println("Please enter the ticket price: ");
                            price = input.nextDouble();
                            System.out.println("You have successfully booked your seat!");

                            Ticket ticket = new Ticket(r, s + 1, price, person);
                            ticket_list.add(ticket);
                        }
                    }

                    if (r == 3) {
                        System.out.println("Enter the seat number (1-20):");

                        s = input.nextInt() - 1;

                        if (row3[s] == 1) {
                            System.out.println("Seat not available");
                        } else {
                            System.out.println("Seat available");
                            row3[s] = 1;

                            System.out.println("Please enter the ticket price: ");
                            price = input.nextDouble();
                            System.out.println("You have successfully booked your seat!");
                            Ticket ticket = new Ticket(r, s + 1, price, person);
                            ticket_list.add(ticket);

                        }
                    }
                } else {
                System.out.println("Incorrect row number! Please check again!");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Please enter a valid input!");
        }
    }


    // printing the aligned seating area when user enters option 2
    public static void print_seating_area() {

        // printing the stage with star marks
        System.out.println("\t ***********");
        System.out.println("\t *  STAGE  *");
        System.out.println("\t ***********");

        // calculating the starting and the ending space length in row 1
        int first_row = (row3.length - row1.length) / 2;

        for (int r = 0, j = 0; j < (row1.length + first_row); j++) {

            if (j < first_row) {
                System.out.print(" ");
            } else {
                // taking the middle space between two sides
                if (r == ((row1.length / 2))) {
                    System.out.print(" ");
                }

                // printing the booked seats with a 'X'
                if (row1[r] == 1) {
                    System.out.print("X");
                } else {
                    // printing the free seats with a 'O'
                    System.out.print("O");

                }
                r++;
            }
        }
        System.out.println();

        // calculating the starting and the ending space in row 2
        int second_row = (row3.length - row2.length) / 2;

        for (int r = 0, j = 0; j < (row2.length + second_row); j++) {

            if (j < second_row) {
                System.out.print(" ");
            } else {

                if (r == ((row2.length / 2))) {
                    System.out.print(" ");
                }

                if (row2[r] == 1) {
                    System.out.print("X");
                } else {
                    System.out.print("O");

                }
                r++;
            }
        }

        System.out.println();

        // calculating the starting and the ending space in row 3
        for (int r = 0, j = 0; j < (row3.length); j++) {

            if (r == ((row3.length / 2))) {
                System.out.print(" ");
            }

            if (row3[r] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");

            }
            r++;

        }

        System.out.println();
    }

    // cancelling the ticket when user enters option 3
    public static void cancel_ticket() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the row number: ");
        r = input.nextInt();
        //row validation
        if (r >= 1 && r <= 3) {
            if (r == 1) {
                System.out.println("Enter the seat number: ");
                s = input.nextInt() - 1;

                // checking if the seat is already free and if not cancelling the seat
                if (row1[s] == 1) {
                    row1[s] = 0;
                    System.out.println("You have successfully canceled your seat!");


                } else {
                    System.out.println("This seat is already free!");
                }
            }
            if (r == 2) {
                System.out.println("Enter the seat number: ");
                s = input.nextInt() - 1;

                //checking if the seat is already free and if not cancelling the seat
                if (row2[s] == 1) {
                    row2[s] = 0;
                    System.out.println("You have successfully canceled your seat!");

                } else {
                    System.out.println("This seat is already free!");
                }
            }
            if (r == 3) {
                System.out.println("Enter the seat number: ");
                s = input.nextInt() - 1;

                //checking if the seat is already free and if not cancelling the seat
                if (row3[s] == 1) {
                    row3[s] = 0;
                    System.out.println("You have successfully canceled your seat!");

                } else {

                    System.out.println("This seat is already free!");
                }
            }
        } else {
            System.out.println("Incorrect row number! Please check again!");
        }

        //removing the cancelled ticket from the arrayList
            boolean remove = false;
            for (Ticket ticket : ticket_list) {
                if (ticket.getRow() == r && ticket.getSeat() == s+1) {
                    ticket_list.remove(ticket);
                    remove = true;
                    break;
                }
            }
            if (!remove) {
                System.out.println();
            }


    }




    // showing the available seats when user enters option 4
    public static void show_available() {
        System.out.print("Seats available in row 1: ");
        for (r = 0; r < row1.length; r++) {
            if (row1[r] == 0) {

                // printing the array indexes and adding 1 because the array indexes starts from zero
                System.out.print( r+1+",");
            }
        }

        System.out.println();

        System.out.print("Seats available in row 2: ");
        for (r = 0; r < row2.length; r++) {
            if (row2[r] == 0) {
                System.out.print(r+1+",");
            }
        }
        System.out.println();

        System.out.print("Seats available in row 3: ");
        for (r = 0; r < row3.length; r++) {
            if (row3[r] == 0) {
                System.out.print(r+1+",");
            }
        }
        System.out.println();

    }

    // saving the available seats in three rows in to a file when user enters option 5
    public static void save() {
        // putting a try-catch to test for errors while this method being executed
        try {
            FileWriter writer = new FileWriter("test.txt");

            writer.write("Seats available in row 1: ");
            for (r = 0; r < row1.length; r++) {
                if (row1[r] == 0) {
                    // writing to the file
                    writer.write( r + 1 + ",");
                }
            }
            writer.write("\n");

            writer.write("Seats available in row 2: ");
            for (r = 0; r < row2.length; r++) {
                if (row2[r] == 0) {
                    writer.write( r + 1 + ",");
                }
            }
            writer.write("\n");

            writer.write("Seats available in row 3: ");
            for (r = 0; r < row3.length; r++) {
                if (row3[r] == 0) {
                    writer.write( r + 1 + ",");
                }
            }

            // closing the file
            writer.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    // loading the saved information in the file when user enters option 6
    public static void load(){

        // putting a try-catch to test for errors while this method being executed
        try {
            File file = new File("test.txt");
            Scanner file_reader = new Scanner(file);

            // reading the  file and printing
            while (file_reader.hasNextLine()) {
                String text = file_reader.nextLine();
                System.out.println(text);
            }

            file_reader.close();
        }
        catch (IOException e) {
            System.out.println("Error while reading a file.");
            e.printStackTrace();
        }
    }

    // showing the ticket info when user enters option 7
    public static void show_tickets_info() {

        // declaring the total_price variable to get the total price of the booked tickets
        double total_price = 0.0;

        //printing the ticket information from the print method of Ticket java file
        for(Ticket ticket : ticket_list) {

           ticket.print();

           System.out.println();


            total_price = total_price + ticket.getPrice();
        }

        System.out.println("total price of all tickets : " + total_price);
    }

    // sorting out the ticket prices in ascending order and printing the ticket info with the sorted prices when user enters option 8
    public static void sort_tickets() {

        //taking a variable named temp to exchange the values
        Ticket temp ;
        boolean exchanged = true;
        int bottom = ticket_list.size()-2;
        while(exchanged) {
            exchanged = false;
            for(int i=0; i<=bottom; i++) {
                // exchanging the places if the current element is larger, after comparing
                if(ticket_list.get(i).getPrice()>ticket_list.get(i+1).getPrice()) {
                    temp = ticket_list.get(i);
                    ticket_list.set(i,  ticket_list.get(i+1));
                    ticket_list.set((i+1), temp);
                    exchanged = true;
                }
            }
            bottom--;
        }

        // calling show ticket info method to print the ticket info after the prices being sorted
        show_tickets_info();
    }

    // main method which prints the menu and calls the methods separately
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // printing the welcome note
        System.out.println("Welcome to the New Theater !!");

        while(true) {
            System.out.println("Menu");
            System.out.println("--------------------------------------------------");
            System.out.println("Please select an option: ");
            System.out.println("1) Buy a Ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel Ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save");
            System.out.println("6) Load");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("0) Quit");
            System.out.println("--------------------------------------------------");
            System.out.println("Enter option: ");
            int option = input.nextInt();
            switch(option) {
                case 1:
                    buy_ticket();
                    break;
                case 2:
                    print_seating_area();
                    break;
                case 3:
                    cancel_ticket();
                    break;
                case 4:
                    show_available();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    load();
                    break;
                case 7:
                    show_tickets_info();
                    break;
                case 8:
                    sort_tickets();
                    break;
                case 0:
                    System.out.println("Program Ended! Thank you !!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option!");

            }

        }
    }

}



