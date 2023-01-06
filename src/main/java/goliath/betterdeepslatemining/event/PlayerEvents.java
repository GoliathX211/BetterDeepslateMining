package goliath.betterdeepslatemining.event;

import com.mojang.logging.LogUtils;
import goliath.betterdeepslatemining.BetterDeepslateMining;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockDestructionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

import java.util.Map;
import java.util.Optional;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = BetterDeepslateMining.MODID)
public class PlayerEvents {
    public static final Logger LOGGER = LogUtils.getLogger();
    @SubscribeEvent
    public static void changeBreakSpeed(PlayerEvent.BreakSpeed event) {
        Optional<BlockPos> optional = event.getPosition();
        if (optional.isEmpty()) return;
        BlockPos blockPos = optional.get();

        Player player = event.getEntity();
        Level level = player.getLevel();

        Block blockBroken = level.getBlockState(blockPos).getBlock();
        boolean isValidBlock = BetterDeepslateMining.VALID_BLOCKS.stream().anyMatch(block -> block.toString().equals(blockBroken.toString()));

        if (!isValidBlock) return;
        ItemStack usedItem = player.getItemInHand(player.getUsedItemHand());
        if (!usedItem.is(Items.NETHERITE_PICKAXE) || !usedItem.isEnchanted()) return;


        Map<Enchantment, Integer> mapped_enchantments = usedItem.getAllEnchantments();

        if (!mapped_enchantments.containsKey(Enchantments.BLOCK_EFFICIENCY)) return;
        if (mapped_enchantments.get(Enchantments.BLOCK_EFFICIENCY) < 5) return;

        event.setNewSpeed(event.getOriginalSpeed() * 2.5f);
        player.sendSystemMessage(Component.literal("New Speed: " + event.getNewSpeed()));

    }
    @SubscribeEvent
    public static void findBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        Level level = player.getLevel();
        Optional<BlockPos> optionalBlockPos = event.getPosition();
        if (optionalBlockPos.isEmpty()) {
            return;
        }
        LOGGER.info("Block: " + level.getBlockState(optionalBlockPos.get()).getBlock() + " | Original Speed: " + event.getOriginalSpeed());
        player.sendSystemMessage(Component.literal("Block: " + level.getBlockState(optionalBlockPos.get()).getBlock() + " | Speed: " + event.getOriginalSpeed()));
    }
}
