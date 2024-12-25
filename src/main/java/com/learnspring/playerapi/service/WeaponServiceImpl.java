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
    public Weapon build(Weapon weapon){
        Weapon updatedWeapon = weaponDAO.build(weapon);
        return updatedWeapon;
    }

    @Override
    public Weapon search(int id){
        Weapon foundWeapon = weaponDAO.search(id);
        return foundWeapon;
    }

    @Override
    @Transactional
    public Weapon discard(int id){
        Weapon discardedWeapon = weaponDAO.discard(id);
        return discardedWeapon;
    }

}
