package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long id) throws PlayerNotFoundException {
        return playerService.getPlayerById(id);
    }

    @GetMapping("/count")
    public long countPlayers() {
        return playerService.countPlayers();
    }

    @RequestMapping("/hello")
    public String sayHello() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping(value = "", consumes="application/json")
    public ResponseEntity<String> createPlayer(@RequestBody Player player) {
        try {
            playerService.createPlayer(player);
            return new ResponseEntity<>("Player created successfully", HttpStatus.CREATED);
        } catch (PlayerAlreadyExistsException e) {
            return new ResponseEntity<>("A player with the same name already exists", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long id) {
        try {
            playerService.deletePlayer(id);
            return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
        } catch (PlayerNotFoundException e) {
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayerName(@PathVariable Long id, @RequestBody String name) {
        try {
            playerService.updatePlayerName(id, name);
            return new ResponseEntity<>("Player name updated successfully", HttpStatus.OK);
        } catch (PlayerNotFoundException e) {
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }
    }
}
