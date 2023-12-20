package committee.nova.pvperms.mixin;

import committee.nova.pvperms.ProtonVanillaPermissions;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CommandBase.class)
public abstract class MixinCommandBase implements ICommand {
    @Inject(method = "checkPermission", at = @At("HEAD"), cancellable = true)
    private void inject$checkPermission(MinecraftServer server, ICommandSender sender, CallbackInfoReturnable<Boolean> cir) {
        if (!(sender instanceof EntityPlayerMP)) return;
        final String name = getName();
        if (ProtonVanillaPermissions.perms.contains(name))
            cir.setReturnValue(ProtonVanillaPermissions.hasPermission((EntityPlayerMP) sender, "minecraft.cmd." + name));
    }
}
