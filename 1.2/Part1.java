import java.util.Scanner;
import java.util.ArrayList; 
import java.util.*;

public class Part1{
    public static void main(String[] args) throws Exception{
        Reader r = new Reader();    // instantiate the objects
        Analyzer a = new Analyzer();
        ArrayList<Double> data = r.getData();   // read data from the user
        a.analyze(data);    // perform all calculations
    }
}

class Reader{   //Reader Class
    public static boolean isNum(String strNum){    //Checks if the input is a number
        if(strNum == null){
            return false;
        }
        try{
            double d = Double.parseDouble(strNum);
        }
        catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }

    public static ArrayList<Double> getData(){  //Getting the data
        Scanner s = new Scanner(System.in);
        ArrayList<Double> data = new ArrayList<Double>();

        String nl = s.nextLine();

        while(nl != null || nl == "-1"){
            if(nl.isEmpty()){   //Check for enter
                break;
            }
            else if(!isNum(nl)){    //Check for not number
                System.out.println("Number not entered");
                nl = s.nextLine();
            }
            else if(s.hasNextLine()){   //is number
                data.add(Double.valueOf(nl));
                nl = s.nextLine();
            }
            else{
                nl = null;
            }
        }
        return data;
    }
}

class Analyzer{ //The analyzer class
    double median;  //those good good things that I need for this project
    double mean;
    ArrayList<Double> mode;
    double variance;
    double sd;
    double minV;
    double maxV;
    double count;

    public static void analyze(ArrayList<Double> nums){ //Printing all the data from the calculations
        System.out.println("Median: " + getMedian(nums));
        System.out.println("Mean: " + getMean(nums));
        System.out.println("Mode: " + getMode(nums));
        System.out.println("Variance: " + getVariance(nums));
        System.out.println("Standard Deviation: " + getSD(nums));
        System.out.println("Minimum Value: " + getMinVal(nums));
        System.out.println("Maximum Value: " + getMaxVal(nums));
        System.out.println("Maximum Occurences: Value " + getMode(nums) + " , count " + getMaxOcc(nums, getMode(nums)));
    }

    public static double getMedian(ArrayList<Double> nums){ //Gets median
        Collections.sort(nums);
        double median;
        if (nums.size()%2 == 0){
            median = (nums.get(nums.size()/2) + nums.get((nums.size() - 1)/2))/2;
        }
        else{
            median = (nums.get(nums.size()/2));
        }
        return median;
    }

    public static double getMean(ArrayList<Double> nums){   //Gets mean
        double sum = 0;
        for (int i = 0; i < nums.size(); i++){
            sum += nums.get(i);
        }
        return (sum/nums.size());
    }

    public static ArrayList<Double> getMode(ArrayList<Double> nums){    //Gets mode (I checked for multiple modes since I'm cool like that)
        ArrayList<Double> mode = new ArrayList<Double>();
        double maxCount = 0;

        for(int i = 0; i < nums.size(); ++i){
            int count = 0;
            for(int j = 0; j < nums.size(); ++j){
                if(Double.compare(nums.get(i), nums.get(j)) == 0){
                    count++;
                }
            }
   
            if(count > maxCount){
               maxCount = count;
               mode.clear();
               mode.add(nums.get(i));
            }
            else if(count == maxCount){
                boolean dif = true;
                for(int j = 0; j < mode.size(); j++){
                    if(Double.compare(mode.get(j), nums.get(i)) == 0){
                        dif = false;
                    }
                }
                if(dif){
                    mode.add(nums.get(i));
                }
            }
        }
        return mode;
    }  

    public static double getVariance(ArrayList<Double> nums){   //Gets Variance
        double mean = getMean(nums);
        double temp = 0;
        for(int i = 0; i < nums.size(); i++){
            temp += (nums.get(i) - mean) * (nums.get(i) - mean);
        }
        return (temp/(nums.size()-1));
    }

    public static double getSqrt(double num){   //Since we cannot use Math gest the sqrt
        double temp;
        double hold = num/2;
        do{
            temp = hold;
            hold = (temp + (num/temp))/2;
        }
        while((temp - hold) != 0);

        return hold;
    }

    public static double getSD(ArrayList<Double> nums){ //gets the standard deviation (Population too lazy to check whether to use population or sample)
        double mean = getMean(nums);
        double temp = 0;
        for(int i = 0; i < nums.size(); i++){
            temp += (nums.get(i) - mean) * (nums.get(i) - mean);
        }
        return getSqrt((temp/(nums.size())));
    }

    public static double getMinVal(ArrayList<Double> nums){ //Gets the minimum value
        return nums.get(0);
    }

    public static double getMaxVal(ArrayList<Double> nums){ //Gets the maximum value
        return nums.get(nums.size()-1);
    }

    public static double getMaxOcc(ArrayList<Double> nums, ArrayList<Double> modes){    //very repetative tbh but gets mode and ammount of times mode occures
        double mode = modes.get(0);
        double count = 0;
        for(int i = 0; i < nums.size(); i++){
            if(nums.get(i) == mode){
                count++;
            }
        }
        return count;
    }
}