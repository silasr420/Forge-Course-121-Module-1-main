package net.silas.mccourse.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.silas.mccourse.fluid.ModFluids;
import net.silas.mccourse.villager.ModVillagers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.brewing.BrewingRecipeRegisterEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;
import net.silas.mccourse.MCCourseMod;
import net.silas.mccourse.block.ModBlocks;
import net.silas.mccourse.command.ReturnHomeCommand;
import net.silas.mccourse.command.SetHomeCommand;
import net.silas.mccourse.item.ModItems;
import net.silas.mccourse.item.custom.HammerItem;
import net.silas.mccourse.potion.ModPotions;
import net.silas.mccourse.villager.ModVillagers;

import java.util.*;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }

    }

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());

    }
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        event.getEntity().getPersistentData().putIntArray("mccourse.homepos",
                event.getOriginal().getPersistentData().getIntArray("mccourse.homepos"));
    }
    @SubscribeEvent
    public static void onBrewingRecipeRegister(BrewingRecipeRegisterEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, ModItems.ICE_STAFF.get(), ModPotions.FESTIVE_POTION.getHolder().get());
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.ONION.get(), 8),
                    new ItemStack(Items.EMERALD, 1), 12, 2, 0.025f
            ));
        }

        if(event.getType() == VillagerProfession.TOOLSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 4),
                    new ItemStack(ModItems.CHAINSAW.get(), 1), 10, 5, 0.025f
            ));
        }


        if(event.getType() == VillagerProfession.FLETCHER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModItems.TNT_ARROW.get(), 8), 10, 5, 0.025f
            ));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(ModItems.TNT_BOW.get(), 1), 10, 5, 0.025f
            ));
        }

        if(event.getType() == VillagerProfession.CLERIC) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 7),
                    new ItemStack(ModFluids.NETHER_FLUID_BUCKET.get(), 1), 8, 3, 0f
            ));
        }

        if(event.getType() == ModVillagers.BEEKEEPER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            List<Item> flowerList = Arrays.asList(Items.ALLIUM, Items.AZURE_BLUET, Items.BLUE_ORCHID, Items.CORNFLOWER, Items.DANDELION, Items.LILY_OF_THE_VALLEY,
                     Items.OXEYE_DAISY, Items.POPPY, Items.ORANGE_TULIP, Items.PINK_TULIP, Items.RED_TULIP, Items.WHITE_TULIP);

            Random r = new Random();
            Item flower = flowerList.get(r.nextInt(flowerList.size()));

            List<Item> waxedList = Arrays.asList(Items.WAXED_COPPER_BLOCK, Items.WAXED_WEATHERED_COPPER, Items.WAXED_EXPOSED_COPPER,
                    Items.WAXED_OXIDIZED_COPPER);


            Item waxed = waxedList.get(r.nextInt(waxedList.size()));

            List<Item> candleList = Arrays.asList(
                    Items.CANDLE,
                    Items.WHITE_CANDLE,
                    Items.ORANGE_CANDLE,
                    Items.MAGENTA_CANDLE,
                    Items.LIGHT_BLUE_CANDLE,
                    Items.YELLOW_CANDLE,
                    Items.LIME_CANDLE,
                    Items.PINK_CANDLE,
                    Items.GRAY_CANDLE,
                    Items.LIGHT_GRAY_CANDLE,
                    Items.CYAN_CANDLE,
                    Items.PURPLE_CANDLE,
                    Items.BLUE_CANDLE,
                    Items.BROWN_CANDLE,
                    Items.GREEN_CANDLE,
                    Items.RED_CANDLE,
                    Items.BLACK_CANDLE
            );


            Item candle = candleList.get(r.nextInt(candleList.size()));


            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.HONEYCOMB, 3),
                    new ItemStack(Items.EMERALD, 1), 10, 3, 0.025f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(Items.HONEY_BOTTLE, 1), 8, 3, 0.025f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(flower, 5),
                    new ItemStack(Items.EMERALD, 1), 8, 3, 0.025f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.BEE_NEST, 1),
                    new ItemStack(Items.EMERALD, 5), 12, 4, 0.025f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(Items.CAMPFIRE, 1), 18, 2, 0.5f
            ));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(Items.HONEY_BLOCK, 1), 18, 2, 0.5f
            ));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.STRING, 16),
                    new ItemStack(Items.EMERALD, 1), 12, 2, 0.5f
            ));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 8),
                    new ItemStack(Items.BEEHIVE, 1), 10, 6, 0.5f
            ));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 9),
                    new ItemStack(waxed, 1), 10, 4, 0.5f
            ));






            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 9),
                    new ItemStack(candle, 1), 14, 4, 0.5f
            ));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 4),
                    new ItemStack(Items.FLOWER_POT, 1), 14, 4, 0.5f
            ));



        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModBlocks.BLUEBELL.get(), 1), 3, 3, 0.02f
        ));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.ONION_SEEDS.get(), 1), 3, 3, 0.02f
        ));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 5),
                new ItemStack(ModItems.RAW_AZURITE.get(), 3), 4, 3, 0.02f
        ));


    }
}
