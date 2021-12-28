# -*- coding: utf-8 -*-
"""
Created on Tue Dec 28 16:52:05 2021

@author: mahmoud saeed
"""
class Node:
    def __init__(self , data = None):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None
        self.n = 0
        
    
    def add_node_first(self , data):
        new_node = Node(data)
        if self.head == None:
            self.head = new_node
        else:
            new_node.next = self.head
            self.head = new_node
        self.n = self.n+1
        return
    
    
    def print_list(self):
        temp = self.head
        while temp is not None:
            print(temp.data)
            temp = temp.next
        return    

    
    def add_node_last(self , data):
        new_node = Node(data)
        if self.head == None:
            self.head = new_node
        else:
            temp = self.head
            while temp.next is not None:
                temp = temp.next
            temp.next = new_node    
            
        self.n = self.n+1    
        return
    

    def add_index(self , data , index ):
        if index==0:
            self.add_node_first(data)
        elif index > self.n:
            self.add_node_last(data)
        else:
            temp = self.head
            i = 0
            new_node = Node(data)
            while temp != None:
                if i == index - 1:
                    new_node.next = temp.next
                    temp.next = new_node
                temp = temp.next
                i+=1
        self.n = self.n+1
        return    
                
    def delete_first_node(self):
        new_node = self.head.next
        self.head = new_node
        self.n = self.n-1    
        return
    
    def delete_last_node(self):
        if self.head == None:
            return
        temp = self.head
        while temp.next.next != None:
            temp = temp.next
            
        temp.next = None
        self.n = self.n-1    
        return   
 
    def delete_index(self , index):
        if self.head is None:
            return
        if index == 0:
            self.head = self.head.next
            return self.head
        i = 0
        current = self.head
        prev = self.head
        temp = self.head
        while current is not None:
            if i == index:
                temp = current.next
                break
            prev = current
            current = current.next
            i += 1
        prev.next = temp
        return   

    def search_node(self , data):
        temp = self.head
        i = 0
        while(temp != None):
            if temp.data == data:
                print("founded in index {}".format(i))
            temp = temp.next
            i += 1
        return    
                
l1 = LinkedList()
l1.add_node_first(3)
l1.add_node_first(2)
l1.add_node_first(1)
l1.add_node_last(4)
l1.add_node_last(5)
l1.add_node_last(6)
l1.print_list()
print("------------------" , l1.n)
l1.delete_first_node()
l1.print_list()
print("------------------" , l1.n)

l1.delete_last_node()
l1.print_list()
print("------------------" , l1.n)

l1.delete_index(2)
l1.print_list()
print("------------------",l1.n)

l1.add_index(11, 3)
l1.print_list()
print("------------------" , l1.n)

l1.add_index(11, 3)
l1.print_list()
print("------------------" , l1.n)
    
l1.add_index(12, 4)
l1.print_list()
print("------------------" , l1.n)


l1.search_node(11)
