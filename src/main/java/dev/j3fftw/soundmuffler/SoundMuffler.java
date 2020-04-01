package dev.j3fftw.soundmuffler;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class SoundMuffler extends JavaPlugin implements SlimefunAddon {

    public static Category SOUND_MUFFLER;

    @Override
    public void onEnable() {
        SOUND_MUFFLER = new Category(new NamespacedKey(this, "sound_muffler"),
                new CustomItem(Material.BEACON, "&7SoundMuffler", "", "&a> Click to open"));

        new SoundMufflerListener(this).start();

        SoundMufflerMachine soundMufflerMachine = new SoundMufflerMachine();
        soundMufflerMachine.register(this);

        Slimefun.registerResearch(new Research(new NamespacedKey(this, "sound_muffler"), 6912, "Sound Muffler", 11),
                soundMufflerMachine.getItem());
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
