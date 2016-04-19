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
    private Set<Router> connections;
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
            // 0: distance, 1: router
            {16, -1},
            {16, -1},
            {16, -1},
            {16, -1},
            {16, -1},
            {16, -1}
        };
        map[id][0] = 0;
        map[id][1] = id;
        connections = new HashSet<>();
    }
    
    public void connectDirectly(Router router, int distance)
    {
        connections.add(router);
        //write distance to the map to shortcut the process
        this.map[router.getId()][0] = distance;
        this.map[router.getId()][1] = router.getId();
    }
    
    public int getId() 
    {
        return this.id;
    }
    
    public int[][] getMap() {
        return this.map;
    }
    
    private void update() {
        connections.stream().forEach((router) -> {
            int[][] remoteMap = router.getMap();
            
            for(int i = 0; i < 6; i++) {
                if((remoteMap[i][0] + this.map[router.getId()][0]) < this.map[i][0]) {
                    // Update the map to the shortest
                    this.map[i][0] = remoteMap[i][0];
                    this.map[i][1] = router.getId();
                }
            }
        });
    }
}
