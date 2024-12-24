package com.learnspring.playerapi.service;

import com.learnspring.playerapi.dao.PlayerDAO;
import com.learnspring.playerapi.dao.PlayerDAOImpl;
import com.learnspring.playerapi.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerServiceImpl implements PlayerService{

    private PlayerDAO playerDAO;

    @Autowired
    public PlayerServiceImpl(PlayerDAO playerDAO){
        this.playerDAO = playerDAO;
    }

    @Override
    @Transactional
    public void create(Player player){
        playerDAO.create(player);
    }

    @Override
    public Player find(int id){
        Player foundPlayer = playerDAO.find(id);
        return foundPlayer;
    }

    @Override
    @Transactional
    public Player attack(int performer, int observer){
        Player receiver = playerDAO.attack(performer,observer);
        return receiver;
    }

    @Override
    @Transactional
    public Player heal(int id, int points){
        Player player = playerDAO.heal(id, points);
        return player;
    }
}
