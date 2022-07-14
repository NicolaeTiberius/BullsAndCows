package randomArrayGenerator.java;
import java.util.Arrays;
import java.util.Scanner;

public class randomArrayGenerator {

    public static void main(String[] args) {

        randomArrayGenerator arrayClass = new randomArrayGenerator();
        arrayClass.playGame();
    }

    public void playGame(){
        randomArrayGenerator arrayClass = new randomArrayGenerator();
        int[] array1 = arrayClass.generateArray();
//        System.out.println(Arrays.toString(array1));
        System.out.println("Bulls and Cows Game:");
        System.out.println("--------------------------Rules-------------------------------");
        System.out.println("\t1.Guess a 4-digit number each turn\n\t2.The result will be displayed as follows:\n\tBull if you guessed the number in exact position\n\t" +
                "Cow if you guessed the number but in a partial position\n\n\t3.Since this is Easy Mode you have 10 rounds to guess the number 0-9." +
                "\n------------------------------------------------------------------\n");

        System.out.println("GUESS THE 4 DIGIT NUMBER:");
        Scanner userInput = new Scanner(System.in);
        int rounds = 1;
        //Starts the game
        while (rounds<11) {
            //User input
            System.out.println("Round "+rounds+": ");
            int userDigit = userInput.nextInt();
            //TAKES THE USER ARRAY AND CONVERTS IT TO STRING
            String userArrayString = Integer.toString(userDigit);
            //makes an array that has the same length of the user string.
            int[] userArray = new int[userArrayString.length()];
            //Convert the string array to an actual int array
            for (int i = 0; i <userArrayString.length() ; i++) {
                userArray[i] = userArrayString.charAt(i)-'0';
            }
            //compares the result of the user and returns it
            String[] result = arrayClass.compareDifferences(userArray,array1);
            String[] winner = {"Bull","Bull","Bull","Bull"};
            System.out.println(Arrays.toString(result));
            //IF THE USER RESULT ARRAY IS ONLY STRING THEN THEY HAVE WON.
            if(Arrays.equals(result, winner)){
                System.out.println("Congratulations you have won the game!");
                break;
            }
            rounds++;
            //If they have exceeded the playing rounds they lost;
            if (rounds>10){
                System.out.println("You did not manage to guess the number in 10 rounds. You have lost");
                break;
            }
        }
    }

    public int[] generateArray() {
        int x[] = {0, 0, 0, 0};
        boolean isDuplicate = false;
        for (int i = 0; i < x.length; i++) {
            int y = (int) (Math.random() * 9) + 1;
            for (int j = 0; j < x.length; j++) {
                if (x[j] == y) {
                    isDuplicate = true; // Flag used to denote duplicate
                    break;
                }
            }
            if (isDuplicate) {
                i--;
                isDuplicate = false;
            } else {
                x[i] = y;
            }
        }
        return x;
    }

    public String[] compareDifferences(int[]userArray, int[] actualArray) {
        String result[] = new String[actualArray.length];
        String val = "";
        if(Arrays.equals(userArray, actualArray)){
            result[0] = "Bull";
            result[1] = "Bull";
            result[2] = "Bull";
            result[3] = "Bull";
            return result;
        }
        else{
            //loop through the array of the actual array length to check with
            for (int i = 0; i < actualArray.length; i++) {
                String cow = "Cow";
                val = contains(actualArray,userArray[i]);
                //                //each integer from the user array and actual array
                if(userArray[i] == actualArray[i]){
                    result[i] =  "Bull";
                }
                else if(cow.equals(val)) {
                    result[i] = val;
                }
                else{
                    result[i] = "-";
                }
            }
        }
        return result;
    }

    public static String contains(int[] arr, int key) {
        String result = "";
        for(int i=0;i<arr.length;i++){
            if(arr[i] == key){
                result = "Cow";
            }
        }
        return result;
    }

}
