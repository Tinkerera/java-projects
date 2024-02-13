package AdventureGame.Location.SafeLocation;

import AdventureGame.Entity.Player.Player;
import AdventureGame.Location.Location;

public class SafeHouse extends Location {
    Player player;
    int playerMaxHealth;

    public SafeHouse(Player player) {
        this.player = player;
        this.playerMaxHealth = player.getCharacter().getHealth();
    }

    @Override
    public void enter() {
        player.getCharacter().setHealth(playerMaxHealth);
        System.out.println("\nYou Rested at Safe House! Your Health Has Been Refreshed.");
    }
}