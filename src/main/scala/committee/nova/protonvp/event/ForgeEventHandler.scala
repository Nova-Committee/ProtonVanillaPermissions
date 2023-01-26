package committee.nova.protonvp.event

import committee.nova.proton.core.event.impl.ProtonPermNodeInitializationEvent
import committee.nova.protonvp.perm.PermissionList
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.common.MinecraftForge

import scala.collection.JavaConversions._

object ForgeEventHandler {
  def init(): Unit = MinecraftForge.EVENT_BUS.register(new ForgeEventHandler)
}

class ForgeEventHandler {
  @SubscribeEvent
  def onPermInit(event: ProtonPermNodeInitializationEvent): Unit = for (n <- PermissionList.VANILLA) event.addNodeFromString(s"minecraft.cmd.$n")
}
