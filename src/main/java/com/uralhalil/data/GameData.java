package com.uralhalil.data;

import java.util.List;

/**
 * @author halilural
 */
public record GameData(Player player, List<GameEntity> items, List<GameEntity> enemies) {
    public GameData {
        items = List.copyOf(items);
        enemies = List.copyOf(enemies);
    }

    @Override
    public String toString() {
        return "GameData{" +
                "player=" + player +
                ", items=" + items +
                ", enemies=" + enemies +
                '}';
    }
}
