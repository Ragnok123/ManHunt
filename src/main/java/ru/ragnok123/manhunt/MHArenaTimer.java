package ru.ragnok123.manhunt;

import cn.nukkit.Player;
import cn.nukkit.utils.TextFormat;
import ru.ragnok123.minigameAPI.arena.ArenaTimer;
import ru.ragnok123.minigameAPI.arena.IArena;

public class MHArenaTimer extends ArenaTimer {

	private int seconds;
	
	public MHArenaTimer(MHArena arena) {
		super(arena);
	}

	@Override
	public void tickCountdown(int second) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickGame(int second) {
		seconds++;
		MHArena a = (MHArena) this.getArena();
		for(Player p : a.getPlayers().values()) {
			if(!p.getName().equalsIgnoreCase(a.runner.getName())) {
				p.sendPopup(TextFormat.GREEN + "Distance: " + p.distance(a.runner)+ "m");
			}
		}
	}

	@Override
	public int getWaitTime() {
		return 0;
	}

	@Override
	public int getGameTime() {
		return 9999999;
	}

	@Override
	public void onEnd() {
		MHArena a = (MHArena) this.getArena();
		for(Player p : a.getPlayers().values()) {
			p.sendMessage(ManHuntMinigame.get().getPrefix("a") + "Game ended");
		}
	}

}
