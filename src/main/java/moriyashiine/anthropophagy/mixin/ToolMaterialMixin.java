/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import moriyashiine.anthropophagy.common.item.KnifeItem;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ToolMaterial.class)
public class ToolMaterialMixin {
	@ModifyReturnValue(method = "createSwordAttributeModifiers", at = @At("RETURN"))
	private AttributeModifiersComponent anthropophagy$applyKnifeSettings(AttributeModifiersComponent original) {
		if (KnifeItem.applyKnifeSettings) {
			return KnifeItem.appendKnifeAttributeModifiers(original);
		}
		return original;
	}
}
