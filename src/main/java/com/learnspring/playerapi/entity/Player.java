package com.learnspring.playerapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "player_name")
    private String name;

    @Column(name = "health")
    private int hp;

    @Column(name = "stamina")
    private int mp;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;

    public Player(){

    }

    public Player(String name){
        this.name = name;
        this.hp = 100;
        this.mp = 100;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Player{" +
                "mp=" + mp +
                ", hp=" + hp +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
