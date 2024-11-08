package com.uralhalil.systems;

import com.uralhalil.data.GameEntity;
import com.uralhalil.data.Item;
import com.uralhalil.data.Player;

import java.util.List;

/**
 * @author halilural
 */
public class ItemCollectionSystem {
    public List<GameEntity> collectItems(GameEntity player, List<GameEntity> entities) {
        return entities.stream()
                .map(entity -> {
                    // Perform pattern matching first
                    if (entity instanceof Item item) {
                        // Apply additional condition after type check
                        if (isNearPlayer((Player) player, item)) {
                            return new Item(item.x(), item.y(), true); // Collected item
                        }
                    }
                    return entity;
                })
                .toList();
    }

    private boolean isNearPlayer(Player player, Item item) {
        float distance = (float) Math.sqrt(Math.pow(player.x() - item.x(), 2) + Math.pow(player.y() - item.y(), 2));
        return distance < 1.0f; // Pickup range
    }
}
