package committee.nova.protonvp

import committee.nova.proton.implicits.PlayerImplicit
import committee.nova.protonvp.event.ForgeEventHandler
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import net.minecraft.entity.player.EntityPlayerMP
import org.apache.logging.log4j.LogManager

@Mod(modid = ProtonVanillaPermissions.MODID, useMetadata = true, modLanguage = "scala", acceptableRemoteVersions = "*")
object ProtonVanillaPermissions {
  final val LOGGER = LogManager.getLogger
  final val MODID = "protonvp"
  final val VANILLA = "minecraft"

  @EventHandler def preInit(e: FMLPreInitializationEvent): Unit = {}

  @EventHandler def init(e: FMLInitializationEvent): Unit = ForgeEventHandler.init()

  @EventHandler def postInit(e: FMLPostInitializationEvent): Unit = {}

  def hasPermission(player: EntityPlayerMP, perm: String): Boolean = player.hasPerm(perm)
}
