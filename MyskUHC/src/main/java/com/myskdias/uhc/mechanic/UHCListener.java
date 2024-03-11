package com.myskdias.uhc.mechanic;

import com.myskdias.uhc.UHCMain;
import com.myskdias.uhc.mechanic.data.UHCData;
import com.myskdias.uhc.mechanic.data.UHCDataManager;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.projectiles.ProjectileSource;

public class UHCListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent pje) {
        UHC uhc = UHCMain.getInstance().getUhc();
        switch (uhc.getPhase()) {
            case LAUNCHING:
            case RESET:
                pje.getPlayer().kickPlayer("Impossible to join");
                return;
            case WAITING:
            default:
                UHCData data = UHCMain.getInstance().getUhcDataManager().getData(pje.getPlayer());

                break;
        }

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent pqe) {

        UHCMain.getInstance().getUhcDataManager().playerQuit(pqe.getPlayer());

    }

    public void onDamage(EntityDamageByEntityEvent e) {
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if(e.getDamager() instanceof Arrow) {
                Arrow arr = (Arrow) e.getDamager();
                ProjectileSource ps = arr.getShooter();
                if(ps instanceof Player) {
                    Player shooter = (Player) ps;
                    UHCDataManager uhcDataManager = UHCMain.getInstance().getUhcDataManager();
                    if(uhcDataManager.getData(p).getTeam().equals(uhcDataManager.getData(shooter).getTeam())) {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getDamager() instanceof Player) {
                Player damager = (Player) e.getDamager();
                UHCDataManager uhcDataManager = UHCMain.getInstance().getUhcDataManager();
                if(uhcDataManager.getData(p).getTeam().equals(uhcDataManager.getData(damager).getTeam())) {
                    e.setCancelled(true);
                }
            }
        }
        
    }

}
