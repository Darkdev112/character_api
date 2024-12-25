package com.learnspring.playerapi.controller;

import com.learnspring.playerapi.entity.Player;
import com.learnspring.playerapi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public  PlayerController( PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable int id){
        return playerService.find(id);
    }

    @PostMapping("/")
    public Player postPlayer(@RequestBody Player player){
        playerService.create(player);
        return player;
    }

    @PutMapping("/attack")
    public Player attackPlayer(@RequestParam("performer") int performer, @RequestParam("receiver") int receiver){
        Player affectedPlayer = playerService.attack(performer,receiver);
        return affectedPlayer;
    }

    @PutMapping("/heal/{id}")
    public Player healPlayer(@PathVariable int id, @RequestParam("points") int points){
        Player updatedPlayer = playerService.heal(id,points);
        return updatedPlayer;
    }
}
