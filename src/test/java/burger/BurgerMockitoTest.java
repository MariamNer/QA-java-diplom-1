package burger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockitoTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        assertThat(burger.bun, equalTo(null));
        burger.setBuns(bun);
        assertThat(burger.bun, equalTo(bun));
    }

    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertThat(burger.ingredients.size(), equalTo(1));

    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.removeIngredient(0);
        Mockito.verify(burger).removeIngredient(0);
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.moveIngredient(0, 1);
        Mockito.verify(burger).moveIngredient(0, 1);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        float actual = burger.getPrice();
        assertThat( actual, equalTo(300F));
    }
}
