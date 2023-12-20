package committee.nova.pvperms.event;

import committee.nova.proton.core.event.impl.ProtonPermNodeInitializationEvent;
import committee.nova.pvperms.ProtonVanillaPermissions;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.collection.JavaConverters;

@Mod.EventBusSubscriber
public class ForgeEventHandler {
    @SubscribeEvent
    public static void onPermInit(ProtonPermNodeInitializationEvent event) {
        event.addNodeFromString(JavaConverters.asScalaIteratorConverter(ProtonVanillaPermissions.getPermsPrefixed().iterator()).asScala().toSeq());
    }
}
