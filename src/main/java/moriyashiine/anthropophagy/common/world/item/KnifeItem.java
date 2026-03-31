/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.world.item;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.component.entity.TetheredComponent;
import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import moriyashiine.anthropophagy.common.init.ModItems;
import moriyashiine.strawberrylib.api.module.SLibUtils;
import moriyashiine.strawberrylib.api.objects.records.ModifierTrio;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.editModifiers;

public class KnifeItem extends Item {
	private static final AttributeModifier ENTITY_INTERACTION_RANGE_MODIFIER = new AttributeModifier(Anthropophagy.id("knife_interaction_range"), -0.5, AttributeModifier.Operation.ADD_VALUE);
	private static final ModifierTrio MODIFIER = new ModifierTrio(Attributes.ENTITY_INTERACTION_RANGE, ENTITY_INTERACTION_RANGE_MODIFIER, EquipmentSlotGroup.MAINHAND);

	public KnifeItem(ToolMaterial material, Properties properties) {
		super(editModifiers(() -> properties.sword(material, 0, -2), MODIFIER));
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		if (player.hurtTime == 0 && player.isShiftKeyDown()) {
			SLibUtils.runWithPvpBypass(() -> player.attack(player));
			TetheredComponent tetheredComponent = ModEntityComponents.TETHERED.get(player);
			if (tetheredComponent.isTethered()) {
				tetheredComponent.setTethered(false);
				if (level instanceof ServerLevel serverLevel) {
					player.spawnAtLocation(serverLevel, ModItems.PIGLUTTON_HEART);
				}
			}
			return InteractionResult.SUCCESS;
		}
		return super.use(level, player, hand);
	}
}
