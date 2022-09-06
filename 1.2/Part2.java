import java.util.Scanner;
import java.util.ArrayList; 
//import java.util.*;
import java.util.Arrays;

public class Part2 {
    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        p.doTheThing();
    }
}

class Palindrome{
    public static void doTheThing(){
        Scanner s = new Scanner(System.in);

        String thing = s.nextLine();
        String upperThing = thing.toUpperCase();
        String upperNoSpaceThing = upperThing.replaceAll("\\s", "");
        char arr[] = upperNoSpaceThing.toCharArray();

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i] < arr[j]){
                    char temp;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        String heeyup = "";

        for(int i = arr.length-1; i > 0; i--){
            heeyup += arr[i];
        }
        for(int i = 0; i < arr.length; i++){
            heeyup += arr[i];
        }
        System.out.println(heeyup);
    }
}