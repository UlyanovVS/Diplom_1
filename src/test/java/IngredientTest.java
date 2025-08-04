import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    @Test
    public void testIngredientFields() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("hot sauce", ingredient.getName());
        assertEquals(100, ingredient.getPrice(), 0.001);
    }
}