package top.ribs.ribsarsenal;

import net.minecraft.resources.ResourceLocation;

public class Reference
{
	public static final String MOD_ID = "ribsarsenal";

    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
