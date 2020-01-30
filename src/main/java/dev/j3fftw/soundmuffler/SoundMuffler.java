package dev.j3fftw.soundmuffler;

import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.plugin.java.JavaPlugin;

public class SoundMuffler extends JavaPlugin {

    @Override
    public void onEnable() {
        new SoundMufflerListener(this).start();

        SoundMufflerMachine soundMufflerMachine = new SoundMufflerMachine();
        soundMufflerMachine.registerChargeableBlock(64);

        Slimefun.registerResearch(new Research(6912, "Sound Muffler", 11),
            soundMufflerMachine.getItem());
    }
}
