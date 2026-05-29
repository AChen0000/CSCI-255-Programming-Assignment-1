```java
public class AIGradeAnalyzer {

    public static void main(String[] args) {

        int[] scores = {88, 72, 95, 61, 83, 74, 91, 55, 78, 89,
                        66, 94, 70, 82, 77, 58, 87, 93, 69, 75};

        int highest = scores[0];
        int lowest = scores[0];
        int total = 0;
        int passing = 0;
        int failing = 0;

        System.out.println("GRADE ANALYSIS REPORT\n");

        for (int i = 0; i < scores.length; i++) {

            int score = scores[i];

            total += score;

            if (score > highest) {
                highest = score;
            }

            if (score < lowest) {
                lowest = score;
            }

            if (score >= 60) {
                passing++;
            } else {
                failing++;
            }

            System.out.println("Student " + (i + 1) +
                               " Score: " + score +
                               " Grade: " + letterGrade(score));
        }

        double average = (double) total / scores.length;

        System.out.println("\n----------------------");
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
        System.out.println("Average Score: " +
                           (Math.round(average * 100.0) / 100.0));
        System.out.println("Passing Students: " + passing);
        System.out.println("Failing Students: " + failing);
    }

    public static char letterGrade(int score) {

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
}
```
