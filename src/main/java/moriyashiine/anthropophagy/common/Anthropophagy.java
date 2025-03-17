/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common;

import eu.midnightdust.lib.config.MidnightConfig;
import moriyashiine.anthropophagy.common.event.*;
import moriyashiine.anthropophagy.common.init.ModComponentTypes;
import moriyashiine.anthropophagy.common.init.ModEntityTypes;
import moriyashiine.anthropophagy.common.init.ModItems;
import moriyashiine.anthropophagy.common.init.ModSoundEvents;
import moriyashiine.anthropophagy.common.reloadlisteners.FleshDropsReloadListener;
import moriyashiine.strawberrylib.api.SLib;
import moriyashiine.strawberrylib.api.event.EatFoodEvent;
import moriyashiine.strawberrylib.api.event.ModifyJumpVelocityEvent;
import moriyashiine.strawberrylib.api.event.PreventEquipmentUsageEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Anthropophagy implements ModInitializer {
	public static final String MOD_ID = "anthropophagy";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		MidnightConfig.init(MOD_ID, ModConfig.class);
		SLib.init(MOD_ID);
		initRegistries();
		initEvents();
		ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new FleshDropsReloadListener());
	}

	public static Identifier id(String value) {
		return Identifier.of(MOD_ID, value);
	}

	private void initRegistries() {
		ModComponentTypes.init();
		ModEntityTypes.init();
		ModItems.init();
		ModSoundEvents.init();
	}

	private void initEvents() {
		ServerLivingEntityEvents.ALLOW_DAMAGE.register(new DropFleshEvent());
		PreventEquipmentUsageEvent.EVENT.register(new CannibalEquipmentEvent());
		ModifyJumpVelocityEvent.EVENT.register(new CannibalJumpBoostEvent());
		EatFoodEvent.EVENT.register(new CannibalEatingEvent());
		ServerPlayerEvents.COPY_FROM.register(new CopyCannibalLevelEvent());
		EntitySleepEvents.ALLOW_SLEEPING.register(new CannibalSleepEvent());
	}
}
