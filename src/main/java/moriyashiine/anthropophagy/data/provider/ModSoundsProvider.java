/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.data.provider;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.init.ModSoundEvents;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.minecraft.data.DataOutput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundEvents;

import java.util.concurrent.CompletableFuture;

import static net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder.EntryBuilder.ofEvent;
import static net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder.of;

public class ModSoundsProvider extends FabricSoundsProvider {
	public ModSoundsProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, SoundExporter exporter) {
		exporter.add(ModSoundEvents.ENTITY_PIGLUTTON_AMBIENT, of().subtitle("subtitles.anthropophagy.entity.piglutton.ambient")
				.sound(ofEvent(SoundEvents.ENTITY_HOGLIN_AMBIENT)));
		exporter.add(ModSoundEvents.ENTITY_PIGLUTTON_HURT, of().subtitle("subtitles.anthropophagy.entity.piglutton.hurt")
				.sound(ofEvent(SoundEvents.ENTITY_HOGLIN_HURT)));
		exporter.add(ModSoundEvents.ENTITY_PIGLUTTON_DEATH, of().subtitle("subtitles.anthropophagy.entity.piglutton.death")
				.sound(ofEvent(SoundEvents.ENTITY_HOGLIN_DEATH)));
		exporter.add(ModSoundEvents.ENTITY_PIGLUTTON_SPAWN, of().subtitle("subtitles.anthropophagy.entity.piglutton.spawn")
				.sound(ofEvent(SoundEvents.ENTITY_HOGLIN_CONVERTED_TO_ZOMBIFIED)));
		exporter.add(ModSoundEvents.ENTITY_PIGLUTTON_FLEE, of().subtitle("subtitles.anthropophagy.entity.piglutton.flee")
				.sound(ofEvent(SoundEvents.ENTITY_PIGLIN_RETREAT)));
	}

	@Override
	public String getName() {
		return Anthropophagy.MOD_ID + "_sounds";
	}
}
