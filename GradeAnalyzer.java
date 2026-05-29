/**
Name: Ann C.
Class: CSCI-255
Program name: GradeAnalyzer.java
About: A program that analyzes student scores for a university registrar
*/
import java.util.Scanner;
public class GradeAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        
        // Loop continues until user types "end"
        while (true) {
            int[] scores = {88, 72, 95, 61, 83, 74, 91, 55, 78, 89,
                            66, 94, 70, 82, 77, 58, 87, 93, 69, 75};
            
            // Calculate the average first 
            double average = computeAverage(scores);
            
            // Display the class average
            System.out.println("CLASS AVERAGE");
            System.out.println("Average score: " + average);
            System.out.println();
            
            // Display highest and lowest scores
            System.out.println("HIGHEST AND LOWEST");
            System.out.println("Highest score: " + findHighest(scores));
            System.out.println("Lowest score: " + findLowest(scores));
            System.out.println();
            
            // Display full grade report
            System.out.println("FULL GRADE REPORT");
            printGradeReport(scores);
            System.out.println();
            
            // Display grade distribution
            System.out.println("GRADE DISTRIBUTION");
            int[] distribution = countGrades(scores);
            System.out.println("A (90-100): " + distribution[0]);
            System.out.println("B (80-89):  " + distribution[1]);
            System.out.println("C (70-79):  " + distribution[2]);
            System.out.println("D (60-69):  " + distribution[3]);
            System.out.println("F (below 60): " + distribution[4]);
            System.out.println();
            
            // Display all scores above the average
            System.out.println("SCORES ABOVE AVERAGE");
            printAboveAverage(scores, average);
            
            // Ask user if they want to continue
            System.out.println();
            System.out.println("Type 'end' to stop or press Enter to run again:");
            userInput = scanner.nextLine();
            
            // Check if user typed "end"
            if (userInput.equalsIgnoreCase("end")) {
                System.out.println("Bye!~");
                break;
            }
        }
        
        scanner.close();
    }
    
    //Method 1
    static double computeAverage(int[] scores) {
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum = sum + scores[i];
        }
        
        double average = (double) sum / scores.length;
        double roundedAverage = Math.round(average * 100) / 100.0;
        
        return roundedAverage;
    }
    
    //Method 2
    static int findHighest(int[] scores) {
        int highest = scores[0];
        
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > highest) {
                highest = scores[i];
            }
        }
        
        return highest;
    }
    
    //Method 3
    static int findLowest(int[] scores) {
        int lowest = scores[0];
        
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < lowest) {
                lowest = scores[i];
            }
        }
        
        return lowest;
    }
    
    //Method 4
    static char assignGrade(int score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    
    //Method 5
    static void printGradeReport(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            char grade = assignGrade(score);
            System.out.println("Score: " + score + " -> Grade: " + grade);
        }
    }
    
    //Method 6
    static int[] countGrades(int[] scores) {
        int[] gradeCounts = new int[5];
        
        for (int i = 0; i < scores.length; i++) {
            char grade = assignGrade(scores[i]);
            
            if (grade == 'A') {
                gradeCounts[0]++;
            } else if (grade == 'B') {
                gradeCounts[1]++;
            } else if (grade == 'C') {
                gradeCounts[2]++;
            } else if (grade == 'D') {
                gradeCounts[3]++;
            } else if (grade == 'F') {
                gradeCounts[4]++;
            }
        }
        
        return gradeCounts;
    }
    
    //Method 7
    static boolean isAboveAverage(int score, double average) {
        return score > average;
    }
    
    //Method 8
    static void printAboveAverage(int[] scores, double average) {
        for (int i = 0; i < scores.length; i++) {
            if (isAboveAverage(scores[i], average)) {
                System.out.println("Score " + scores[i] + " is above the average of " + average);
            }
        }
    }
}
