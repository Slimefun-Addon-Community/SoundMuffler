package dev.j3fftw.soundmuffler;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.core.researching.Research;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.updater.GitHubBuildsUpdater;
import org.bstats.bukkit.Metrics;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class SoundMuffler extends JavaPlugin implements SlimefunAddon {

    public static Category SOUND_MUFFLER;

    @Override
    public void onEnable() {
        if (!new File(getDataFolder(), "config.yml").exists())
            saveDefaultConfig();

        new Metrics(this, 7415);

        if (getConfig().getBoolean("options.auto-update") && getDescription().getVersion().startsWith("DEV - ")) {
            new GitHubBuildsUpdater(this, getFile(), "J3fftw1/SoundMuffler/master").start();
        }

        SOUND_MUFFLER = new Category(new NamespacedKey(this, "sound_muffler"),
            new CustomItem(Material.BEACON, "&7SoundMuffler", "", "&a> Click to open"));

        new SoundMufflerListener(this).start();

        SoundMufflerMachine soundMufflerMachine = new SoundMufflerMachine();
        soundMufflerMachine.register(this);

        new Research(new NamespacedKey(this, "sound_muffler"),
                     6912, "Sound Muffler", 11)
        .addItems(soundMufflerMachine.getItem())
        .register();
    }


    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/J3fftw1/SoundMuffler/issues";
    }
}
