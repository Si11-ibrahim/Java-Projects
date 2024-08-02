import java.util.*;

public class election {

    Scanner sc = new Scanner(System.in);

    String userName;
    int birthYear;
    int age;
    boolean isEligible = false;

    int howManyVotes = 13;

    int apple = 0;
    int orange = 0;
    int banana = 0;

    public void getInput() {
        System.out.print("\nEnter your name: ");
        userName = sc.next();

        System.out.print("\n\nEnter your birth year: ");
        birthYear = sc.nextInt();

        age = 2024 - birthYear;

    }

    public void ageValidation(int age) {
        if (age <= 10) {
            System.out.println("\nGo home kid!!");
            System.exit(0);

        } else if (age >= 11 && age <= 17) {
            System.out.println("\nYou are not eligible for vote yet");
            System.out.println("\nCome back after " + (18 - age));
            System.exit(0);

        } else if (age >= 18 && age <= 99) {
            isEligible = true;
            System.out.println("\nCongrats " + userName + " You are eligible for vote now :) \n");

        } else if (age >= 100 && age <= 199) {
            isEligible = true;
            System.out.println("You still alive bruh?? \n Anyway ");

        } else if (age >= 200) {
            System.out.println("Really bruh?? \n Anyway ");
            isEligible = true;

        } else {
            System.out.println("Type Carefully!! Try again!!");
        }
    }

    public void votingDay(boolean isEligible) {

        for (var i = 0; i <= howManyVotes; i++) {

            getInput();
            ageValidation(age);
            System.out.println(
                    "You need to select one of these parties, \n 1 - Party of Apple \n 2 - Party of Orange \n 3 - Party of Banana");

            int vote = 0;
            int j = i + 1;
            System.out.print(j == 1 ? "\nVote here carefully: "
                    : j == 2 ? j + "nd Vote: " : j == 3 ? j + "rd Vote: " : j + "th Vote: ");
            vote = sc.nextInt();
            if (vote == 1) {
                apple += 1;
            } else if (vote == 2) {
                orange += 1;
            } else if (vote == 3) {
                banana += 1;
            } else {
                System.out.println("Invalid Input!!");
                i -= 1;
                continue;
            }
        }
    }

    public void resultDay() {
        if (apple > orange && apple > banana) {
            System.out.println("\nThe winner is Party of Apple!! ");
        } else if (orange > apple && orange > banana) {
            System.out.println("\nThe winner is Party of Orange!! ");
        } else if (banana > apple && banana > orange) {
            System.out.println("\nThe winner is Party of Banana!! ");
        } else {
            if (apple == orange) {
                System.out.println(
                        "\nParty of Apple and Party of Orange is equal, So no one won. Re-Election will be conducted soon.");
            } else if (apple == banana) {
                System.out.println(
                        "\nParty of Apple and Party of banana is equal, So no one won. Re-Election will be conducted soon.");
            } else if (orange == banana) {
                System.out.println(
                        "\nParty of Orange and Party of Banana is equal, So no one won. Re-Election will be conducted soon.");
            }
        }
    }

    public static void main(String arg[]) {
        election obj = new election();

        System.out.println(
                "Note: Adjust the howManyVotes variable to adjust the allowed voting members count. Result will be displayed after the voting counts ended.");

        obj.votingDay(obj.isEligible);
        obj.resultDay();

    }
}