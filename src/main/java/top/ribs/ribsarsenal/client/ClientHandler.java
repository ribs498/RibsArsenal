package top.ribs.ribsarsenal.client;


import com.mrcrayfish.framework.api.client.FrameworkClientAPI;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.ribs.ribsarsenal.Reference;
import top.ribs.ribsarsenal.client.render.gun.model.KalaskahModel;
import top.ribs.ribsarsenal.client.render.gun.model.Killer23Model;
import top.ribs.ribsarsenal.client.render.gun.model.TurnpikeModel;
import top.ribs.ribsarsenal.init.ModItems;
import top.ribs.scguns.ScorchedGuns;
import top.ribs.scguns.client.GunButtonBindings;
import top.ribs.scguns.client.KeyBinds;
import top.ribs.scguns.client.MetaLoader;
import top.ribs.scguns.client.handler.*;
import top.ribs.scguns.client.render.block.*;
import top.ribs.scguns.client.render.curios.AmmoBoxRenderer;
import top.ribs.scguns.client.render.gun.ModelOverrides;
import top.ribs.scguns.client.screen.*;
import top.ribs.scguns.entity.client.*;
import top.ribs.scguns.init.ModBlockEntities;
import top.ribs.scguns.init.ModBlocks;
import top.ribs.scguns.init.ModEntities;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT)
public class ClientHandler {
    public static void registerClientHandlers(IEventBus bus) {
        FrameworkClientAPI.registerDataLoader(MetaLoader.getInstance());
        bus.addListener(ClientHandler::onClientSetup);
    }
    private static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(ClientHandler::setup);
    }
    public static void setup() {
        registerModelOverrides();
    }
    private static void registerModelOverrides() {
        ModelOverrides.register(ModItems.KALASKAH.get(), new KalaskahModel());
        ModelOverrides.register(ModItems.KILLER_23.get(), new Killer23Model());
        ModelOverrides.register(ModItems.TURNPIKE.get(), new TurnpikeModel());

    }

}
