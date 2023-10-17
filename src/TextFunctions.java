/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author victoriagarcia
 */
public class TextFunctions {

    /**
    * Crea el grafo dado el archivo de texto en la dirección 'pathname'.
    */
    public void createGraph(){
        
        String pathname = GlobalVariables.getTxtPath();
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
                        //Crear Clase User para usar como nodo
                        User newUser = new User(name);
                        users.append(newUser);
                        data = reader.nextLine();
                    }
                    if(data.equals("relaciones")){
                        //Pensar como anadir las relaciones entre nodos
                        while (reader.hasNextLine()) {
                            //Aqui buscamos por numero, en el proyecto se busca por nombre
                            data = reader.nextLine();
                            //Aqui va la logica de guardar en los usuarios las relaciones
                            //Buscar el usuario que esta primero y luego conectarlo al usuario que esta despues
                            String[] nodeInfo= data.split(", ");
                            String usuario1name;
                            nodeInfo[0] = usuario1name;
                            String usuario2name;
                            nodeInfo[1] = usuario2name;
                            
                            searchAndRelate(usuario1name)
                                
                        }
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir el archivo");
        }
    }

}
