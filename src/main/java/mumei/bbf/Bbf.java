package mumei.bbf;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bbf extends JavaPlugin implements Listener {
    public static JavaPlugin plugin;
    private Listener listener;
    public static CustomConfig config;
    public static Inventory inv;

    @Override
    public void onEnable() {
        // Plugin startup logic
        config = new CustomConfig(this);
        config.saveDefault();

        //GUI作成
        inv = Bukkit.createInventory(null,9,"エフェクト設定");
        inv.setItem(0,new ItemStack(Material.LAVA_BUCKET));
        inv.setItem(1,new ItemStack(Material.WATER_BUCKET));
        inv.setItem(2,new ItemStack(Material.BLAZE_ROD));
        inv.setItem(3,new ItemStack(Material.STONE));
        inv.setItem(8,new ItemStack(Material.BEDROCK));

        //commands
        getCommand("bbf").setExecutor(new Bbfmenu());

        Bukkit.getServer().getPluginManager().registerEvents(this,this);
        super.onEnable();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        super.onDisable();
    }
    public static CustomConfig getCustomConfig(){
        return config;
    }
}
