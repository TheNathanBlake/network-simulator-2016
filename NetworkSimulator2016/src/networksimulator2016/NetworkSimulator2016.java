/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksimulator2016;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Nathan
 */
public class NetworkSimulator2016 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./test/data.txt"));
        }
        catch(FileNotFoundException e) {
            System.out.println("Error: Could not find the data file.");
            System.out.println("Working Directory: " + System.getProperty("user.dir"));
            return;
        }
        
        ArrayList<Router> network = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            network.add(new Router(i));
        }
        
        String line;
        try {
            while((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                network.get(Integer.parseInt(values[0])).connectDirectly(
                        network.get(Integer.parseInt(values[1])),
                        Integer.parseInt(values[2]));
                System.out.printf("Node1: %s, Node2: %s, distance: %s\n", values[0], values[1], values[2]);
            }
        }
        catch(IOException e) {
            e.printStackTrace(System.out);
        }
    }
    
}
