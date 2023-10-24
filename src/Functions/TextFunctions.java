package Functions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author victoriagarcia
 */
public class TextFunctions {

    /**
    * Crea el grafo dado el archivo de texto en la dirección 'pathname'.
    */
    public static void createGraph(String pathname){
        
        LinkedList users = new LinkedList();
        try {
            File inFile = new File(pathname);
            Scanner reader = new Scanner(inFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if (data.equals("usuarios")){
                    data = reader.nextLine();
                    while (!data.equals("relaciones") ) { 
                        String name = data;
                        //Anadiendo usuarios al grafo
                        User newUser = new User(name);
                        users.append(newUser);
                        data = reader.nextLine();
                    }
                    if(data.equals("relaciones")){
                        //anadiendo relaciones
                        while (reader.hasNextLine()) {
                            //Aqui buscamos por numero, en el proyecto se busca por nombre
                            data = reader.nextLine();
                            //Aqui va la logica de guardar en los usuarios las relaciones
                            String[] nodeInfo= data.split(", ");
                            String usuario1name = nodeInfo[0];
                            String usuario2name = nodeInfo[1];

                            searchAndRelate(usuario1name, usuario2name, users);
                                
                        }
                    }
                }
            }
            reader.close();
            GlobalVariables.setUserGraph(users);
            
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir el archivo");
        }
    }

    private static void searchAndRelate(String usuario1name, String usuario2name, LinkedList users) {
        // Buscamos los nodos que contienen a los usuarios
        Node nodeuser1 = users.getUser(usuario1name);
        Node nodeuser2 = users.getUser(usuario2name);
        
        User user1 = (User) nodeuser1.getData();
        User user2 = (User) nodeuser2.getData();
        
        //Hacemos la relacion
        user1.getRelations().append(user2);
    }

}
