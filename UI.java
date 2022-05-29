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
public class UI{
    Scanner in = new Scanner(System.in);
    String username;
    Notes notes = new Notes();
    Label tlabel = new Label();
    User userobj;
    public void login() {
        System.out.println("Enter username:");
        String UserName = in.next();
        in.nextLine();
        username = UserName;
        User userobj = User.users.get(username);
        if(User.users.containsKey(username))
        {
            while(true)
            {
                System.out.println("1.Notes\n2.Labels\n3.back");
                int ch= in.nextInt();
                if(ch==1)
                {
                    notesMethod();
                }
                else if(ch==2)
                {
                    labelsMethod();
                }
                else{
                    return;
                }
            }
        }
        else{
            System.out.println("Invalid user name");
        }
    }
    public void newAcc()
    {
        System.out.println("Enter username:");
        String tempusername;
        while(true)
        {
            tempusername = in.next();
            if(User.users.containsKey(tempusername))
                System.out.println("User name already exists!\nEnter new username");
            else {
                User newUser = new User(tempusername);
                System.out.println("Acc created Successfully!!!");
//                 System.out.println("Do u want to login(y/n)");
//                 char choice1 = in.next().charAt(0);
//                 if(choice1=='y'||choice1=='Y')
//                 {  UI u= new UI();
//                    u.login();
//                 }
                break;
            }
        }

//                for(String c: User.users.keySet())
//                {System.out.println("**");
//                System.out.println(c);
//                }
        //this.searchUser();
    }

    public void notesMethod()
    {
        while(true)
        {   System.out.println("1.Access notes\n2.Create notes\n3.Back");
            int choice=in.nextInt();
            if(choice==1)
            {
                notes.AccessNotes(username);
            }
            else if(choice==2)
            {
                notes.createNote(username);
            }
            else {
                return;
            }
        }
    }
    public void labelsMethod()
    {
        while(true)
        {
            System.out.println("1.Access Labels\n2.Create Labels\n3.Back");
            int choice1=in.nextInt();
            if(choice1==1)
            {
                tlabel.AccessLabels(username);
            }
            else if(choice1==2)
            {
                tlabel.CreateLabels(username);
            }
            else {
                return;
            }
        }

    }







}