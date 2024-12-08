package bun;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.IngredientType;

import java.util.Optional;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Bun1", 1},
                {null, 2},
                {"", -10},
                {"@!", 12345},
                {"white bun", 100},
        };
    }

    @Test
    public void getName(){
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        Assert.assertEquals(name, actual);
        System.out.println("expected:"+ name);
        System.out.println("actual:" + actual);
    }

    @Test
    public void getPrice(){
        Bun bun = new Bun(name, price);
        Float actual = bun.getPrice();
        Assert.assertEquals(Optional.of(price).get(), actual);
        System.out.println("expected:"+ price);
        System.out.println("actual:" + actual);


    }

}
