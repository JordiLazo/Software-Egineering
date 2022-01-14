package Question_4_State_Pattern_and_Junit.junit;

public class Calculation {

    public static int findMax(int arr[]){
        int max=0;
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    //method that returns cube of the given number
    public static int cube(int n){
        return n*n*n;
    }
    //method that returns reverse words
    public static String reverseWord(String str){
        String finalString="";
        char ch;
        for (int i=0; i<str.length(); i++) {
            ch= str.charAt(i); //extracts each character
            finalString= ch+finalString; //adds each character in front of the existing string
        }
        return finalString;
    }


    public static int secsToMins(int seconds) {
        if (seconds <= 0) {
            throw new IllegalArgumentException("seconds (" + seconds + ") can not be 0 or negative");
        }
        return seconds / 60;
    }

    public static boolean returnABoolean(String inputData) {
        if ("Save".equalsIgnoreCase(inputData)) {
            return true;
        } else {
            return false;
        }
    }

    public static int subtract(int a, int b) {
        if(a < 0 || b < 0){
            throw new IllegalArgumentException("Can not be negative values ");
        }
        return a - b;
    }
}