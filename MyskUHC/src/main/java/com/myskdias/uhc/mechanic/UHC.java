package com.myskdias.uhc.mechanic;

import com.myskdias.api.logging.CustomLogger;
import com.myskdias.uhc.UHCMain;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * The class responsible to manage how the game unfold
 */
public class UHC implements Listener {

    private Phase phase;
    private final CustomLogger logger;

    public UHC() {
        logger = UHCMain.getInstance().getCustomLogger();
        this.phase = Phase.RESET;
        reset();

    }

    private void reset() {
        logger.info("Resetting the UHC");
        this.phase = Phase.RESET;
        logger.fine("Entering Reset Phase");

        logger.finer("Kicking all the players");
        kickAllPlayers();

        logger.finer("Recreating the world");
        newWorld();

        logger.finer("Creating spawn");
        createSpawn();

        logger.finer("Resetting timer");
        resetTimer();

        this.phase = Phase.WAITING;
        logger.fine("Entering Waiting Phase");
    }



    private void resetTimer() {

    }

    private void createSpawn() {

    }

    private void newWorld() {

    }

    public Phase getPhase() {
        return phase;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent pje) {

        switch (phase) {
            case LAUNCHING:
            case RESET:
                pje.getPlayer().kickPlayer("Impossible to join");
                return;
            case WAITING:

            default:
                break;
        }

    }

    private void kickAllPlayers() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.kickPlayer("Resetting the server...");
        }
    }
}
