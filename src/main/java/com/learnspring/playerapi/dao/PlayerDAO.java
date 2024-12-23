package com.learnspring.playerapi.dao;

import com.learnspring.playerapi.entity.Player;
import com.learnspring.playerapi.entity.Weapon;

import java.util.UUID;

public interface PlayerDAO {
    void create(Player player);
    Player find(int id);
    Player attack(int performer, int observer);
    Player heal(int id,int points);
//    void changeWeapon(int id,int weapon_id);
}
