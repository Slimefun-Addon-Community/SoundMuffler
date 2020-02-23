package dev.j3fftw.soundmuffler;

import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class SoundMuffler extends JavaPlugin {

    public static Category SOUND_MUFFLER;

    @Override
    public void onEnable() {
        SOUND_MUFFLER = new Category(new NamespacedKey(this, "sound_muffler"),
            new SlimefunItemStack("SOUND_MUFFLER", Material.BEACON, "&7SoundMuffler", "", "&a> Click to open"));

        new SoundMufflerListener(this).start();

        SoundMufflerMachine soundMufflerMachine = new SoundMufflerMachine();
        soundMufflerMachine.registerChargeableBlock(64);

        Slimefun.registerResearch(new Research(new NamespacedKey(this, "sound_muffler"), 6912, "Sound Muffler", 11),
            soundMufflerMachine.getItem());
    }

}
