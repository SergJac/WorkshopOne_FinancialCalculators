package com.ps;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Which calculator would you like to use? (1 = Mortgage Calculator, 2 = CD Future Value Calculator, 3 = Ordinary Annuity Present Value Calculator)? ");
        String command = scanner.nextLine();

        if (command.equals("1")) {
            firstCalc(scanner);                                                         // Mortgage Calculator
        }
        if (command.equals("2")) {
            secCalc(scanner);                                                           // CD Future Value Calculator
        }
        if (command.equals("3")) {
            thirdCalc(scanner);                                                         // Ordinary Annuity Present Value Calculator
        }
    }

    public static void firstCalc(Scanner scanner) {

        double MP;                                                                      // Expected Monthly Payments
        double TIP;                                                                     // Total Interest Paid

        System.out.print("Enter principal amount of loan: ");
        double P = scanner.nextDouble();                                                // Principal Amount

        System.out.print("Enter interest rate: ");
        double IR = scanner.nextDouble() / 100 / 12;                                    // Interest Rate

        System.out.print("Enter total loan length: ");
        double N = scanner.nextDouble() * 12;                                           // Loan Length

        MP = P * (IR * (Math.pow(1 + IR, N))) / (Math.pow(1 + IR, N) - 1);              // MP = P [ ir((1 + IR)^N) ] / [ ((1 + IR)^N) – 1]
        System.out.println("Expected Monthly Payments: " + String.format("%.2f",MP));

        TIP = ((MP * 12) * 15) - P;                                                     // TIP = ((MP * 12) * 15) - P
        System.out.println("Total Interest Paid: " + String.format("%.2f",TIP));

    }

    public static void secCalc(Scanner scanner) {

        double FV;                                                                      // Future Value of CD
        double TIE;                                                                     // Total Interest Earned

        System.out.print("Enter principal amount deposited in CD: ");
        double pri = scanner.nextDouble();                                              // Principal Amount

        System.out.print("Enter Interest rate: ");
        double inr = scanner.nextDouble() / 100;                                        // Interest Rate

        System.out.print("Enter the number of years until maturity date: ");
        double num = scanner.nextDouble();                                              // Years Until Maturity

        FV = pri * (Math.pow(1 + inr / 365, num * 365));                                // FV = (1 + inr / 365)^(num *365)
        System.out.println("Future Value: " + String.format("%.2f",FV));

        TIE = FV - pri;                                                                 // TIE = FV - pri
        System.out.println("Total Interest Earned: " + String.format("%.2f",TIE));

    }


    public static void thirdCalc(Scanner scanner) {

        double PV;                                                                      // Present Value of Ordinary Annuity

        System.out.print("Enter monthly payment amount of annuity: ");
        double mp = scanner.nextDouble();                                               // Monthly Payment

        System.out.print("Enter Interest rate: ");
        double inrt = scanner.nextDouble() / 100 / 12;                                  // Interest Rate

        System.out.print("Enter the total number of years annuity will pay out: ");
        double num = scanner.nextDouble() * 12;                                         // Years to Pay Out User

        PV = mp * ((1 - Math.pow(1 + inrt, -1 * num)) / inrt);                          // PV = mp ((1 - (1 + inrt)^num) / inrt)
        System.out.println("Present Value: " + String.format("%.2f",PV));

    }
}