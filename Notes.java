/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gnotes;

/**
 *
 * @author LENOVO
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
public class Notes{
    String noteName;
    String noteColor="No Color";
    // Label labelObj;
    // LocalDate TimeCreated;
    public LocalDateTime TimeModified;
    ArrayList<String> text = new ArrayList<>();
    ArrayList<String> Image = new ArrayList<>();
   public  ArrayList<String> AccessList = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    public void insertImage()
    {
        System.out.println("Enter image name:");
        Image.add(in.next());
        TimeModified = LocalDateTime.now();
    }
    public void insertText()
    {
        System.out.println("Enter Text:");
        text.add(in.next());
        TimeModified = LocalDateTime.now();
    }
    public void removeText()
    {
        System.out.println("Enter Text to be replaced");
        String oldString = in.nextLine();
        System.out.println("Enter New Text");
        String newString = in.nextLine();
        for(String i: text)
        {
            if(i.contains(oldString))
                i.replace(oldString,newString);
        }
        TimeModified = LocalDateTime.now();
    }
    public void removeImage()
    { String inputString = in.nextLine();
        for(String i: Image)
        {
            if(i==inputString)
            {
                //logic
            }
        }
    }
    public void displayNote(Notes NotesIns)
    {  int flag = 0;
        System.out.println("Note color:"+noteColor);
        System.out.println("Text:");
        for(String i: text)
        {System.out.println(i);
            flag = 1;
        }
        System.out.println("Images:");
        for(String i: Image)
        {System.out.println(i);
            flag = 1;
        }
        System.out.println("Shared Users:");
        for(String i:NotesIns.AccessList)
        {
            System.out.println(i);
        }
        if(flag == 0)
            System.out.println("Note is empty!!!");
    }
    public void AccessNotes(String username)
    {
        //boolean bool = User.users.get(username).displayNotes();
        //boolean bool=false;

        int flag2=0,c=1;
        for(Notes t1: User.users.get(username).notes)
        {       
            if(c==1){System.out.println("Notes:");
            c=2;}
            System.out.println(t1.noteName);
            flag2=1;
        }

        if(flag2==0)
        {
            System.out.println("Its empty here!");
            return;
        }
        if(flag2==1){

             System.out.println("Enter note name:");
                String tempNote = in.next();
                // System.out.println("Enter note name:");

                Notes NoteIns = User.users.get(username).returnNoteInstance(tempNote,username,username);

                if(NoteIns==null)
                {System.out.println("Note is not present");

                }
                else{
                    PerformNoteOperation(NoteIns,username);

                }
        }
//        else{
//            System.out.println("It's empty here!");
//            return;
//        }
    }
    public void PerformNoteOperation(Notes NoteIns, String username)
    {

        while(true){
            if(NoteIns!=null)
            {NoteIns.displayNote(NoteIns);
            System.out.println("1.Add text\n2.Add Image\n3.Remove text\n4.Remove Image\n5.share note\n6.Set note color\n7.delete note\n8.Sort notes\n9.Back");
            int select = in.nextInt();
            if(select==1)
            {
                NoteIns.insertText();
            }
            else if(select==2)
            {
                NoteIns.insertImage();
            }
            else if(select==3)
            {
                NoteIns.removeText();
            }
            else if(select==4)
            {
                NoteIns.removeImage();
            }
            else if(select==5)
            {   System.out.println("Enter recepient user Name");
                String recepname = in.next();
                User.users.get(username).sendNote(NoteIns.noteName,recepname,username);
            }
            else if(select==6)
            {   System.out.println("Enter color:");
                String color = in.next();
                NoteIns.noteColor=color;
                System.out.println("Color set successfully!");
            }
            else if(select==7)
            {  int c=0;
                for(Notes t: User.users.get(username).notes)
                {   
                    if(t.noteName.equals(NoteIns.noteName))
                    {
                        User.users.get(username).notes.remove(c);
                        NoteIns=null;
                        System.out.println("Note deleted!");
                        return;
                    }
                    c++;
                }
                
            }
            else if(select == 8)
            {
                System.out.println("Sort based on:\n1.Names\n2.TimeModified");
                int inp = in.nextInt();
                if(inp==1)
                {
                    User.users.get(username).displayBasedOnName();
                }
                else if(inp==2)
                {
                    User.users.get(username).displayNotesBasedOnTime();
                }
            }
            else {
               break;
                //return;
            }
            }
        }
    }
    public void createNote(String username){
        User us = User.users.get(username);
        System.out.println("-Enter note name:-");
        String newNoteName = in.next();
        us.newNote(newNoteName);
        System.out.println("New note Created!");
    }
}
