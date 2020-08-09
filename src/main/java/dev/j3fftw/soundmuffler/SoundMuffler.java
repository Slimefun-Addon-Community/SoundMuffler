package dev.j3fftw.soundmuffler;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.core.researching.Research;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.bstats.bukkit.Metrics;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class SoundMuffler extends JavaPlugin implements SlimefunAddon {

    public static Category SOUND_MUFFLER;

    @Override
    public void onEnable() {

        new Metrics(this, 7415); 

        SOUND_MUFFLER = new Category(new NamespacedKey(this, "sound_muffler"),
            new CustomItem(Material.BEACON, "&7SoundMuffler", "", "&a> Click to open"));

        new SoundMufflerListener(this).start();

        SoundMufflerMachine soundMufflerMachine = new SoundMufflerMachine();
        soundMufflerMachine.register(this);

        Research research = new Research(new NamespacedKey(this, "sound_muffler"), 6912, "Sound Muffler", 11);
        research.addItems(soundMufflerMachine.getItem());
        research.register();
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
