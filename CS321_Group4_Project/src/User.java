//information that should be stored in the user
// class identifier - time start - time end - location
public class User {
    // **Q: do we need an option for day of the week?
    String Identifier;
    int timeStart;
    int timeEnd;
    String location;

    //Empty Constructor
    public User() {

    }

    //User Constructor with all inputs
    public User(String Id, int start, int end, String loc){
        Identifier = Id;
        timeStart = start;
        timeEnd = end;
        location = loc;
    }

    //will need functions to return certain values from the class

}
