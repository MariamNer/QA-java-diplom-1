package ingredient;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class IngredientTest {

    String name = "chili sauce";
    float price = 200;
    IngredientType type = FILLING;

    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(type,name,price);
        assertEquals(name,ingredient.getName());
    }

    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(type,name,price);
        assertEquals(price,ingredient.getPrice(), 0.001);
    }

    @Test
    public void getTypeTest(){
        Ingredient ingredient = new Ingredient(type,name,price);
        assertEquals(type,ingredient.getType());
    }

}
