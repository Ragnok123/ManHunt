package ru.ragnok123.manhunt;

import ru.ragnok123.minigameAPI.Minigame;
import ru.ragnok123.minigameAPI.arena.ArenaManager;
import ru.ragnok123.minigameAPI.arena.ArenaParameters;
import ru.ragnok123.minigameAPI.arena.IArena;

public class MHArenaManager extends ArenaManager {

	public MHArenaManager(Minigame plugin) {
		super(plugin);
		generateNewArena(new ArenaParameters() {

			@Override
			public String paramsToString() {
				return "mh";
			}
			
		});
	}

	public int arenasPlayed = 0;
	
	@Override
	public void registerListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadMaps() {
		

	}

	@Override
	public IArena generateNewArena(ArenaParameters params) {
		MHArena arena = new MHArena(this, params, arenasPlayed);
		arenasPlayed++;
		getArenas().add(arena);
		return arena;
	}

}
