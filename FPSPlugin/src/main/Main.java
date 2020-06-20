package main;


import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin implements Listener{
	
	
	

	@Override
	public void onEnable() {
        System.out.println("TEST PLUGIN");
        System.out.println("PLUGIN IS ACTIVATED");
        Bukkit.getPluginManager().registerEvents(this, this);
    }
	
	@Override
    public void onDisable() {
        System.out.println("PLUGIN DISACTIVATED");
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void rightClickHandler(PlayerInteractEvent e) {
    	
    	Player p = e.getPlayer();
    	Action a = e.getAction();
    	Location location = p.getLocation();
    	Vector dir = location.getDirection();
    	
    	Map<String, Integer> iron_bullet = new HashMap<String, Integer>();
    	
    	if(a==Action.RIGHT_CLICK_AIR) {
    		
			if(p.getItemInHand().getType()==Material.IRON_HOE) {
			
				// 7712
				
					if(iron_bullet.containsKey(p.getName())) {
						iron_bullet.put(p.getName(), 0);
						p.playSound(location, Sound.BLOCK_DISPENSER_FAIL, 1, 10);
						return;
					}
					
					if(iron_bullet.get(p.getName())==0) {
						p.playSound(location, Sound.BLOCK_DISPENSER_FAIL, 1, 10);
						return;
					}
    				dir.normalize();
	    			dir.multiply(4);
	    			Arrow arrow = p.launchProjectile(Arrow.class);
	    			arrow.setDamage(15);
	    			arrow.setShooter(p);
	    			arrow.setSilent(true);
	    			arrow.setVelocity(dir);
	    			p.playSound(location, Sound.BLOCK_DISPENSER_LAUNCH, 1, 10);
	    			iron_bullet.put(p.getName(), iron_bullet.get(p.getName()) - 1);
	    			
	    			
	    			// ItemStack bullet = new ItemStack(Material.OAK_BUTTON, 1);
	    			// p.getInventory().removeItem(bullet);
	    			
    				
    			
    				// p.playSound(location, Sound.BLOCK_DISPENSER_FAIL, 1, 10);
    				//return;
    			}
    			
    			
    			
    		}
    			
    		
    		
    	
    	
    	
    }
    
    
}
