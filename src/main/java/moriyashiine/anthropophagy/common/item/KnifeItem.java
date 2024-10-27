/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.item;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.component.entity.TetheredComponent;
import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import moriyashiine.anthropophagy.common.init.ModItems;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class KnifeItem extends SwordItem {
	public static boolean applyKnifeSettings = false;

	public static final EntityAttributeModifier ENTITY_INTERACTION_RANGE_MODIFIER = new EntityAttributeModifier(Anthropophagy.id("knife_interaction_range"), -0.5, EntityAttributeModifier.Operation.ADD_VALUE);

	public KnifeItem(ToolMaterial toolMaterial, Settings settings) {
		super(toolMaterial, 0, -2, settings);
	}

	public static AttributeModifiersComponent appendKnifeAttributeModifiers(AttributeModifiersComponent original) {
		AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();
		original.modifiers().forEach(entry -> builder.add(entry.attribute(), entry.modifier(), entry.slot()));
		builder.add(EntityAttributes.ENTITY_INTERACTION_RANGE, KnifeItem.ENTITY_INTERACTION_RANGE_MODIFIER, AttributeModifierSlot.MAINHAND);
		return builder.build();
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
