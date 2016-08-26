package org.minerpg.lib.bukkit.updater;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.minerpg.lib.bukkit.Version;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.concurrent.TimeoutException;

/**
 * Created by yzh on 16-8-26.
 */
public abstract class Updater {
    protected String name;
    protected String url="";
    //url=更新地址
    public Updater(String name){
        this.name=name;
    }
    public Updater(Plugin plugin){
        this.name=plugin.getName();
    }
    //升级的时候执行的代码
    public abstract void doUpdate();
    protected int getIntVersion(){
        Class plugin=Bukkit.getPluginManager().getPlugin(name).getClass();
        int version = 0;
        try{
    if(plugin.getSuperclass().getName().equals("MineRPGPlugin")){
       Version v= (Version) plugin.getAnnotation(Version.class);

    }}catch (Exception e){
            e.printStackTrace();
            System.out.println("插件"+name+"不是MineRPG系列 无法获取最新版本");
        }
        return version;
    }
    protected boolean isLast(){return getIntVersion()==getLastVersion();
    }
    public int getLastVersion(){
        int ver=0;
        try {
            URL Url=new URL(url+"/"+name+"/"+"version.html");
            //123.123.123/name/version.html
           HttpURLConnection con= (HttpURLConnection) Url.openConnection();
         con.setConnectTimeout(3000);
            con.setReadTimeout(3000);
            con.setDoOutput(true);
            con.setRequestMethod("GET");
            /*
            * 获取网页的内容 如: 1.2 3.2 等
            * */
        }
        catch (SocketTimeoutException e){
            e.printStackTrace();
            System.out.println("连接超时 获取插件"+name+"的最新版本失败");
        }catch (IOException e) {
            System.out.println("获取最新版本时发送错误");
            e.printStackTrace();
        }
        return ver;
    }

}
