package de.rapha149.signgui;

import com.tcoded.folialib.FoliaLib;
import com.tcoded.folialib.impl.PlatformScheduler;
import org.bukkit.plugin.java.JavaPlugin;

public class SignScheduler {

    private static FoliaLib foliaLib;

    public static PlatformScheduler scheduler() {
        if (foliaLib == null)
            foliaLib = new FoliaLib(JavaPlugin.getProvidingPlugin(SignScheduler.class));

        return foliaLib.getScheduler();
    }
}