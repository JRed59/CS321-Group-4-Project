//information that should be stored in the user
// class identifier - time start - time end - location
import java.util.ArrayList;
public class User {
    // **Q: do we need an option for day of the week?
    ArrayLisy <String> Identifier = new ArrayList<>();
    ArrayList <Integer> timeStart = new ArrayList<>();
    ArrayList <Integer> timeEnd = new ArrayList<>();
    ArrayList <String> location = new ArrayList<>();

    //Empty Constructor
    public User() {

    }

    public addID(String id) {
        Identifier.add(num);
    }

    public addStartTime(int num) {
        timeStart.add(num);
    }

    public addEndTime(int num) {
        timeEnd.add(num);
    }

    public addLocation(string loc) {
        location.add(loc);
    }

    //will need functions to return certain values from the class

}
