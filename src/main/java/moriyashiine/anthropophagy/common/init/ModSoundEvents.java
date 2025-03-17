/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.init;

import net.minecraft.sound.SoundEvent;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerSoundEvent;

public class ModSoundEvents {
	public static final SoundEvent ENTITY_PIGLUTTON_AMBIENT = registerSoundEvent("entity.piglutton.ambient");
	public static final SoundEvent ENTITY_PIGLUTTON_HURT = registerSoundEvent("entity.piglutton.hurt");
	public static final SoundEvent ENTITY_PIGLUTTON_DEATH = registerSoundEvent("entity.piglutton.death");
	public static final SoundEvent ENTITY_PIGLUTTON_SPAWN = registerSoundEvent("entity.piglutton.spawn");
	public static final SoundEvent ENTITY_PIGLUTTON_FLEE = registerSoundEvent("entity.piglutton.flee");

	public static void init() {
	}
}
