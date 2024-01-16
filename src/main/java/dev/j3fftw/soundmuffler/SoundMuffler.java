package dev.j3fftw.soundmuffler;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.BlobBuildUpdater;
import java.io.File;
import org.bstats.bukkit.Metrics;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;

public class SoundMuffler extends JavaPlugin implements SlimefunAddon {

    public static ItemGroup SOUND_MUFFLER;

    @Override
    public void onEnable() {
        if (!new File(getDataFolder(), "config.yml").exists())
            saveDefaultConfig();

        new Metrics(this, 7415);

        if (getConfig().getBoolean("options.auto-update") && getDescription().getVersion().startsWith("DEV - ")) {
            new BlobBuildUpdater(this, getFile(), "SoundMuffler", "Dev").start();
        }

        SOUND_MUFFLER = new ItemGroup(new NamespacedKey(this, "sound_muffler"),
            new CustomItemStack(Material.BEACON, "&7SoundMuffler", "", "&a> Click to open"));

        new SoundMufflerListener(this).start();

        SoundMufflerMachine soundMufflerMachine = new SoundMufflerMachine();
        soundMufflerMachine.register(this);

        new Research(new NamespacedKey(this, "sound_muffler"),
            6912, "Sound Muffler", 11)
            .addItems(soundMufflerMachine.getItem())
            .register();
    }


    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/J3fftw1/SoundMuffler/issues";
    }
}
