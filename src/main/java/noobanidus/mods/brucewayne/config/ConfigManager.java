package noobanidus.mods.brucewayne.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

import java.nio.file.Path;

public class ConfigManager {
  private static ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

  public static ForgeConfigSpec COMMON_CONFIG;

  private static ForgeConfigSpec.BooleanValue EXCLUDE_UNBRED;
  private static int exclude_unbred = -1;

  static {
    COMMON_BUILDER.push("general");
    EXCLUDE_UNBRED = COMMON_BUILDER.define("if enabled, adult entities able to breed are also excluded", true);
    COMMON_BUILDER.pop();
    COMMON_CONFIG = COMMON_BUILDER.build();
  }

  public static boolean getExcludeUnbred () {
    if (exclude_unbred == -1) {
      exclude_unbred = EXCLUDE_UNBRED.get() ? 1 : 0;
    }
    return exclude_unbred == 1;
  }

  public static void loadConfig(ForgeConfigSpec spec, Path path) {
    CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
    configData.load();
    spec.setConfig(configData);
  }

  public static void configLoaded(ModConfig.Loading event) {
    reset(event.getConfig());
  }

  public static void configReloaded(ModConfig.Reloading event) {
    reset(event.getConfig());
  }

  public static void reset(ModConfig config) {
    COMMON_CONFIG.setConfig(config.getConfigData());
    exclude_unbred = -1;
  }
}
