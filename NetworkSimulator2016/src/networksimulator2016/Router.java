/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksimulator2016;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Nathan
 */
public class Router
{
    private final int id;
    private int[][] map;
    private Set<Integer> connections;
    /**
     * public Router
     * @param id a provided integer as index for the router.
     *
     */
    public Router(Integer id)
    {
        this.id = id;
        map = new int[][] 
        {
            {16, -1},
            {16, -1},
            {16, -1},
            {16, -1},
            {16, -1},
            {16, -1}
        };
        map[id][0] = 0;
        connections = new HashSet<>();
    }
    
    public void connectDirectly(int router, int distance)
    {
        connections.add(router);
        this.map[router][0] = distance;
        this.map[router][1] = router;
    }
    
    public int getId() 
    {
        return this.id;
    }
    
    public int[][] getMap() {
        return this.map;
    }
    
    private void update(int router, int[][] map) {
        for(int i = 0; i < 6; i++) {
            if(i == router) ;
            else {
                this.map[i][0] = Math.min(map[i][0], )
                
            }
        }
    }
}
