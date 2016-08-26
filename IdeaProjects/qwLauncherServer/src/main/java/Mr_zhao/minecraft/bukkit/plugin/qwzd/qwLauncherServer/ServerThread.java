package Mr_zhao.minecraft.bukkit.plugin.qwzd.qwLauncherServer;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by yzh on 16-8-22.
 */
public class ServerThread extends Thread {
    @Override
    public void run(){
       ServerSocket ss;
        try {
            ss=new ServerSocket(45);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
