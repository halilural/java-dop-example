package com.uralhalil;

import com.uralhalil.data.Enemy;
import com.uralhalil.data.GameData;
import com.uralhalil.data.Item;
import com.uralhalil.data.Player;
import com.uralhalil.systems.EnemyInteractionSystem;
import com.uralhalil.systems.ItemCollectionSystem;
import com.uralhalil.systems.PlayerMovementSystem;

import java.util.List;

/**
 * @author halilural
 */
public class Game {
    private GameData data = new GameData(
            new Player(0, 0, 100),
            List.of(new Item(2, 2, false), new Item(5, 5, false)),
            List.of(new Enemy(3, 3, 50), new Enemy(6, 6, 50))
    );
    private final PlayerMovementSystem movementSystem = new PlayerMovementSystem();
    private final ItemCollectionSystem collectionSystem = new ItemCollectionSystem();
    private final EnemyInteractionSystem enemySystem = new EnemyInteractionSystem();

    public void update(float deltaX, float deltaY) {
        // Move the player and update GameData with a new player instance
        data = new GameData(
                (Player) movementSystem.moveEntity(data.player(), deltaX, deltaY),
                collectionSystem.collectItems(data.player(), data.items()),
                data.enemies()
        );

        // Interact with enemies and update GameData with a new player instance if health changes
        data = new GameData(
                (Player) enemySystem.interactWithEnemies(data.player(), data.enemies()),
                data.items(),
                data.enemies()
        );
    }

    public static void main(String[] args) {
        var game = new Game();
        // Example of moving and updating the game
        game.update(1.0f, 0.5f); // Move the player
        System.out.println("data: " + game.data);
        game.update(-0.5f, -1.0f); // Move again
        System.out.println("data: " + game.data);

    }
}
