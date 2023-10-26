/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author victoriagarcia
 */
public class GraphMaker {
    public static LinkedList userList = GlobalVariables.getUserGraph();
    
    public static Graph createVisualGraph() {
        Graph graph = new SingleGraph("Grafo de usuarios");
        graph.setAttribute("ui.stylesheet", 
                "node{\n" +
                "    size: 30px, 30px;\n" +
                "    fill-color: #ff00a1;\n" +
                "    text-mode: normal; \n" +
                "    text-size: 18;\n"+
                "}");
        Node pointer = userList.getHead();
        while (pointer != null){
            User temp = (User) pointer.getData();
            graph.addNode(temp.getUsername()).setAttribute("ui.label", temp.getUsername());
            pointer = pointer.getNext();
        }
        pointer = userList.getHead();
        while (pointer != null){
            User temp = (User) pointer.getData();
            Node pointer2 = temp.getRelations().getHead();
            while (pointer2 != null){
                User temp2 = (User) pointer2.getData();
                graph.addEdge(temp.getUsername() + temp2.getUsername(), temp.getUsername(), temp2.getUsername());

                pointer2 = pointer2.getNext();
            }
            pointer = pointer.getNext();
        }
        System.setProperty("org.graphstream.ui", "swing");
        return graph;
    }
}

       
    

   
