import java.time.LocalTime;

//Class to create each of the user's classes
public class uahClass implements java.io.Serializable{
    public String name;
    public String location;
    public LocalTime startTime;
    public LocalTime endTime;
    public String day;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation(){
        return location;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public uahClass(String name, String location, LocalTime startTime, LocalTime endTime, String day) {
        this.name = name;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }
}