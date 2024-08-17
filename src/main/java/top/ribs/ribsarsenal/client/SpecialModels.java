package top.ribs.ribsarsenal.client;


import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.ribs.ribsarsenal.Reference;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public enum SpecialModels {

/// KALASKAH
    KALASKAH_MAIN("kalaskah/main"),
    KALASKAH_BOLT("kalaskah/bolt"),
    KALASKAH_STOCK_LIGHT("kalaskah/stock_light"),
    KALASKAH_STOCK_WEIGHTED("kalaskah/stock_weighted"),
    KALASKAH_STOCK_WOODEN("kalaskah/stock_wooden"),
    KALASKAH_SILENCER("kalaskah/silencer"),
    KALASKAH_ADVANCED_SILENCER("kalaskah/advanced_silencer"),
    KALASKAH_MUZZLE_BRAKE("kalaskah/muzzle_brake"),
    KALASKAH_VERTICAL_GRIP("kalaskah/vertical_grip"),
    KALASKAH_LIGHT_GRIP("kalaskah/light_grip"),
    KALASKAH_IRON_BAYONET("kalaskah/iron_bayonet"),
    KALASKAH_ANTHRALITE_BAYONET("kalaskah/anthralite_bayonet"),
    KALASKAH_DIAMOND_BAYONET("kalaskah/diamond_bayonet"),
    KALASKAH_NETHERITE_BAYONET("kalaskah/netherite_bayonet"),
    KALASKAH_STANDARD_MAG("kalaskah/stan_mag"),
    KALASKAH_EXTENDED_MAG("kalaskah/ext_mag"),
    KALASKAH_SPEED_MAG("kalaskah/speed_mag"),
    KALASKAH_SIGHTS("kalaskah/sights"),
    KALASKAH_NO_SIGHTS("kalaskah/no_sights"),
    /// TURNPIKE
    TURNPIKE_MAIN("turnpike/main"),
    TURNPIKE_BOLT("turnpike/bolt"),
    TURNPIKE_STOCK_LIGHT("turnpike/stock_light"),
    TURNPIKE_STOCK_WEIGHTED("turnpike/stock_weighted"),
    TURNPIKE_STOCK_WOODEN("turnpike/stock_wooden"),
    TURNPIKE_SILENCER("turnpike/silencer"),
    TURNPIKE_ADVANCED_SILENCER("turnpike/advanced_silencer"),
    TURNPIKE_MUZZLE_BRAKE("turnpike/muzzle_brake"),
    TURNPIKE_VERTICAL_GRIP("turnpike/tact_grip"),
    TURNPIKE_LIGHT_GRIP("turnpike/light_grip"),
    TURNPIKE_IRON_BAYONET("turnpike/iron_bayonet"),
    TURNPIKE_ANTHRALITE_BAYONET("turnpike/anthralite_bayonet"),
    TURNPIKE_DIAMOND_BAYONET("turnpike/diamond_bayonet"),
    TURNPIKE_NETHERITE_BAYONET("turnpike/netherite_bayonet"),
    TURNPIKE_SIGHTS("turnpike/sights"),
    TURNPIKE_NO_SIGHTS("turnpike/no_sights"),
    /// KILLER_23
    KILLER_23_MAIN("killer_23/main"),
    KILLER_23_BOLT("killer_23/bolt"),
    KILLER_23_STOCK_LIGHT("killer_23/stock_light"),
    KILLER_23_STOCK_WEIGHTED("killer_23/stock_weighted"),
    KILLER_23_STOCK_WOODEN("killer_23/stock_wooden"),
    KILLER_23_SILENCER("killer_23/silencer"),
    KILLER_23_ADVANCED_SILENCER("killer_23/advanced_silencer"),
    KILLER_23_MUZZLE_BRAKE("killer_23/muzzle_brake"),
    KILLER_23_VERTICAL_GRIP("killer_23/tact_grip"),
    KILLER_23_LIGHT_GRIP("killer_23/light_grip"),
    KILLER_23_IRON_BAYONET("killer_23/iron_bayonet"),
    KILLER_23_ANTHRALITE_BAYONET("killer_23/anthralite_bayonet"),
    KILLER_23_DIAMOND_BAYONET("killer_23/diamond_bayonet"),
    KILLER_23_NETHERITE_BAYONET("killer_23/netherite_bayonet")

    ;
    /**
     * The location of an item model in the [MOD_ID]/models/special/[NAME] folder
     */
    private final ResourceLocation modelLocation;

    /**
     * Cached model
     */
    private BakedModel cachedModel;

    /**
     * Sets the model's location
     *
     * @param modelName name of the model file
     */
    SpecialModels(String modelName)
    {
        this.modelLocation = new ResourceLocation(Reference.MOD_ID, "special/" + modelName);
    }

    /**
     * Gets the model
     *
     * @return isolated model
     */
    public BakedModel getModel()
    {
        if(this.cachedModel == null)
        {
            this.cachedModel = Minecraft.getInstance().getModelManager().getModel(this.modelLocation);
        }
        return this.cachedModel;
    }

    /**
     * Registers the special models into the Forge Model Bakery. This is only called once on the
     * load of the game.
     */
    @SubscribeEvent
    public static void registerAdditional(ModelEvent.RegisterAdditional event)
    {
        for(SpecialModels model : values())
        {
            event.register(model.modelLocation);
        }
    }

    /**
     * Clears the cached BakedModel since it's been rebuilt. This is needed since the models may
     * have changed when a resource pack was applied, or if resources are reloaded.
     */
    @SubscribeEvent
    public static void onBake(ModelEvent.BakingCompleted event)
    {
        for(SpecialModels model : values())
        {
            model.cachedModel = null;
        }
    }
}