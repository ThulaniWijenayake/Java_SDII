public class Person {

    //attributes
    private  String name;
    private  String sure_name;
    private  String email;

    // creating the constructor Person
    public Person(String email,String name,String sure_name) {
        this.email = email;
        this.name = name;
        this.sure_name = sure_name;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSure_name() {
        return sure_name;
    }

}


