package com.evo.candycraft.common.world;

import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class CandyWorldSurfaceRuleData {

	private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.AIR);
	private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
	private static final SurfaceRules.RuleSource TOFUSLATE = makeStateRule(CandyCraftBlocks.NOUGAT_SLATE.get());

	private static SurfaceRules.RuleSource makeStateRule(Block block) {
		return SurfaceRules.state(block.defaultBlockState());
	}

	public static SurfaceRules.RuleSource candyWorld() {
		return candyWorldLike();
	}

	public static SurfaceRules.RuleSource candyWorldLike() {
		ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();


		builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));


		builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), TOFUSLATE));

		return SurfaceRules.sequence(builder.build().toArray(new SurfaceRules.RuleSource[0]));
	}
}