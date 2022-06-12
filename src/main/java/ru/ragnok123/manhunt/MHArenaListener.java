package ru.ragnok123.manhunt;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemCompass;
import ru.ragnok123.minigameAPI.arena.ArenaListener;

public class MHArenaListener extends ArenaListener {
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent ev) {
		if(ev instanceof EntityDamageByEntityEvent) {
			EntityDamageByEntityEvent e = (EntityDamageByEntityEvent)ev;
			Player damager = (Player)e.getDamager();
			Player victim = (Player)e.getEntity();
			MHArena arena = (MHArena) ManHuntMinigame.get().getArenaManager().getArenaById(0);
			if(arena.runner != null) {
				if(arena.runner == damager) {
					if(arena.PHASE == MHArena.COUNTDOWN) {
						arena.time = 0;
						for(Player p : arena.getPlayers().values()) {
							if(arena.runner != p) {
								ItemCompass compass = new ItemCompass();
								p.getInventory().addItem(compass);
							}
						}
					} else if(arena.PHASE == MHArena.GAME) {
						if( (victim.getHealth() - e.getDamage()) < 1) {
							e.setCancelled();
							victim.setHealth(victim.getMaxHealth());
							victim.teleport(victim.getSpawn());
							
							ItemCompass compass = new ItemCompass();
							victim.getInventory().addItem(compass);
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		MHArena arena = (MHArena) ManHuntMinigame.get().getArenaManager().getArenaById(0);
		if(arena.runner != null && arena.PHASE == MHArena.GAME) {
			if(arena.runner == p) {
				arena.time = 0;
			}
		}
	}
	
}