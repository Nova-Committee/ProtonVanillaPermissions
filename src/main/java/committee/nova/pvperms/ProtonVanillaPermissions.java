package committee.nova.pvperms;

import com.google.common.collect.ImmutableList;
import committee.nova.proton.Proton$;
import committee.nova.proton.core.player.storage.api.IProtonCapability;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod(modid = ProtonVanillaPermissions.MODID)
public class ProtonVanillaPermissions {
    public static final String MODID = "pvperms";

    public static final List<String> perms = ImmutableList.of(
            "worldborder", "setworldspawn", "whitelist",
            "deop", "enchant", "blockdata",
            "fill", "scoreboard", "setdimension",
            "setblock", "testforblocks", "gamemode",
            "defaultgamemode", "te", "entity",
            "summon", "execute", "teleport",
            "ban-ip", "pardon", "start",
            "pardon-ip", "entitydata", "title",
            "setidletimeout", "locate", "banlist",
            "testforblock", "recipe", "difficulty",
            "save-all", "tell", "me",
            "replaceitem", "stop", "debug",
            "give", "toggledownfall", "particle",
            "list", "seed", "reset",
            "dimensions", "advancement", "kick",
            "tp", "clone", "clear",
            "help", "generate", "weather",
            "stopsound", "op", "testfor",
            "tellraw", "reload", "ban",
            "trigger", "xp", "say",
            "save-off", "playsound", "spawnpoint",
            "forge", "track", "kill",
            "stats", "save-on", "tps",
            "effect", "gamerule", "spreadplayers",
            "function", "time"
    );

    public static List<String> getPermsPrefixed() {
        final List<String> nList = new ArrayList<>();
        for (String p : perms) nList.add("minecraft.cmd." + p);
        return nList;
    }

    public static boolean hasPermission(EntityPlayerMP player, String perm) {
        final IProtonCapability cap = player.getCapability(Proton$.MODULE$.protonCapability(), null);
        return (cap != null) && cap.hasPerm(perm);
    }
}
