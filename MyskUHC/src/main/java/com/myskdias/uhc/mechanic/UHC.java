package com.myskdias.uhc.mechanic;

import com.myskdias.api.logging.CustomLogger;
import com.myskdias.uhc.UHCMain;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * The class responsible to manage how the game unfold
 */
public class UHC {

    private Phase phase;
    private final CustomLogger logger;

    private UUID gameUUID;

    private int maxPlayers = 10;

    private CustomRunnable timer;

    private World worldUHC;

    public UHC() {
        logger = UHCMain.getInstance().getCustomLogger();
        this.phase = Phase.RESET;
        this.timer = new CustomRunnable();
        this.timer.runTaskTimer(UHCMain.getInstance(), 0, 20);
        reset();
    }

    private void reset() {
        logger.info("Resetting the UHC");
        this.phase = Phase.RESET;
        logger.fine("Entering Reset Phase");

        logger.finer("Kicking all the players");
        kickAllPlayers();

        gameUUID = UUID.randomUUID();

        logger.finer("Recreating the world");
        destroyWorld();
        newWorld();

        logger.finer("Creating spawn");
        createSpawn();

        logger.finer("Resetting timer");
        timer.reset();



        this.phase = Phase.WAITING;
        logger.fine("Entering Waiting Phase");
    }




    private void createSpawn() {

    }

    private void destroyWorld() {
        if(worldUHC != null) {
            for(Player p : worldUHC.getPlayers()) {
                p.kickPlayer("Recreating world");
            }
            Bukkit.unloadWorld(worldUHC, false);
            try {
                FileUtils.deleteDirectory(new File(worldUHC.getName()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void newWorld() {

        WorldCreator wc = new WorldCreator("UHC"+gameUUID);
        wc.environment(World.Environment.NORMAL);
        wc.type(WorldType.NORMAL);
        wc.hardcore(true);
        worldUHC = wc.createWorld();


    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Phase getPhase() {
        return phase;
    }

    private void kickAllPlayers() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.kickPlayer("Resetting the server...");
        }
    }

    public UUID getGameUUID() {
        return gameUUID;
    }

    private static class CustomRunnable extends BukkitRunnable {

        private int i = 0;

        @Override
        public void run() {
            i++;
        }

        public int getTime() {
            return i;
        }

        public void reset() {
            i = 0;
        }

    }

}
