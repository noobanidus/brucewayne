package noobanidus.mods.brucewayne.init;

import com.tterrag.registrate.providers.ProviderType;

import static noobanidus.mods.brucewayne.BruceWayne.REGISTRATE;

public class ModLang {
  static {
    REGISTRATE.addDataGenerator(ProviderType.LANG, ctx -> {
      ctx.add("enchantment.brucewayne.parent_slayer.desc", "Prevents baby animals and adults who can still breed from being harmed.");
    });
  }

  public static void load () {
  }
}
