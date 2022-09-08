import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Don't Go Broke! You make many financial decisions every week.\nLet's focus on one choice a week and see how well you save...Let's go! ");

        Scanner input2 = new Scanner(System.in);
        System.out.print("Hi! What is your name?\n>>");
        String name = input2.nextLine();

        Scanner input = new Scanner(System.in);
        System.out.print("Welcome " + name + ". What is your weekly income?\n>>");
        double weeklyIncome = input.nextDouble();

        Budget user = new Budget(name, weeklyIncome);

        //user spent some money today
        System.out.print("What is the average amount of money you spend per day?\n>>");
        double spent = input.nextDouble();

        System.out.println("You probably spend about $" + user.estimatedSpending(spent) + " a week.");
        if (user.estimatedSpending(spent) > weeklyIncome) {
            System.out.println("Sorry, that's too much. You're in debt.");
        }
        System.out.print("How many weeks of the challenge are you up for?\n>>");
        int challengeWeeks = input.nextInt();
        int amountPossible = user.get256(challengeWeeks);
        double highestPossibleBalance = (weeklyIncome * (challengeWeeks)) - (spent * 7 * (challengeWeeks)) - amountPossible;

        System.out.println("If you save right, you could save $" + highestPossibleBalance + " in that amount of time!");
        System.out.println("Let's get started... \nYou will be asked some financial decision questions. Everything has a price and a satisfaction rating.\n Make sure you balance your budget with your satisfaction level for each activity.");
        for (int i = 0; i < challengeWeeks; i++) {
            System.out.println("Week " + (i + 1) + ": ");
            user.askQuestions(i);
            user.addIncome();
            user.spend(spent * 7);
            user.printLevels();
        }
        double yourBalance = user.getBalance();
        double moneyScore = (yourBalance / highestPossibleBalance) * 100;

        System.out.println("The most money you could have had in your account right now is: $" + highestPossibleBalance);
        System.out.println("You retained " + moneyScore + "% of that amount");
        System.out.println("You've completed your challenge! Here is your report:");
        if (user.getSatisfactionLevel() > 5)
        {
            System.out.println("Great job! You made financial choices that kept you happy:)");
        } else
        {
            System.out.println("You may have saved money but you did not make financial choices that made you happy and satisfied. Better luck next time!");
        }
        System.out.println("\n\n\n\n\n");
    }
}
