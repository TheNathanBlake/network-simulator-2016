/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksimulator2016;

import java.util.ArrayList;
/**
 *
 * @author Nathan
 */
public class Router
{
    private final int id;
    private ArrayList<Integer> distances;
    private ArrayList<Integer> next; //
    
    /**
     * public Router
     * @param id a provided integer as index for the router.
     *
     */
    public Router(Integer id)
    {
        this.id = id;
        distances = new ArrayList<>();
        
        if(id >= 6)
        {
            System.out.println("Warning: program not designed to handle >6 routers.");
        }
        for(int i = 0; i < 6; i++)
        {
            if(i == id)
            {
                distances.add(0);
            }
            else
            {
                distances.add(-1);
            }            
            next.add(-1);
        }
    }
    
    public void connectDirectly(Router router, int distance)
    {
        int id = router.getId();
        this.distances.set(id, distance);
        this.next.set(id, id);
    }
    
    public int getId() 
    {
        return this.id;
    }
}
