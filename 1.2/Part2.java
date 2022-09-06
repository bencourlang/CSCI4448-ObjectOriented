import java.util.Scanner;

public class Part2 {
    public static void main(String[] args){    //That main
        Processor p = new Processor();
        String bippity = p.Read();
        String boppity = p.Clean(bippity);
        char[] boo  = p.Sort(boppity);
        String ILoveRenamingThingsForAssingments = p.palindrome(boo);
        System.out.println(ILoveRenamingThingsForAssingments);
    }
}

class Processor{   //the lovely class of a word I can very much pronounce easily
    public static String Read(){
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
    public static String Clean(String thing){
        String upperThing = thing.toUpperCase();
        return upperThing.replaceAll("\\s", "");
    }
    public static char[] Sort(String upperNoSpaceThing){
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
        return arr;
    }
    public static String palindrome(char[] arr){
        String heeyup = "";

        for(int i = arr.length-1; i > 0; i--){
            heeyup += arr[i];
        }
        for(int i = 0; i < arr.length; i++){
            heeyup += arr[i];
        }
        return heeyup;
    }
}