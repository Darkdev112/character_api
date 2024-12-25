package com.learnspring.playerapi.dao;

import com.learnspring.playerapi.entity.Weapon;

public interface WeaponDAO {
    Weapon build(Weapon weapon);
    Weapon search(int id);
    Weapon discard(int id);
}
