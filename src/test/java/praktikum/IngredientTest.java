package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class IngredientTest {

    @Test
    public void testGetters() {
        // Создаем mock для класса Ingredient
        Ingredient ingredient = mock(Ingredient.class);

        // Задаем поведение mock-объекта
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient.getName()).thenReturn("testSauce");
        when(ingredient.getPrice()).thenReturn(30.0F);

        // Проверяем методы
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("testSauce", ingredient.getName());
        assertEquals(30.0, ingredient.getPrice(), 0.001);
    }

    @Test
    public void testGettersAreCalled() {
        // Создаем spy для класса Ingredient и вызываем реальный конструктор
        Ingredient ingredient = spy(new Ingredient(IngredientType.SAUCE, "testSauce", 30.0F));

        // Вызываем методы, которые должны вызвать getType, getName и getPrice
        ingredient.getType();
        ingredient.getName();
        ingredient.getPrice();

        // Проверяем, что методы getType, getName и getPrice вызываются при создании объекта
        verify(ingredient, times(1)).getType();
        verify(ingredient, times(1)).getName();
        verify(ingredient, times(1)).getPrice();
    }
}


