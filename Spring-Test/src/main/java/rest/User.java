package rest;

public class User {
    
    //Attributes for a single row written to database
    public String username;
    public String firstname;
    public String lastname;
    public int age;

    //default constructor. 
    //This has to call to 'super();' otherwise Maven gives error in build 
    public DataLocation(){
        super();
    }

    //Constructor we actually use to create objects of this class
    public DataLocation(String username, String firstname, String lastname, int age) {
        this.username = username;
	    this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    //Getters only. 
    //We do not need setters 
    //because the values of an object will not change in the objects lifetime
    //but we need to get the values of object to write them in the database
    public String getUsername() {
        return username;
    }
    public String getFirstname() {
	   return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public int getAge() {
        return age;
    }

}

