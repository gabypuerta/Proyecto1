/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author victoriagarcia
 */
class User {
    String username;
    LinkedList relations;

    public User(String username) {
        this.username = username;
        this.relations = new LinkedList();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LinkedList getRelations() {
        return relations;
    }

    public void setRelations(LinkedList relations) {
        //Hay que anadir a relations como si fuese una lista
        this.relations = relations;
    }
    
    
}
