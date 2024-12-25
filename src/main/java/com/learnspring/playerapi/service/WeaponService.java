package com.learnspring.playerapi.service;

import com.learnspring.playerapi.entity.Weapon;

public interface WeaponService {
    Weapon build(Weapon weapon);
    Weapon search(int id);
    Weapon discard(int id);
}
