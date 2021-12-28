import java.io.*;
import java.util.*;

class LinkedList{
    node head;

    static class node{
        int data;
        node next;
        node(int d){
            data = d;
            next = null;
        }
    }
    public static LinkedList delete_first(LinkedList list){
        if(list.head == null || list.head.next == null){
            return null;
        }
        node temp = list.head.next;
        list.head = temp;
        return list;
    }
    public static LinkedList delete_last(LinkedList list){
        if(list.head == null || list.head.next == null){
            return null;
        }
        node last = list.head;
        while(last.next.next != null){
            last = last.next;
        }
        last.next = null;
        return list;
    }
    public static void delete_index(LinkedList list , int index){
        if (list.head == null){
            return;
        }

        // Store head node
        node temp = list.head;

        // If head needs to be removed
        if (index == 0) {
            list.head = temp.next; // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < index - 1;
             i++){

            temp = temp.next;
        }

        // If position is more than number of nodes
        if (temp == null || temp.next == null){

            return;
        }

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        node next = temp.next.next;

        temp.next = next; // Unlink the deleted node from list
    }
    public static LinkedList insert_last(LinkedList list , int data){
        node new_node = new node(data);

        if(list.head == null){
            list.head = new_node;
        }
        else{
            node last = list.head;
            while(last.next != null){
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }
    public static LinkedList insert_front(LinkedList list , int data){
        node new_node = new node(data);
        if(list.head == null){
            list.head = new_node;
        }
        else{
            new_node.next = list.head;
            list.head = new_node;
        }
        return list;
    }
    public static LinkedList insert_by_index(LinkedList list , int data , int index){
        node new_node = new node(data);
        if(index == -1){
            return list;
        }
        else if(index > 0 && list.head == null){
            return null;
        }
        else if(index == 0 && list.head == null){
            list.head = new_node;
            return list;
        }
        node current_node = list.head;
        int i = 0;
        while(current_node != null && i<= index -1 ){
            if(i == index -1 ){
                new_node.next = current_node.next;
                current_node.next = new_node;
            }
            current_node = current_node.next;
            i++;
        }
        return list;
    }
    public static String print_list(LinkedList list){
        String content = "";
        if(list.head == null){
            System.out.println("empty list");
        }
        else{
            node new_node = list.head;
            while(new_node != null){
                content +=new_node.data+" ";
//                System.out.println(new_node.data);
                new_node = new_node.next;
            }
        }
        return content;
    }

    public static void main(String[] args) {

//         Scanner in = new Scanner(System.in);
//         int t = in.nextInt();
//         for(int i = 0 ; i < t ; i++){
//             int n = in.nextInt();
//             LinkedList list = new LinkedList();
//             for (int j = 0; j < n ; j++){
//                 list = insert_front(list , in.nextInt());
//             }
//             System.out.println(print_list(list));
//         }

       list = insert_last(list, 1);
       list = insert_last(list, 2);
       list = insert_last(list, 3);
       list = insert_last(list, 4);
       list = insert_last(list, 5);
       list = insert_last(list, 6);
       list = insert_last(list, 7);
       list = insert_last(list, 8);
       print_list(list);

       list = insert_front(list ,0);
       System.out.println("--------------------");
       print_list(list);
       list = delete_first(list);
       System.out.println("--------------------");
       print_list(list);
       list = delete_last(list);
       System.out.println("--------------------");
       print_list(list);
       list = insert_by_index(list , 13 , 4);
       System.out.println("--------------------");
       print_list(list);
       delete_index(list , 4);
       System.out.println("--------------------");
       print_list(list);

    }
}
