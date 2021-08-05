package mumei.bbf.Listeners;

import mumei.bbf.Bbf;
import mumei.bbf.CustomConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClick implements Listener {
    public static CustomConfig config = Bbf.config;

    @EventHandler
    public void InveClicks(InventoryClickEvent p){
        Player player = Bbf.plugin.getServer().getPlayer(p.getWhoClicked().getName());
        player.sendMessage("test");
        if(p.getInventory().equals(Bbf.inv)){
            switch (p.getSlot()){
                case 0:
                    config.getConfiguration().set(player.getName(),"lava");
                    config.save();
                    config.reload();
                    player.sendMessage("Lavaを設定");
                    p.setCancelled(true);
                    break;
                case 1:
                    config.getConfiguration().set(player.getName(),"water_bubble");
                    config.save();
                    config.reload();
                    player.sendMessage("water_bubbleを設定");
                    p.setCancelled(true);
                    break;
                case 2:
                    config.getConfiguration().set(player.getName(),"flame");
                    config.save();
                    config.reload();
                    player.sendMessage("flameを設定");
                    p.setCancelled(true);
                    break;
                case 8:
                    config.getConfiguration().set(player.getName(),"");
                    config.save();
                    config.reload();
                    player.sendMessage("エフェクトをオフにしました");
                    p.setCancelled(true);
                    break;

                default:
                    player.sendMessage("現在開発中で今しばらくおまちください。");
                    p.setCancelled(true);
                    break;
            }








        }
    }

}
