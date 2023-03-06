/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guerra;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Guerra {

    public static void MENU() {
        System.out.println("1).");
        System.out.println("2).");
        System.out.println("3).");
        System.out.println("4).");
        System.out.println("5).");
        System.out.println("6).");
        System.out.println("7).");
    }

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        int caso;
        do {
            MENU();
            caso = sn.nextInt();
            switch (caso) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
            }
        } while (caso != 5);
        System.out.println("Fin");

    }

}


