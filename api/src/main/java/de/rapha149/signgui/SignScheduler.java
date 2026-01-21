package de.rapha149.signgui;

import com.tcoded.folialib.FoliaLib;
import com.tcoded.folialib.impl.PlatformScheduler;
import org.bukkit.plugin.java.JavaPlugin;

public class SignScheduler {

    private static FoliaLib foliaLib;

    public static PlatformScheduler scheduler(
            JavaPlugin plugin
    ) {
        if (foliaLib == null)
            foliaLib = new FoliaLib(plugin);

        return foliaLib.getScheduler();
    }
}
