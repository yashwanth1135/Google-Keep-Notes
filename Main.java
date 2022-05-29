/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gnotes;

/**
 *
 * @author LENOVO
 */
import java.util.Scanner;
public class Main
{

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        //UserStorage userStObj = new UserStorage();
        UI ui = new UI();
        while(true){
            System.out.println("1.Login\n2.Create acc:\n3.Back");
            int ch = inp.nextInt();
            if(ch==1)
            {ui.login();
            }
            else if(ch==2)
            {
                ui.newAcc();
            }
            else{
                return;
            }
        }
    }
}