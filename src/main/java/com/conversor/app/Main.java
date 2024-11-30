package com.conversor.app;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 6) {
            
            System.out.println("eliga una opcion: ");
            option = scanner.nextInt();
            try {
                String response= Request.request("USD", "MXN", 1);
                System.out.println(response);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}