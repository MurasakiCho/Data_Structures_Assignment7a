/*
Name: Briana O'Neal
Class: CS 3305/W01
Term: Fall 2022
Instructor: Sharon Perry
Assignment: 7-Part-1-Sorting
*/
import java.io.File;
import java.io.IOException;
import java.util.*;
public class Assignment7A {
    //create mergesort method
    public static void mergesort(LinkedList<Integer> list) {
        //split list in half until it can't anymore
       if(list.size() > 1){
           LinkedList<Integer> list1 = new LinkedList<>();
           LinkedList<Integer> list2 = new LinkedList<>();
           //first half
           for(int i = 0; i < list.size()/2; i++){
               list1.add(list.get(i));
           }
           mergesort(list1);
           //second half
           for(int i = list.size()/2; i < list.size(); i++){
               list2.add(list.get(i));
           }
           mergesort(list2);

           //merge the lists
           merge(list1, list2, list);
       }
    }
    //create merge method, takes in the three lists from previous method
    public static void merge(LinkedList<Integer> list1, LinkedList<Integer> list2, LinkedList<Integer> list){
        int counter = 0;
        //compare list1 and list2 and place them in correct order in list
        while(!list1.isEmpty() && !list2.isEmpty()){

            if(list1.get(0) < list2.get(0)){
                list.set(counter++, list1.get(0));
                list1.remove();
            }
            else{
                list.set(counter++, list2.get(0));
                list2.remove();
            }
        }
        //whatever is left goes at the end
        while(!list1.isEmpty()){
            list.set(counter++, list1.get(0));
            list1.remove();
        }
        while(!list2.isEmpty()){
            list.set(counter++, list2.get(0));
            list2.remove();
        }
    }

    public static void main(String[] args) {
        //create linked list
        LinkedList<Integer> list = new LinkedList<>();
        //read file's numbers and add to list
        try{
            String data;
            File myFile = new File("C:\\Users\\butte\\Downloads\\mergetest.txt");
            Scanner scan = new Scanner(myFile);
            while(scan.hasNextLine()){
                data = scan.nextLine();
                list.add(Integer.parseInt(data));
            }
        }
        catch(IOException io){
            System.out.println("Error: " + io.getMessage());
        }

        //print unsorted list
        System.out.print("Unsorted list: [");
        for(int i = 0; i < list.size()-1; i++){
            System.out.print(list.get(i) + ", ");
        }
        System.out.println(list.get(list.size()-1) + "]");

        //run sort method with list
        mergesort(list);

        System.out.println();
        System.out.print("Sorted list: [");
        for(int i = 0; i < list.size()-1; i++){
            System.out.print(list.get(i) + ", ");
        }
        System.out.println(list.get(list.size()-1) + "]");
    }
}
