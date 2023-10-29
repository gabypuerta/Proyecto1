package Functions;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gaby3
 */
public class LinkedList<T> {
    Node<T> head;
    int size = 0;

    /**
    * Obtiene la Cabeza.
    */
    public Node<T> getHead() {
        return head;
    }

    /**
    * Setea la Cabeza.
    */
    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
    * Obtiene el Tamaño.
    */
    public int getSize() {
        return size;
    }

    /**
    * Setea el Tamaño.
    */
    public void setSize(int size) {
        this.size = size;
    }
   
   
    /**
    * Añade un nuevo nodo de tipo T.
    */
    public void append(T data){
        Node<T> newNode = new Node<>(data);
        if(this.getHead() == null){
            this.head = newNode;
        } else {
            Node<T> current = this.getHead();
            while(current.getNext() != null)
                current = current.getNext();
            current.next = newNode;
        }
        this.size++;
    }

    /**
    * Obtiene el nodo en la posición 'index' de la lista enelazada.
    */
    public Node<T> get(int index){
        if(this.getHead() == null)
            return null;
        if(index == 0)
            return this.head;
        int i = 1;
        Node current = this.getHead();
        while(current.getNext() != null){
            if(i == index)
                return current.getNext();
            current = current.getNext();
            i++;
        }
        return null;
    }
   
    /**
    * Elimina al nodo que corresponde al dato T dado en la 'key'.
    */
    public void delete(T key){
        if(this.getHead() == null)
            return;
        if(this.getHead().getData() == key){
            this.head = this.getHead().getNext();
            this.size--;
            return;
         }
        Node current = this.getHead();
        while(current.getNext() != null){
            if(current.getNext().getData() == key){
                current.next = current.getNext().getNext();
                this.size--;
                return;
            }
            current = current.getNext();
        }
    }
   
    public Node getUser(String name_to_find){
       
        Node pointer = this.getHead();
       
        while (pointer != null){
            User userCheck = (User) pointer.getData();
            if(userCheck.getUsername().equals(name_to_find)){
                return pointer;
            }else{
                pointer = pointer.getNext();
            }
        }
        return null;
    }
   
    public void appendNode (Node node){
        if(this.getHead() == null){
            this.head = node;
        } else {
            Node<T> current = this.getHead();
            while(current.getNext() != null)
                current = current.getNext();
            current.next = node;
        }
        this.size++;

    }
    
    public boolean isIn(Node node){
        Node pointer = this.getHead();
        while (pointer != null){
            if (pointer == node){
                return true;
            }
            pointer = pointer.getNext();
        }
        return false;
    }

    public LinkedList cleanListOfLists() {
        
        LinkedList cleanListOfLists = new LinkedList();
        
        Node pointer = this.getHead();
        while (pointer.getNext() != null){
            LinkedList currentList = (LinkedList) pointer.getData();
            LinkedList nextList = (LinkedList) pointer.getNext().getData();
            
            Node currentPointer = currentList.getHead();
            
            LinkedList newCurrentList = new LinkedList();
            
            while(currentPointer != null){
                Boolean repeated = false;
                Node nextPointer = nextList.getHead();
                while (nextPointer != null){
                    if (currentPointer == nextPointer){
                        repeated = true;
                    }
                    nextPointer = nextPointer.getNext();
                }
                if (!repeated){
                   newCurrentList.append(currentPointer); 
                }
                
                currentPointer = currentPointer.getNext();
            }
            cleanListOfLists.append(newCurrentList);
            pointer = pointer.getNext();
        }
        return cleanListOfLists;
    
    }
}
