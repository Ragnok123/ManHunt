package ru.ragnok123.manhunt;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.utils.TextFormat;
import ru.ragnok123.minigameAPI.Minigame;
import ru.ragnok123.minigameAPI.arena.ArenaParameters;
import ru.ragnok123.minigameAPI.player.GameDataCreationEvent;

public class ManHuntMinigame extends Minigame {
	
	@EventHandler
	public void onDataLoad(GameDataCreationEvent e) {
		e.setTargetClass(MHPlayer.class);
	}
	
	@Override
	public String getPrefix() {
		return TextFormat.YELLOW + "[ManHunt]";
	}

	@Override
	public String getPrefix(String c) {
		return getPrefix() + " §"+c;
	}

	@Override
	public void handleSpawn(Player p, boolean join) {
		if(join) {
			getArenaManager().getArenaById(0).addPlayer(p);
		}
	}

	@Override
	public void loadMinigame() {
		this.arenaManager = new MHArenaManager(this);
	}

	@Override
	public void loadModes() {

	}

	@Override
	public String getMinigameCommand() {
		return "manhunt";
	}

}
