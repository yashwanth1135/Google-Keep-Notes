/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gnotes;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Label{
    Scanner in = new Scanner(System.in);
    public String labelName;
    public String labelColor;
    public ArrayList<Notes> notesList = new ArrayList<>();
    public void sortNotes()
    {

    }
    public void AccessLabels(String username)
    {
        System.out.println("Labels:");
        int f=0;
        for(Label t: User.users.get(username).labelsList)
        {
            System.out.println(t.labelName);
            f=1;
        }
        if(f==0)
        {
            System.out.println("it's empty here");
            return;
        }
        else{

            while(true){
                System.out.println("enter label name");
                String tempLabelName = in.next();
                Label tlabelObj = null;
                int flag1=0;
                for(Label t: User.users.get(username).labelsList)
                {
                    if(t.labelName.equals(tempLabelName))
                    {
                        tlabelObj=t;
                        flag1=1;
                    }
                }
                if(flag1==0){
                    System.out.println("Invalid Label Name");
                    continue;
                }
                
                System.out.println("1.Use Label\n2.Insert Note to Label\n3.Set label color\n4.back");
                int op1 = in.nextInt();
                if(op1==1)
                {
                    while(true)
                    {System.out.println("Do u want to add notes(y/n)");
                        char c = in.next().charAt(0);
                        if(c=='y'||c=='Y')
                        {
                            User us = User.users.get(username);
                            System.out.println("-Enter note name:-");
                            String newNoteName = in.next();
                            Notes newNote = new Notes();
                            tlabelObj.notesList.add(newNote);
                            newNote.noteName=newNoteName;
                            System.out.println("New note Created!");
                        }
                        else
                            break;
                    }

                    if(tlabelObj.notesList.size()==0)
                    {
                        System.out.println("Label Empty!");
                        return;
                    }
                    else {

                        for(Notes t: tlabelObj.notesList)
                        {
                            System.out.println(t.noteName);
                        }
                        while(true)
                        {int f1=0;
                            System.out.println("Do u want to use notes(y/n)");
                            char ch1 = in.next().charAt(0);
                            if(ch1=='y'||ch1=='Y')
                            {
                            System.out.println("Enter note name:");
                            String tnoteName = in.next();
                            for(Notes t1: tlabelObj.notesList)
                            {
                                if(tnoteName.equals(t1.noteName))
                                {
                                    t1.PerformNoteOperation(t1,username);
                                    f1=1;
                                }
                            }
                            if(f1==0)
                            {System.out.println("Note not present!");
                                return;
                            }
                            }
                            else
                                return;
                        }
                    }
                }

                else if(op1==2)
                {
                    while(true)
                    {System.out.println("Do u want to insert label(y/n)");
                    char c = in.next().charAt(0);
                    if(c=='y'||c=='Y')
                    {
                    int f1=0;
                        System.out.println("Enter Label name to insert:");
                        String tlabelName = in.next();
                        for(Label t2: User.users.get(username).labelsList)
                        {
                            if(t2.labelName.equals(tlabelName))
                            {
                                f1=1;
                            }
                        }
                        if(f1==1){
                            int f3=0;
                            for(Label l: User.users.get(username).labelsList){
                                if(l.labelName.equals(tlabelName))
                                {
                                    System.out.println("Enter note Name to insert");
                                    String tempNoteName = in.next();
                                    Notes tnoteIns = User.users.get(username).newNote(tempNoteName);
                                    l.notesList.add(tnoteIns);
                                    // userobj.labelsList.get(l).add(tnoteIns);
                                    System.out.println("Note Added Successfully");
                                    f3=1;
                                }
                            }
                            if(f3==0)
                            {
                                System.out.println("Invalid label name:");
                            }
                        }
                        else{
                            System.out.println("Invalid labelName");
                            return;
                        }
                    }
                    else return;
                }
                }
                else if(op1==3)
                {  System.out.println("Enter label color:");
                   String color = in.next();
                   tlabelObj.labelColor= color;
                   System.out.println("Label color set successfully!");
                }
                else{
                    return;
                }
            }
        }
    }
    public void CreateLabels(String username)
    {  int flag1=0;
        System.out.println("Enter label name");
        String tLabelName = in.next();
        for(Label t: User.users.get(username).labelsList)
        {
            if(t.labelName.equals(tLabelName))
            {
                System.out.println("labelName already exist");
                flag1=1;
            }
        }
//        Label tLabel;
//        for(Label t1: userobj.labeslList().keySet())
//        {
//            if()
//        }
        if(flag1==0)
        {   Label tlabelobj = User.users.get(username).newlabel(tLabelName);
            User.users.get(username).labelsList.add(tlabelobj);
            System.out.println("Label created Successfully!!!");
        }
    }
}