/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Student
 */
import Login.Login;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login userAccount = new Login();

        System.out.println("--- REGISTRATION ---");
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        String username, password, phone;

        while (true) {
            System.out.print("Enter username (must contain '_' and be <= 5 chars): ");
            username = scanner.nextLine();
            if (userAccount.checkUserName(username)) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }

        while (true) {
            System.out.print("Enter password (>= 8 chars, 1 capital, 1 number, 1 special char): ");
            password = scanner.nextLine();
            if (userAccount.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        while (true) {
            System.out.print("Enter cell phone number (with international code, max 10 chars): ");
            phone = scanner.nextLine();
            if (userAccount.checkCellPhoneNumber(phone)) {
                System.out.println("Cell phone number successfully added.");
                break;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
        }

        String regMessage = userAccount.registerUser(username, password, phone, firstName, lastName);
        System.out.println("\n" + regMessage);

        System.out.println("\n--- LOGIN ---");
        System.out.print("Enter username to login: ");
        String loginUser = scanner.nextLine();

        System.out.print("Enter password to login: ");
        String loginPass = scanner.nextLine();

        boolean isLoggedIn = userAccount.loginUser(loginUser, loginPass);
        System.out.println(userAccount.returnLoginStatus(isLoggedIn));

        scanner.close();
    }
}
