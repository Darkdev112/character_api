package com.learnspring.playerapi.dao;


import com.learnspring.playerapi.entity.Player;
import com.learnspring.playerapi.entity.Weapon;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDAOImpl implements PlayerDAO{

    private EntityManager entityManager;

    @Autowired
    public PlayerDAOImpl(EntityManager entityManager){
        this.entityManager  = entityManager;
    }

    @Override
    public void create(Player player){
        entityManager.persist(player);
    }

    @Override
    public Player find(int id){
        Player foundPlayer = entityManager.find(Player.class,id);
        return foundPlayer;
    }

    @Override
    public Player attack(int performer, int observer){
        Player actor = entityManager.find(Player.class,performer);
        Player receiver = entityManager.find(Player.class,observer);

        Weapon attackingWeapon = actor.getWeapon();
        int enemyHp = receiver.getHp();

        if(enemyHp < attackingWeapon.getAttack()){
            enemyHp = 0;
        }else{
            enemyHp -= attackingWeapon.getAttack();
        }

        receiver.setHp(enemyHp);

        Player updatedReceiver = entityManager.merge(receiver);
        return updatedReceiver;
    }

    @Override
    public Player heal(int id, int points){
        Player foundPlayer = entityManager.find(Player.class,id);

        int hp = foundPlayer.getHp();
        if((hp + points) > 100){
            hp = 100;
        }else{
            hp += points;
        }

        foundPlayer.setHp(hp);

        Player updatedPlayer = entityManager.merge(foundPlayer);
        return updatedPlayer;
    }

}
