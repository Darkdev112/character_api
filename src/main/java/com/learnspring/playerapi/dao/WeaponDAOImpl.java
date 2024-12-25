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
    public Weapon build(Weapon weapon) {
        Weapon theWeapon = entityManager.merge(weapon);
        return theWeapon;
    }

    @Override
    public Weapon search(int id){
        Weapon foundWeapon = entityManager.find(Weapon.class,id);
        return foundWeapon;
    }

    @Override
    public Weapon discard(int id){
        Weapon foundWeapon = entityManager.find(Weapon.class,id);
        entityManager.remove(foundWeapon);
        return foundWeapon;
    }
}
