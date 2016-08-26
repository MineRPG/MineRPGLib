package Mr_zhao.minecraft.bukkit.plugin.qwzd.qwLauncherServer;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by yzh on 16-8-22.
 */
public class LauncherServer extends JavaPlugin {

    @Override
    public void onEnable(){
        new ServerThread().start();
    }
}
