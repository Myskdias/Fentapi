package com.myskdias.chat;

import com.myskdias.api.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private final String format;

    public ChatListener(String format) {
        this.format = format;
    }

    /**
     * Event en charge de set le bon format du message
     *
     * @param ape event
     */
    @EventHandler(priority = EventPriority.LOW)
    public void onChatLow(AsyncPlayerChatEvent ape) {
        ape.setFormat(format);
    }

    /**
     *
     * Event en charge de gerer les message envoyé dans le chat et de les reformatés</br>
     * player -> %1$s</br>
     * msg -> %2$s
     *
     *
     * @param ape event
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent ape) {
        String format = ape.getFormat();
        format = format.replace("<player>", ape.getPlayer().getName());
        format = format.replace("<message>", Utils.colorMessage(ape.getMessage()));
        format = format.replace("&", "§");
        ape.setFormat(format);
    }

}
