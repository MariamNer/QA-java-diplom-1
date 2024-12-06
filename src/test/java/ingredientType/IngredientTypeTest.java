package ingredientType;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;
    public IngredientTypeTest(IngredientType ingredientType){
        this.ingredientType = ingredientType;
    }


    @Parameterized.Parameters
    public static Object[][] getIngredientTypes() {
        return new Object[][]{
                {IngredientType.FILLING},
                {IngredientType.SAUCE},
        };
    }

    @Test
    public void getIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(ingredientType, "white bun", 200);
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(ingredientType, actual);
        System.out.println("expected:"+ ingredientType);
        System.out.println("actual:" + actual);
    }
}
