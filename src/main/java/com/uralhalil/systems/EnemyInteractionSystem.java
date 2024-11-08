package com.uralhalil.systems;

import com.uralhalil.data.Enemy;
import com.uralhalil.data.GameEntity;
import com.uralhalil.data.Player;

import java.util.List;

/**
 * @author halilural
 */
public class EnemyInteractionSystem {
    public GameEntity interactWithEnemies(GameEntity player, List<GameEntity> entities) {
        if (!(player instanceof Player p)) return player; // Early exit if player isn't a Player

        // Use pattern matching and unnamed instances in stream processing
        return entities.stream()
                .filter(entity -> entity instanceof Enemy enemy && isNearPlayer(p, enemy))
                .findFirst()
                .map(enemy -> new Player(p.x(), p.y(), p.health() - 10)) // Damage player if near an enemy
                .orElse((Player) player); // Return unchanged player if no enemy is nearby
    }

    private boolean isNearPlayer(Player player, Enemy enemy) {
        float distance = (float) Math.sqrt(Math.pow(player.x() - enemy.x(), 2) + Math.pow(player.y() - enemy.y(), 2));
        return distance < 1.5f; // Interaction range
    }
}

