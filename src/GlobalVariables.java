/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author victoriagarcia
 */
public class GlobalVariables {
    
    private static String txtPath = "";
    private static String testPath = "/Users/victoriagarcia/Documents/GitHub/Proyecto1/src/test/test.txt";
    private static LinkedList userGraph = new LinkedList();

    public static String getTxtPath() {
        return txtPath;
    }

    public static void setTxtPath(String txtPath) {
        GlobalVariables.txtPath = txtPath;
    }

    public static LinkedList getUserGraph() {
        return userGraph;
    }

    public static void setUserGraph(LinkedList userGraph) {
        GlobalVariables.userGraph = userGraph;
    }

    public static String getTestPath() {
        return testPath;
    }

    public static void setTestPath(String testPath) {
        GlobalVariables.testPath = testPath;
    }

}
