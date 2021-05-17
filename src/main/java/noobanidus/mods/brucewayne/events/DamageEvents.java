package noobanidus.mods.brucewayne.events;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import noobanidus.mods.brucewayne.BruceWayne;
import noobanidus.mods.brucewayne.config.ConfigManager;
import noobanidus.mods.brucewayne.init.ModEnchants;

@Mod.EventBusSubscriber(modid = BruceWayne.MODID)
public class DamageEvents {
  @SubscribeEvent
  public static void onDamage(LivingAttackEvent event) {
    if (event.getEntity() instanceof AnimalEntity) {
      AnimalEntity animal = (AnimalEntity) event.getEntity();
      if (animal.isChild() || (ConfigManager.getExcludeUnbred() && !animal.isChild() && animal.getGrowingAge() == 0 && animal.canFallInLove())) {
        Entity trueSource = event.getSource().getTrueSource();
        if (trueSource instanceof LivingEntity) {
          LivingEntity entity = (LivingEntity) trueSource;
          if (EnchantmentHelper.getEnchantmentLevel(ModEnchants.PARENT_SLAYER.get(), entity.getHeldItemMainhand()) != 0) {
            event.setCanceled(true);
          }
        }
      }
    }
  }
}
