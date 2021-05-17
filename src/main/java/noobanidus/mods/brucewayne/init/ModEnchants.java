package noobanidus.mods.brucewayne.init;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import noobanidus.mods.brucewayne.enchant.ParentSlayerEnchantment;

import static noobanidus.mods.brucewayne.BruceWayne.REGISTRATE;

public class ModEnchants {
  public static final RegistryEntry<ParentSlayerEnchantment> PARENT_SLAYER = REGISTRATE.object("parent_slayer").enchantment(EnchantmentType.WEAPON, ParentSlayerEnchantment::new).addSlots(EquipmentSlotType.MAINHAND).rarity(Enchantment.Rarity.COMMON).register();

  public static void load () {
  }
}
