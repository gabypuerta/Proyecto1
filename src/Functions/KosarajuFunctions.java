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
    
    // dfs Function to reach destination
	public static boolean dfs(Node current, Node destination, LinkedList visited) {

		// If curr node is destination return true
		if (current == destination) {
			return true;
		}
		visited.append(current);
                User temp = (User) current.getData();
                Node pointer = temp.getRelations().getHead();
                while (pointer != null) {
                     temp = (User) pointer.getData();
                    if (visited.getUser(temp.getUsername()) == null){
                        if (dfs(pointer.getNext(), destination, visited)) {
					return true;
				}
                    }
                }
                return false;
                
	}

	// To tell whether there is path from source to
	// destination
	public static boolean isPath(Node src, Node des) {
		LinkedList visited = new LinkedList();
		return dfs(src, des, visited);
	}

	// Function to return all the strongly connected
	// component of a graph.

	public static LinkedList findSCC() {
                LinkedList users = GlobalVariables.getUserGraph();
		// Stores all the strongly connected components.
		LinkedList out = new LinkedList();

		// Stores whether a vertex is a part of any Strongly
		// Connected Component
		LinkedList is_scc = new LinkedList();                
                Node pointer = users.getHead();
                while(pointer != null){
                    User temp = (User) pointer.getData();
                    

				// If a vertex i is not a part of any SCC
				// insert it into a new SCC list and check
				// for other vertices whether they can be
				// the part of this list.
				LinkedList scc = new LinkedList();
				scc.append(pointer);
                                
                                Node pointer2 = pointer;
                                while (pointer2 != null){
                                // If there is a path from vertex i to
                                // vertex j and vice versa, put vertex j
				// into the current SCC list.
                                User temp2 = (User) pointer2.getData();
                                    if (is_scc.getUser(temp2.getUsername()) != null
                                        && isPath(pointer, pointer2) && isPath(pointer2, pointer)) {
						is_scc.append(pointer2);
						scc.append(pointer2);
                                    }
                                    pointer2 = pointer2.getNext();
                                    
				}
                                
                            Node pointer3 = scc.getHead();
                            while (pointer3 != null) {
                                out.append(pointer3);
                                pointer3 = pointer3.getNext();
                                }        
                    
                    pointer = pointer.getNext();
                }
                return out;
        }


}
