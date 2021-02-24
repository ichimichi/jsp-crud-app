package com.webapp;

import java.util.List;

public interface PlayerRepository {
	public boolean addPlayer(Player player);
    public List<Player> getAllPlayersByCountry(String country);
    public List<Player> getAllPlayers();
    public boolean deletePlayer(String playerid);
}
