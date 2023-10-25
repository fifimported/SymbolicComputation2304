package com.eugene.demos.rabbits;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Timer;
import java.util.TimerTask;

public final class Main extends JavaPlugin implements Listener {

    private Timer rabbitTimer;


    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Fibonacci Rabbits are ready to play!");
        final World world = Bukkit.getWorld("world");

        TimerTask rabbitGenesisTask = new TimerTask() {
            public void run() {
                System.out.println("Players count=" + world.getPlayers().size());
                try{
                    if (world.getPlayers().size() > 0){
                        final Player player = world.getPlayers().get(0);
                        final Location location = player.getLocation(); //new Location(world, 0, 61, 0);
                        world.spawnEntity(location, EntityType.RABBIT);
                    }
                }
                catch(Exception exc){
                    System.out.println("Error=" + exc.getMessage());
                }
            }
        };
        rabbitTimer = new Timer();
        rabbitTimer.scheduleAtFixedRate(rabbitGenesisTask, 0, 1000);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Fibonacci Rabbits: shutdown.");
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){

    }
}
