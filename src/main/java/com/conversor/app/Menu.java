package com.conversor.app;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void menu() throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int option ;
        do {

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
                scanner.nextLine();
                System.out.println("ingrese la divisa que quiere convertir ejemplo: EUR, MXN, USD");
                String pair1=scanner.nextLine().toUpperCase();
                System.out.println("ingrese la divisa que quiere como resultado ejemplo EUR, MXN, USD");
                String pair2=scanner.nextLine().toUpperCase();
                int amount = 0;
                try {
                    System.out.println("ingrese la cantidad que quiere como resultado en numero entero:");
                     amount = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("digite un numero entero correcto");
                }
                
                if (pair1.length()==3&&pair2.length()==3 && amount >= 0) {
                    
                    float result = opcion1(pair1,pair2,amount);

                    if (result != 0f) {
                        System.out.println(String.format("\n\n\nel resultado es: %f %s", result, pair2));
                        
                    }else{
                        System.out.println("digite divisas validas");
                        
                    }
                    


                    
                }else{
                    System.out.println("digite divisas validas, y numeros enteros");
                }
               
                scanner.nextLine();
                System.out.println("continuar? (presione enter)");
                scanner.nextLine();
            
            }else if (option==2) {
                break;
            }   
        }while (option != 2);
        scanner.close();
    }

    static float opcion1(String value1, String value2, int amount) throws IOException, InterruptedException{
            float response = Request.request(value1, value2, amount);
            return response;
      

    }
}
