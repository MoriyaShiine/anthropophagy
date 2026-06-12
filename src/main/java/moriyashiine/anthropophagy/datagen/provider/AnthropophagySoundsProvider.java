/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.datagen.provider;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.init.AnthropophagySoundEvents;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvents;

import java.util.concurrent.CompletableFuture;

import static net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder.RegistrationBuilder.ofEvent;
import static net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder.of;

public class AnthropophagySoundsProvider extends FabricSoundsProvider {
	public AnthropophagySoundsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(HolderLookup.Provider registries, SoundExporter exporter) {
		exporter.add(AnthropophagySoundEvents.PIGLUTTON_AMBIENT, of().subtitle("subtitles.anthropophagy.entity.piglutton.ambient")
				.sound(ofEvent(SoundEvents.HOGLIN_AMBIENT)));
		exporter.add(AnthropophagySoundEvents.PIGLUTTON_HURT, of().subtitle("subtitles.anthropophagy.entity.piglutton.hurt")
				.sound(ofEvent(SoundEvents.HOGLIN_HURT)));
		exporter.add(AnthropophagySoundEvents.PIGLUTTON_DEATH, of().subtitle("subtitles.anthropophagy.entity.piglutton.death")
				.sound(ofEvent(SoundEvents.HOGLIN_DEATH)));
		exporter.add(AnthropophagySoundEvents.PIGLUTTON_SPAWN, of().subtitle("subtitles.anthropophagy.entity.piglutton.spawn")
				.sound(ofEvent(SoundEvents.HOGLIN_CONVERTED_TO_ZOMBIFIED)));
	}

	@Override
	public String getName() {
		return Anthropophagy.MOD_ID + "_sounds";
	}
}
