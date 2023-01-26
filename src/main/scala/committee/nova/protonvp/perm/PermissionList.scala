package committee.nova.protonvp.perm

import com.google.common.collect.ImmutableList

import java.util.{List => JList}

object PermissionList {
  final val VANILLA: JList[String] = ImmutableList.of(
    "kick", "setworldspawn", "whitelist", "help", "clear",
    "weather", "deop", "op", "forge", "tellraw",
    "enchant", "scoreboard", "ban", "setblock", "xp",
    "gamemode", "defaultgamemode", "say", "save-off", "playsound",
    "spawnpoint", "summon", "kill", "tp", "ban-ip",
    "pardon", "pardon-ip", "setidletimeout", "save-on", "effect",
    "banlist", "testforblock", "gamerule", "difficulty", "save-all",
    "spreadplayers", "tell", "me", "time", "publish",
    "stop", "debug", "give", "toggledownfall", "list",
    "achievement", "seed"
  )
}
