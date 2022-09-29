package com.koolade446.mc120.registries;

import com.koolade446.mc120.MC120;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Registry {
    public static final Map<String, RegistryObject<?>> registeredObjects = new HashMap<>();

    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, MC120.MODID);
    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, MC120.MODID);

    public static void init() {
        ITEM.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCK.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Register stuff here

}
