/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.init;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
	public static final FoodProperties FLESH = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).build();
	public static final FoodProperties COOKED_FLESH = new FoodProperties.Builder().nutrition(8).saturationModifier(0.8F).build();
	public static final FoodProperties CORRUPT_FLESH = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).build();
	public static final FoodProperties TETHERED_HEART = new FoodProperties.Builder().nutrition(8).saturationModifier(0.8F).alwaysEdible().build();
}
