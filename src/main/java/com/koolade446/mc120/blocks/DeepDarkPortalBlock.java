package com.koolade446.mc120.blocks;

import com.koolade446.mc120.packethandeling.PacketHandler;
import com.koolade446.mc120.packethandeling.PlayerPortalCoolDownS2C;
import com.koolade446.mc120.packethandeling.PlayerPortalPositionS2C;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Timer;
import java.util.TimerTask;

public class DeepDarkPortalBlock extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);


    public DeepDarkPortalBlock() {
        super(BlockBehaviour.Properties.of(Material.PORTAL)
                .noCollission()
                .noOcclusion()
                .noLootTable()
                .lightLevel((state) -> 3)
                .sound(SoundType.GLASS)
                .strength(0f, 0f)
                .isValidSpawn((state, getter, pos, type) -> false)
                .destroyTime(-1f)
                .isSuffocating((state, getter, pos)-> false));
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        if (p_60555_.getValue(AXIS) == Direction.Axis.Z) {
            return Z_AXIS_AABB;
        }
        return X_AXIS_AABB;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return ItemStack.EMPTY;
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (level instanceof ServerLevel && entity instanceof ServerPlayer player) {
            int waitTime = entity.getPortalWaitTime();
            MinecraftServer MCServer = level.getServer();
            PacketHandler.sendToPlayer(new PlayerPortalPositionS2C(true), player);
            PacketHandler.sendToPlayer(new PlayerPortalCoolDownS2C(System.currentTimeMillis() + 100), player);
            Timer timer = new Timer();
            //TODO: Make dimension teleportation happen once it's added
        }
    }
}
