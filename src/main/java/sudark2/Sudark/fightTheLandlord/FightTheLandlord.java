package sudark2.Sudark.fightTheLandlord;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class FightTheLandlord extends JavaPlugin {

    public static JavaPlugin getPlugin(){
        return (FightTheLandlord) Bukkit.getPluginManager().getPlugin("FightTheLandlord");
    }
    @Override
    public void onEnable() {
        Cards.initialise();

        Bukkit.getPluginManager().registerEvents(new EventListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
