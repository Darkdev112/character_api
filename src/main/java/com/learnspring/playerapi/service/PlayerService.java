package com.learnspring.playerapi.service;

import com.learnspring.playerapi.entity.Player;

public interface PlayerService {
    void create(Player player);
    Player find(int id);
    Player attack(int performer, int observer);
    Player heal(int id,int points);
}
