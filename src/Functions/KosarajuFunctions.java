/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

/**
 *
 * @author Abraham Santana
 */
public class KosarajuFunctions {

    private static LinkedList dfsStack;
//Perform DFS traversal of the graph. Push node to stack before returning.

//Find the transpose graph by reversing the edges.

//Pop nodes one by one from the stack and again to DFS on the modified graph.
    
    public KosarajuFunctions(){
        this.dfsStack = new LinkedList();
    }

    public static void findSCC() {
        System.out.println("Entramos a findSCC");
        LinkedList users = GlobalVariables.getUserGraph();
        LinkedList visited = new LinkedList();
        dfsMakeStack(users.getHead(), visited);
        System.out.println("Hicimos el stack");
        LinkedList userStack = KosarajuFunctions.getDfsStack();
        TextFunctions.getTransposedGraph();
        LinkedList transposedGraph = GlobalVariables.getTransposedUserGraph();
        LinkedList sccGroupsList = new LinkedList();
        
        Node stackPointer = userStack.getHead();
        while(stackPointer != null){
            User stackUser = (User) stackPointer.getData();
            
            Node graphPointer = transposedGraph.getHead();
            while (graphPointer != null){
                User transUser = (User) graphPointer.getData();
                if (transUser.getUsername().equals(stackUser.getUsername())){
                    LinkedList sccGroup = new LinkedList();
                    dfsSCC(transUser, sccGroup);
                    sccGroupsList.append(sccGroup);
                }else{
                    graphPointer = graphPointer.getNext();
                }
            }
            stackPointer = stackPointer.getNext();
        }
        GlobalVariables.setSccGroupsList(sccGroupsList.cleanListOfLists());
                
    }

    public static LinkedList getDfsStack() {
        return dfsStack;
    }

    public static void setDfsStack(LinkedList dfsStack) {
        KosarajuFunctions.dfsStack = dfsStack;
    }
    
    
    public static void dfsMakeStack(Node current, LinkedList visited){
        User currentUser = (User) current.getData();
        Node pointer = currentUser.getRelations().getHead();
        
        while (pointer != null){
            if (!KosarajuFunctions.getDfsStack().isIn(pointer) && visited.isIn(pointer)){
              visited.appendNode(pointer);
              dfsMakeStack(pointer, visited);  
            }
            pointer.getNext();
        }
        KosarajuFunctions.getDfsStack().append(current);
    }

    private static void dfsSCC(User currentUser, LinkedList sccGroup) {
        
        Node pointer = currentUser.getRelations().getHead();
        while (pointer != null){
            User currentRelation = (User) pointer.getData();
            dfsSCC(currentRelation,sccGroup);
        }
        sccGroup.append(currentUser);
             
        
    
    }


    


}

