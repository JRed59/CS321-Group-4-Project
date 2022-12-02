import java.util.ArrayList;


//Class to handle creation of schedules
public class Schedule {
    public ArrayList<uahClass> classSchedule = new ArrayList<uahClass>();

    /**
     * Creates an ArrayList of all the user's classes
     * @param addedClass class being added to arraylist
     */
    public void addToSchedule(uahClass addedClass){
        this.classSchedule.add(addedClass);
    }

    public String viewSchedule(){
        String oString = "Current Schedule\n";
        int counter = 1;
        for (uahClass a:classSchedule
             ) {
            oString+= "Class " + counter + ":\n" +  a.name + "\n in the " +a.location + "\non " +a.day + "\nduring" +a.startTime + "-" + a.endTime + '\n';
            counter++;
        }
        return oString;
    }
    /**
     * resets schedule
     */
    public void clearSchedule(){
        this.classSchedule = new ArrayList<uahClass>();
    }
    public void removeClass(Integer index){
        this.classSchedule.remove(index);
    }
}
