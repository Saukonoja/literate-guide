package rest;

public class User {
    
    //Attributes for a single row written to database
    public String username;
    public String firstname;
    public String lastname;
    public int age;

    //default constructor. 
    //This has to call to 'super();' otherwise Maven gives error in build 
    public User(){
        super();
    }

    //Constructor we actually use to create objects of this class
    public User(String username, String firstname, String lastname, int age) {
        this.username = username;
	    this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getFirstname() {
	   return firstname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}

