package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) throws PlayerNotFoundException {
        return playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException("Player not found"));
    }

    public long countPlayers() {
        return playerRepository.count();
    }

    public Player createPlayer(Player player) throws PlayerAlreadyExistsException {
        List<Player> existingPlayers = playerRepository.findByName(player.getName());
        if (!existingPlayers.isEmpty()) {
            throw new PlayerAlreadyExistsException("A player with the same name already exists");
        }

        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) throws PlayerNotFoundException {
        Player player = getPlayerById(id);
        playerRepository.delete(player);
    }

    public void updatePlayerName(Long id, String name) throws PlayerNotFoundException {
        Player player = getPlayerById(id);
        player.setName(name);
        playerRepository.save(player);
    }
}
