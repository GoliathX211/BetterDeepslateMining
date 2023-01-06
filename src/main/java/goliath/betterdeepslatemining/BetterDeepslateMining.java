package goliath.betterdeepslatemining;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.ArrayList;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BetterDeepslateMining.MODID)
public class BetterDeepslateMining {
    public static final String MODID = "betterdeepslatemining";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static ArrayList<Block> VALID_BLOCKS = new ArrayList<>();
    static {
        VALID_BLOCKS.add(Blocks.DEEPSLATE);

        VALID_BLOCKS.add(Blocks.COBBLED_DEEPSLATE);
        VALID_BLOCKS.add(Blocks.COBBLED_DEEPSLATE_STAIRS);
        VALID_BLOCKS.add(Blocks.COBBLED_DEEPSLATE_SLAB);
        VALID_BLOCKS.add(Blocks.COBBLED_DEEPSLATE_WALL);

        VALID_BLOCKS.add(Blocks.POLISHED_DEEPSLATE);
        VALID_BLOCKS.add(Blocks.POLISHED_DEEPSLATE_STAIRS);
        VALID_BLOCKS.add(Blocks.POLISHED_DEEPSLATE_SLAB);
        VALID_BLOCKS.add(Blocks.POLISHED_DEEPSLATE_WALL);

        VALID_BLOCKS.add(Blocks.DEEPSLATE_TILES);
        VALID_BLOCKS.add(Blocks.DEEPSLATE_TILE_STAIRS);
        VALID_BLOCKS.add(Blocks.DEEPSLATE_TILE_SLAB);
        VALID_BLOCKS.add(Blocks.DEEPSLATE_TILE_WALL);

        VALID_BLOCKS.add(Blocks.DEEPSLATE_BRICKS);
        VALID_BLOCKS.add(Blocks.DEEPSLATE_BRICK_STAIRS);
        VALID_BLOCKS.add(Blocks.DEEPSLATE_BRICK_SLAB);
        VALID_BLOCKS.add(Blocks.DEEPSLATE_BRICK_WALL);

        VALID_BLOCKS.add(Blocks.CHISELED_DEEPSLATE);
        VALID_BLOCKS.add(Blocks.CRACKED_DEEPSLATE_BRICKS);
        VALID_BLOCKS.add(Blocks.CRACKED_DEEPSLATE_TILES);

        VALID_BLOCKS.add(Blocks.INFESTED_DEEPSLATE);

        VALID_BLOCKS.add(Blocks.DEEPSLATE_GOLD_ORE);
        VALID_BLOCKS.add(Blocks.DEEPSLATE_IRON_ORE);
        VALID_BLOCKS.add(Blocks.DEEPSLATE_COAL_ORE);
        VALID_BLOCKS.add(Blocks.DEEPSLATE_LAPIS_ORE);
        VALID_BLOCKS.add(Blocks.DEEPSLATE_DIAMOND_ORE);
        VALID_BLOCKS.add(Blocks.DEEPSLATE_REDSTONE_ORE);
        VALID_BLOCKS.add(Blocks.DEEPSLATE_EMERALD_ORE);
    }
    public BetterDeepslateMining() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
    }
}
