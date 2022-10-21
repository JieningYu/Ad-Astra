package earth.terrarium.ad_astra.recipes;

import earth.terrarium.ad_astra.registry.ModRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.fluid.Fluid;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class OxygenConversionRecipe extends FluidConversionRecipe {

	public OxygenConversionRecipe(Identifier id, Fluid input, Fluid output, double conversionRatio) {
		super(id, input, output, conversionRatio);
	}

	public static Codec<OxygenConversionRecipe> oxygenCodec(Identifier id) {
		return RecordCodecBuilder.create(instance -> instance.group(
				RecordCodecBuilder.point(id),
				Registry.FLUID.getCodec().fieldOf("input").forGetter(ConversionRecipe::getFluidInput),
				Registry.FLUID.getCodec().fieldOf("output").forGetter(ConversionRecipe::getFluidOutput),
				Codec.DOUBLE.fieldOf("conversion_ratio").orElse(1.0).forGetter(ConversionRecipe::getConversionRatio)
		).apply(instance, OxygenConversionRecipe::new));
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ModRecipes.OXYGEN_CONVERSION_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return ModRecipes.OXYGEN_CONVERSION_RECIPE.get();
	}
}