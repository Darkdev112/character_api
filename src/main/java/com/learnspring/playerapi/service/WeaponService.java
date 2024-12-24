package com.learnspring.playerapi.service;

import com.learnspring.playerapi.entity.Weapon;

public interface WeaponService {
    void build(Weapon weapon);
    Weapon search(int id);
    Weapon upgrade(Weapon weapon);
    Weapon discard(int id);
}
