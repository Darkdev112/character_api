package com.learnspring.playerapi.controller;

import com.learnspring.playerapi.entity.Weapon;
import com.learnspring.playerapi.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weapons")
public class WeaponController {

    public WeaponService weaponService;

    @Autowired
    public WeaponController(WeaponService weaponService){
        this.weaponService = weaponService;
    }

    @GetMapping("/{id}")
    public Weapon searchWeapon(@PathVariable int id){
        Weapon foundWeapon = weaponService.search(id);
        return foundWeapon;
    }

    @PostMapping("/")
    public Weapon buildWeapon(@RequestBody Weapon weapon){
        weapon.setId(0);
        Weapon updatedWeapon = weaponService.build(weapon);
        return updatedWeapon;
    }

    @PutMapping("/")
    public Weapon upgradeWeapon(@RequestBody Weapon weapon){
        Weapon updatedWeapon = weaponService.build(weapon);
        return updatedWeapon;
    }

    @DeleteMapping("/{id}")
    public Weapon discardWeapon(@PathVariable int id){
        Weapon discardedWeapon = weaponService.discard(id);
        return discardedWeapon;
    }
}
