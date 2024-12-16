package burger;

import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BurgerTest {

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("black bun", 300);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        String actual = burger.getReceipt();
        String expected = "(==== black bun ====)\r\n= filling cutlet =\r\n(==== black bun ====)\r\n\r\nPrice: 700,000000\r\n";
        assertThat(actual, equalTo(expected));

    }
}
