package com.learnspring.playerapi.dao;

import com.learnspring.playerapi.entity.Weapon;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WeaponDAOImpl implements WeaponDAO {

    private EntityManager entityManager;

    @Autowired
    public WeaponDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void build(Weapon weapon) {
        entityManager.merge(weapon);
    }

    @Override
    public Weapon search(int id){
        Weapon foundWeapon = entityManager.find(Weapon.class,id);
        return foundWeapon;
    }

    @Override
    public Weapon upgrade(Weapon weapon){
        Weapon updatedWeapon = entityManager.merge(weapon);
        return updatedWeapon;
    }

    @Override
    public Weapon discard(int id){
        Weapon foundWeapon = entityManager.find(Weapon.class,id);
        entityManager.remove(foundWeapon);
        return foundWeapon;
    }
}
