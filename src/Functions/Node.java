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
public class Node<T>{
   

    T data;
    Node<T> next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }

    /**
    * Obtiene el Dato.
    */
    public T getData() {
        return data;
    }

    /**
    * Setea el Dato.
    */
    public void setData(T data) {
        this.data = data;
    }

    /**
    * Obtiene el Siguiente.
    */
    public Node<T> getNext() {
        return next;
    }

    /**
    * Setea el Siguiente.
    */
    public void setNext(Node<T> next) {
        this.next = next;
    }
   
   
} 

