package net.xanthian.beem_forge;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Initialise.MOD_ID)
@Mod.EventBusSubscriber
public class Initialise {

	public static final String MOD_ID = "beem_forge";

	public Initialise() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		modEventBus.addListener(this::registerRenders);

		MinecraftForge.EVENT_BUS.register(this);
	}


	@SubscribeEvent
	public void registerRenders(EntityRenderersEvent.RegisterRenderers event) {

		event.registerBlockEntityRenderer(BlockEntityType.BEEHIVE, d -> new BeeNestBlockEntityRenderer());
	}
}

