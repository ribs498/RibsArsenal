package top.ribs.ribsarsenal.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.ribs.ribsarsenal.Reference;
import top.ribs.scguns.item.GunItem;
public class ModItems {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);


    public static final RegistryObject<GunItem> KALASKAH = REGISTER.register("kalaskah", () -> new GunItem(new Item.Properties().stacksTo(1).durability(512)));
    public static final RegistryObject<GunItem> KILLER_23 = REGISTER.register("killer_23", () -> new GunItem(new Item.Properties().stacksTo(1).durability(512)));
    public static final RegistryObject<GunItem> TURNPIKE = REGISTER.register("turnpike", () -> new GunItem(new Item.Properties().stacksTo(1).durability(512)));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }


}
