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

    @Mock
    private Ingredient ingredient2;

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
        burger.addIngredient(ingredient);
        assertThat(burger.ingredients.size(), equalTo(1));
        burger.removeIngredient(0);
        assertThat(burger.ingredients.size(), equalTo(0));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        System.out.println(burger.ingredients);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        System.out.println(burger.ingredients);
        burger.moveIngredient(0, 1);
        System.out.println(burger.ingredients);
        assertThat(burger.ingredients.get(0), equalTo(ingredient2));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        float actual = burger.getPrice();
        assertThat(actual, equalTo(300F));
    }
}
