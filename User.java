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
import java.util.HashMap;
public class User{
    String userName;
    static HashMap<String,User> users = new HashMap<>();
    public ArrayList<Label> labelsList = new ArrayList<>();
    ArrayList<Notes> notes = new ArrayList<>();
    public User(String userName){
        this.userName = userName;
        users.put(userName,this);
    }

    public Notes newNote(String name)
    {
        Notes newNoteObj = new Notes();
        newNoteObj.noteName = name;
        newNoteObj.TimeModified = LocalDateTime.now();
        notes.add(newNoteObj);
        return newNoteObj;
    }

    // public void modifyNote(String notesName)
    // {   Notes note;
    //     for(Notes i:notes)
    //     {
    //         if(i.noteName==notesName)
    //         {
    //             note = i;
    //         }
    //     }
    //     note.TimeModified = T;
    // }

    public Label newlabel(String labelsName){
        Label labelObj = new Label();
        labelObj.labelName = labelsName;
        //labelsList.add(labelObj);
        return labelObj;
    }

    // public void InsertNoteToLabel(String labelName,String notesName)
    // {
    //     label.notesList.add(notes);
    //     note.labelObj=label;
    // }

    // public void DeleteNoteFromLabel(String labelName,String notesName)
    // {
    //     label.notesList.del();
    // }

//    public void changelabelcolour(String labelName, String color)
//    {   Label label;
//        for(Notes i:notes)
//        {
//            if(i.noteName==noteName)
//            {
//                note = i;
//            }
//        }
//        label.labelColor=color;
//    }

    public void changeNoteColor(String notesName, String color)
    {   Notes noteIns=null;
        for(Notes i:notes)
        {
            if(i.noteName==notesName)
            {
                noteIns = i;
            }
        }
        noteIns.noteColor = color;
    }
    public void sendNote(String notesName, String Name,String senderName) {
        User userIns = null;
        Notes noteIns = null;
        if (User.users.containsKey(Name)) {
            userIns = User.users.get(Name);
            noteIns = returnNoteInstance(notesName, Name,senderName);
        }
        if(userIns==null){
            System.out.println("Invalid username!");
            return;
        }
//        for(User i:User.users.values())
//        {
//            if(i.userName==Name)
//            {
//                userIns=i;
//                i.notes.AccessList.add(Name);
//            }
//        }
//   userIns.notes.AccessList.add(Name);
//        for(Notes c: notes)
//        {
//            if(c.noteName.equals(Name))
//            {
//                noteIns = c;
//            }
//        }

      else {
            userIns.ReceiveNote(noteIns);
            noteIns.AccessList.add(Name);
        }
    }
    public void ReceiveNote(Notes notesObj)
    {
        notes.add(notesObj);
    }
    public void displayNotesBasedOnTime()
    {   int flag = 0;
        for(int i=0;i<notes.size();i++)
        {
            for(int j=i+1;j<notes.size();j++)
            {
                if(notes.get(i).TimeModified.isAfter(notes.get(j).TimeModified))
                {
                    Notes t = notes.get(i);
                    notes.set(i,notes.get(j));
                    notes.set(j,t);
                }
            }
        }
        for(int i=0;i<notes.size();i++)
        {
            System.out.println(notes.get(i).noteName);
            flag=1;
        }
        if(flag == 0)
        {
            System.out.println("Its empty here");
            //return false;
        }
        else
        {//return true;
        }
    }
    public void displayBasedOnName()
    {
         int flag = 0;
        for(int i=0;i<notes.size();i++)
        {
            for(int j=i+1;j<notes.size();j++)
            {
                if(notes.get(i).noteName.compareTo(notes.get(j).noteName)>0)
                {
                    Notes t = notes.get(i);
                    notes.set(i,notes.get(j));
                    notes.set(j,t);
                }
            }
        }
        for(int i=0;i<notes.size();i++)
        {
            System.out.println(notes.get(i).noteName);
            flag=1;
        }
        if(flag == 0)
        {
            System.out.println("Its empty here");
           // return false;
        }
        
    }
    public Notes returnNoteInstance(String NotesName,String name,String senderName)
    {
        for(Notes temp: User.users.get(senderName).notes)
        {
            if(temp.noteName.equals(NotesName))
            {
                return temp;
            }
        }
        // System.out.println("Note not present");
        return null;
    }
}
