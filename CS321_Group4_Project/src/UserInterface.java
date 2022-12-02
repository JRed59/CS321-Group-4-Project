//temporarily just prompts user with text, can switch to GUI later
import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface {
    public static void main(String[] args) {
        //welcome and intro for user
        System.out.println("Welcome to our project! The goal of this project is to direct users to their best options for food on campus when given the time of their classes.\n");
        System.out.println("You will be requested to give the number of classes you would like to input, and then give the start and end times, and building location for each of them.\n\n");
        
        //create scanner for user input
        Scanner userInput = new scanner(system.in);
        System.out.println("How many classes would you like to enter:\t");
        String stringNum = userInput.nextLine(); //read in input
        int result = checkUserNum(stringNum);

        //if user entered incorrect number, they will be notified and re-prompted
        while (result == 0) {
            System.out.println("How many classes would you like to enter:\t");
            stringNum = userInput.nextLine(); //read in input
            result = checkUserNum(stringNum);
        }
        //initialize variables to be used to store user entry
        int startTime = 0;
        int endTime = 0;
        String building = "temp";
        String className = "temp";
        //using number result, prompt for that many class entries
        System.out.printf("Enter %d class entries formatted as followed:\tClassIdentifier,StartTime(in 24 hour format),EndTime(in 24 hour format),Building\n", result);
        System.out.printf("The commas in the formatting will separate your entries, so ensure that is the only character to separate.\n");

        User user1 = new User();    //creates the user class to be later edited
        for (int i = 0; i < result; i++){
            stringNum = userInput.nextLine();   //get next user input line
            //separate the string that was inputted by the user with ' ' as a delimiter
            String[] userInputSeparated = stringNum.split(" ", 0);
            //check each of the time slots to ensure they are actual integers
            try {
                startTime = Integer.parseInt(String[1]);
            } catch(NumberFormatException e) {
                //if they are not integers, decrement i and prompt the user again with a notification of the error
                System.out.println("Your start time is not valid, please try again.");
                i--;
                continue;
            }
            try {
                endTime = Integer.parseInt(String[2]);
            } catch(NumberFormatException e) {
                //if they are not integers, decrement i and prompt the user again with a notification of the error
                System.out.println("Your end time is not valid, please try again.");
                i--;
                continue;
            }
            if (startTime >= 0 || startTime <= 2400) {
                //check if the time is within the correct parameters
            } else {
                //if not within paramters
                System.out.println("Your start time is not within the correct parameters");
                i--;
                continue;
            }
            if (endTime >= 0 || endTime <= 2400) {
                //check if the time is within the correct parameters
            } else {
                //if not within paramters
                System.out.println("Your end time is not within the correct parameters");
                i--;
                continue;
            }

            //**should check if the building names match any ones from a list

            //add the collected info into the user
            user1.addID(userInputSeparated[0]);
            user1.addStartTime(startTime);
            user1.addEndTime(endTime);
            user1.addLocation(userInputSeparated[3]);
            
        }


        userInput.close(); //close scanner once finished
    }

    //checks the user entry for the number of classes entered
    public static int checkUserNum(String userInput) {
        int num = 0;
        try {
            num = Integer.parseInt(userInput);
        } catch(NumberFormatException e) {
            System.out.println("Input is not a valid integer value.\n");
        }
        return num;
    }
}
