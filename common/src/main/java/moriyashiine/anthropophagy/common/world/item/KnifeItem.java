package moriyashiine.anthropophagy.common.world.item;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.component.entity.CannibalComponent;
import moriyashiine.anthropophagy.common.init.AnthropophagyEntityComponents;
import moriyashiine.anthropophagy.common.init.AnthropophagyItems;
import moriyashiine.strawberrylib.api.module.SLibUtils;
import net.minecraft.core.component.DataComponents;
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

public class KnifeItem extends Item {
	private static final AttributeModifier ENTITY_INTERACTION_RANGE_MODIFIER = new AttributeModifier(Anthropophagy.id("knife_interaction_range"), -0.5, AttributeModifier.Operation.ADD_VALUE);

	public KnifeItem(ToolMaterial material, Properties properties) {
		super(properties.sword(material, 0, -2)
				.modifyComponent(DataComponents.ATTRIBUTE_MODIFIERS, (original, _, _) ->
						original.withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE, ENTITY_INTERACTION_RANGE_MODIFIER, EquipmentSlotGroup.MAINHAND)));
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		if (player.hurtTime == 0 && player.isShiftKeyDown()) {
			SLibUtils.runWithPvpBypass(() -> player.attack(player));
			CannibalComponent cannibal = AnthropophagyEntityComponents.CANNIBAL.get(player);
			if (cannibal.isTethered()) {
				cannibal.setTethered(false);
				if (level instanceof ServerLevel serverLevel) {
					player.spawnAtLocation(serverLevel, AnthropophagyItems.PIGLUTTON_HEART);
				}
			}
			return InteractionResult.SUCCESS;
		}
		return super.use(level, player, hand);
	}
}
