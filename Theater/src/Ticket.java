public class Ticket {

    //attributes
    private int row;
    private int seat;
    private double price;
    private Person person;

    //creating the constructor Ticket including the Person java class file
    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    // printing the ticket info which are taken by the user
    public void print() {
        System.out.println("Name: " + person.getName());
        System.out.println("Sure name: " + person.getSure_name());
        System.out.println("Email: " + person.getEmail());

        System.out.println("Row: " +getRow());
        System.out.println("Seat: " +getSeat());
        System.out.println("Price: " + getPrice());
    }

    // Getters
    public int getRow() {
        return row;
    }
    public int getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }


}


