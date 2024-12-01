package com.conversor.app;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void menu() {

        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 2) {

            System.out.println(
                    """
 ####   ####  #    # #    # ###### #####   ####   ####  #####     #####  ######    #    #  ####  #    # ###### #####    ##    ####  
#    # #    # ##   # #    # #      #    # #      #    # #    #    #    # #         ##  ## #    # ##   # #      #    #  #  #  #      
#      #    # # #  # #    # #####  #    #  ####  #    # #    #    #    # #####     # ## # #    # # #  # #####  #    # #    #  ####  
#      #    # #  # # #    # #      #####       # #    # #####     #    # #         #    # #    # #  # # #      #    # ######      # 
#    # #    # #   ##  #  #  #      #   #  #    # #    # #   #     #    # #         #    # #    # #   ## #      #    # #    # #    # 
 ####   ####  #    #   ##   ###### #    #  ####   ####  #    #    #####  ######    #    #  ####  #    # ###### #####  #    #  ####  
                            """);
            System.out.println("1) convertir una moneda");
            System.out.println("2) salir");
            System.out.println("\nEliga una opcion:");
            option = scanner.nextInt();
            if (option==1) {
                System.out.println("opcion uno ejcutandose");
            }else if (option==2) {
                break;
            }   
        }
        scanner.close();
    }

    void opcion1(String value1, String value2, int amount){
        try {
            float response = Request.request(value1, value2, amount);
            System.out.println("el valor es:" + response);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
