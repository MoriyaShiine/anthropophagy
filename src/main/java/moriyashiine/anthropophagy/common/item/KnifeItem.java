/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.item;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.component.entity.TetheredComponent;
import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import moriyashiine.anthropophagy.common.init.ModItems;
import moriyashiine.strawberrylib.api.objects.records.ModifierTrio;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.editModifiers;

public class KnifeItem extends Item {
	private static final EntityAttributeModifier ENTITY_INTERACTION_RANGE_MODIFIER = new EntityAttributeModifier(Anthropophagy.id("knife_interaction_range"), -0.5, EntityAttributeModifier.Operation.ADD_VALUE);
	private static final ModifierTrio MODIFIER = new ModifierTrio(EntityAttributes.ENTITY_INTERACTION_RANGE, ENTITY_INTERACTION_RANGE_MODIFIER, AttributeModifierSlot.MAINHAND);

	public KnifeItem(ToolMaterial toolMaterial, Settings settings) {
		super(editModifiers(() -> settings.sword(toolMaterial, 0, -2), MODIFIER));
	}

	@Override
	public ActionResult use(World world, PlayerEntity user, Hand hand) {
		if (user.isSneaking()) {
			user.attack(user);
			TetheredComponent tetheredComponent = ModEntityComponents.TETHERED.get(user);
			if (tetheredComponent.isTethered()) {
				tetheredComponent.setTethered(false);
				if (world instanceof ServerWorld serverWorld) {
					user.dropItem(serverWorld, ModItems.PIGLUTTON_HEART);
				}
			}
			return ActionResult.SUCCESS;
		}
		return super.use(world, user, hand);
	}
}
