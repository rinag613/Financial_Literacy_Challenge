import java.util.Scanner;

public class Budget {

    private double satisfactionLevel;
    private int numPurchases;
    private double weeklyIncome;
    private String name;
    private double balance;
    private double satisfaction;
    private double possibleBalance;

    private String[] a = {"To have pizza for dinner", "To take an Uber home", "To buy fancy paper towels", "To go to the gym", "To get water delivered", "To eat chicken soup", "To go the amusement park", "To give a charitable donation?", "To buy a new fancy dress", "To buy a Gucci bag", "To buy a new washing machine", "To buy an organic salad for lunch", "To hire an accountant"};
    private String[] b = {"To have steak for dinner", "To take the bus home", "To buy cheap paper towels", "To work out at home", "To schlep it from the store", "To go to the doctor", "To go to the beach", "To keep it for yourself?", "To buy a t-shirt", "To use a paper one from the store", "To call the handyman to fix your broken one", "To make lunch at home", "To do your taxes at home and risk mistakes"};
    private int[] c = {3, 50, 5, 10, 20, 3, 50, 100, 115, 400, 600, 20, 200};
    private int[] d = {30, 8, 2, 0, 10, 30, 0, 0, 25, 1, 200, 5, 1000000};

    public Budget(String theName, double theWeeklyIncome) {
        name = theName;
        weeklyIncome = theWeeklyIncome;
        balance = 0;

    }

    public void spend(double amount) {
        balance = balance - amount;
    }

    public double getBalance() {
        return balance;
    }

    public void addIncome() {
        balance = balance + weeklyIncome;
    }

    public double getBalance(double spent) {
        return weeklyIncome - spent;
    }

    public double estimatedSpending(double spentToday) {
        return spentToday * 7;
    }

    public int get256(int challengeWeeks) {
        int num = 0;
        for (int i = 0; i < challengeWeeks; i++) {
            if (c[i] < d[i]) {
                num += c[i];
            } else {
                num += d[i];
            }
        }

        return num;
    }


    public void askQuestions(int i) {

        Purchase food1 = new Purchase(a[i], c[i]);
        Purchase food2 = new Purchase(b[i], d[i]);
        Scanner input3 = new Scanner(System.in);
        System.out.print("Do you choose:\n A: " + food1 + " \n B: " + food2 + "?\n>>");
        String answer = input3.nextLine();
        numPurchases++;

        if (answer.equals("A") || answer.equals("a")) {
            balance = balance - food1.getPrice();
            satisfaction += food1.getSatisfaction();
            satisfactionLevel = satisfaction / numPurchases;
        } else {
            balance = balance - food2.getPrice();
            satisfaction += food2.getSatisfaction();
            satisfactionLevel = satisfaction / numPurchases;
        }


    }

    public void printLevels() {
        System.out.println("Your balance is currently $" + balance + ". Your satisfaction average is " + satisfactionLevel + "/10 satisfaction stars");
    }

    public double getSatisfactionLevel() {
        return satisfactionLevel;
    }


}