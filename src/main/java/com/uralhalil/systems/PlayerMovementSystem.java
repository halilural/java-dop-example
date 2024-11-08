package com.uralhalil.systems;

import com.uralhalil.data.GameEntity;
import com.uralhalil.data.Player;

/**
 * @author halilural
 */
public class PlayerMovementSystem {
    public GameEntity moveEntity(GameEntity entity, float deltaX, float deltaY) {
        return switch (entity) {
            case Player player -> new Player(player.x() + deltaX, player.y() + deltaY, player.health());
            default -> entity; // No movement for other entity types
        };
    }
}
