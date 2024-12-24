package com.learnspring.playerapi.service;

import com.learnspring.playerapi.dao.WeaponDAO;
import com.learnspring.playerapi.dao.WeaponDAOImpl;
import com.learnspring.playerapi.entity.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WeaponServiceImpl implements  WeaponService{

    private WeaponDAO weaponDAO;

    @Autowired
    public WeaponServiceImpl(WeaponDAO weaponDAO){
        this.weaponDAO=weaponDAO;
    }

    @Override
    @Transactional
    public void build(Weapon weapon){
        weaponDAO.build(weapon);
    }

    @Override
    public Weapon search(int id){
        Weapon foundWeapon = weaponDAO.search(id);
        return foundWeapon;
    }

    @Override
    @Transactional
    public Weapon upgrade(Weapon weapon){
        Weapon upgradedWeapon = weaponDAO.upgrade(weapon);
        return upgradedWeapon;

    }

    @Override
    @Transactional
    public Weapon discard(int id){
        Weapon discardedWeapon = weaponDAO.discard(id);
        return discardedWeapon;
    }

}
