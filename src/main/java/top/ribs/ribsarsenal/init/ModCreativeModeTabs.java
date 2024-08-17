package top.ribs.ribsarsenal.init;


import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import top.ribs.ribsarsenal.Reference;
import top.ribs.scguns.item.GunItem;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RIBS_ARSENAL_TAB = CREATIVE_MODE_TABS.register("ribs_arsenal_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KALASKAH.get()))
                    .title(Component.translatable("creativetab.ribs_arsenal_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        CreativeTabHelper.addItemWithFullAmmo(pOutput,ModItems.KALASKAH.get());
                        CreativeTabHelper.addItemWithFullAmmo(pOutput,ModItems.TURNPIKE.get());
                        CreativeTabHelper.addItemWithFullAmmo(pOutput,ModItems.KILLER_23.get());

                     //   pOutput.accept(ModItems.ANTHRALITE_PICKAXE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
    public static class CreativeTabHelper {
        public static void addItemWithFullAmmo(CreativeModeTab.Output output, Item item) {
            if (item instanceof GunItem gunItem) {
                ItemStack stack = new ItemStack(gunItem);
                stack.getOrCreateTag().putInt("AmmoCount", gunItem.getGun().getReloads().getMaxAmmo());
                output.accept(stack);
            } else {
                output.accept(item);
            }
        }
    }

}