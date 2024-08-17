package top.ribs.ribsarsenal;



import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.ribs.ribsarsenal.init.ModCreativeModeTabs;
import top.ribs.ribsarsenal.client.ClientHandler;
import top.ribs.ribsarsenal.init.ModItems;
import top.ribs.scguns.common.GripType;

import static top.ribs.ribsarsenal.Reference.MOD_ID;

@Mod(MOD_ID)
    public class RibsArsenal {

        public RibsArsenal() {
            IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
            ModCreativeModeTabs.register(bus);
            ModItems.REGISTER.register(bus);
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                ClientHandler.registerClientHandlers(bus);
            });
        }
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
        });
    }
        public static boolean isDebugging() {
            return false;
        }
    }

