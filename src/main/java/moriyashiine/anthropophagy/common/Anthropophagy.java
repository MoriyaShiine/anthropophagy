/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common;

import eu.midnightdust.lib.config.MidnightConfig;
import moriyashiine.anthropophagy.common.event.CannibalEvent;
import moriyashiine.anthropophagy.common.event.DropFleshEvent;
import moriyashiine.anthropophagy.common.init.AnthropophagyDataComponents;
import moriyashiine.anthropophagy.common.init.AnthropophagyEntityTypes;
import moriyashiine.anthropophagy.common.init.AnthropophagyItems;
import moriyashiine.anthropophagy.common.init.AnthropophagySoundEvents;
import moriyashiine.anthropophagy.common.reloadlistener.FleshDropsReloadListener;
import moriyashiine.strawberrylib.api.SLib;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;

public class Anthropophagy implements ModInitializer {
	public static final String MOD_ID = "anthropophagy";

	@Override
	public void onInitialize() {
		MidnightConfig.init(MOD_ID, AnthropophagyConfig.class);
		SLib.init(MOD_ID);
		initRegistries();
		initEvents();
		ResourceLoader.get(PackType.SERVER_DATA).registerReloadListener(id("flesh_drops"), new FleshDropsReloadListener());
	}

	public static Identifier id(String value) {
		return Identifier.fromNamespaceAndPath(MOD_ID, value);
	}

	private void initRegistries() {
		AnthropophagyDataComponents.init();
		AnthropophagyEntityTypes.init();
		AnthropophagyItems.init();
		AnthropophagySoundEvents.init();
	}

	private void initEvents() {
		CannibalEvent.init();
		DropFleshEvent.init();
	}
}
