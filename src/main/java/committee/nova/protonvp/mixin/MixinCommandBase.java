package committee.nova.protonvp.mixin;

import committee.nova.protonvp.ProtonVanillaPermissions$;
import committee.nova.protonvp.perm.PermissionList$;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CommandBase.class)
public abstract class MixinCommandBase implements ICommand {
    @Inject(method = "canCommandSenderUseCommand", at = @At("HEAD"), cancellable = true)
    private void inject$canCommandSenderUseCommand(ICommandSender sender, CallbackInfoReturnable<Boolean> cir) {
        if (!(sender instanceof EntityPlayerMP)) return;
        final String name = getCommandName();
        if (PermissionList$.MODULE$.VANILLA().contains(name) && ProtonVanillaPermissions$.MODULE$.hasPermission((EntityPlayerMP) sender, "minecraft.cmd." + name))
            cir.setReturnValue(true);
    }
}
