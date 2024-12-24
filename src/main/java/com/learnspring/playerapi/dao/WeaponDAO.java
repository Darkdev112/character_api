package com.learnspring.playerapi.dao;

import com.learnspring.playerapi.entity.Weapon;

public interface WeaponDAO {
    void build(Weapon weapon);
    Weapon search(int id);
    Weapon upgrade(Weapon weapon);
    Weapon discard(int id);
}
