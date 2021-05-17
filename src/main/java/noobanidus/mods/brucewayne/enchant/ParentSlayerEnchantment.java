package noobanidus.mods.brucewayne.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class ParentSlayerEnchantment extends Enchantment {
  public ParentSlayerEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
    super(rarityIn, typeIn, slots);
  }

  @Override
  public int getMaxLevel() {
    return 1;
  }
}
