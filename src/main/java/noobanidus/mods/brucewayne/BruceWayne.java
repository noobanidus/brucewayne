package noobanidus.mods.brucewayne;


import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import noobanidus.libs.noobutil.registrate.CustomRegistrate;
import noobanidus.mods.brucewayne.config.ConfigManager;
import noobanidus.mods.brucewayne.init.ModEnchants;
import noobanidus.mods.brucewayne.init.ModLang;
import noobanidus.mods.brucewayne.setup.ClientInit;
import noobanidus.mods.brucewayne.setup.CommonSetup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("brucewayne")
public class BruceWayne {
  public static final Logger LOG = LogManager.getLogger();
  public static final String MODID = "brucewayne";

  public static CustomRegistrate REGISTRATE;

  public BruceWayne() {
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigManager.COMMON_CONFIG);
    ConfigManager.loadConfig(ConfigManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(BruceWayne.MODID + "-common.toml"));
    IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
    modBus.addListener(CommonSetup::init);

    DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientInit::init);

    modBus.addListener(ConfigManager::configLoaded);
    modBus.addListener(ConfigManager::configReloaded);

    REGISTRATE = CustomRegistrate.create(MODID);
    ModLang.load();
    ModEnchants.load();
  }
}
