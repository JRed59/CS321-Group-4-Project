//temporarily just prompts user with text, can switch to GUI later

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

        //using number result, prompt for that many class entries
        System.out.printf("Enter %d class entries formatted as followed:\tClassIdentifier,StartTime(in 24 hour format),EndTime(in 24 hour format),Building\n", result);
        System.out.printf("The commas in the formatting will separate your entries, so ensure that is the only character to separate.\n");

        User user1 = new User();    //creates the user class to be later edited
        for (int i = 0; i < result; i++){
            stringNum = userInput.nextLine();   //get next user input line
            //separate the string that was inputted by the user with ' ' as a delimiter
            //check each of the time slots to ensure they are actual integers
                //if they are not integers, decrement i and prompt the user again with a notification of the error
            
            

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
