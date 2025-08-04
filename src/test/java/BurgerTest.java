import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BurgerTest {
    private Burger burger;
    private final Ingredient mockedIngredient;

    public BurgerTest(Ingredient mockedIngredient) {
        this.mockedIngredient = mockedIngredient;
    }

    @Parameterized.Parameters
    public static Object[] getIngredients() {
        Ingredient mock1 = Mockito.mock(Ingredient.class);
        Mockito.when(mock1.getName()).thenReturn("Hot Sauce");
        Mockito.when(mock1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(mock1.getPrice()).thenReturn(100f);

        Ingredient mock2 = Mockito.mock(Ingredient.class);
        Mockito.when(mock2.getName()).thenReturn("Cutlet");
        Mockito.when(mock2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mock2.getPrice()).thenReturn(200f);

        return new Object[]{mock1, mock2};
    }

    @Before
    public void setup() {
        burger = new Burger();
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(150f);
        burger.setBuns(bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockedIngredient);
        assertEquals(1, burger.ingredients.size());
    }

    private void assertEquals(int i, int size) {
    }

    @Test
    public void testGetPrice() {
        burger.addIngredient(mockedIngredient);
        float price = burger.getPrice();
        assertTrue(price >= 300);
    }

    @Test
    public void testGetReceipt() {
        burger.addIngredient(mockedIngredient);
        String receipt = burger.getReceipt();
        assertTrue(receipt.contains(mockedIngredient.getName()));
    }
}