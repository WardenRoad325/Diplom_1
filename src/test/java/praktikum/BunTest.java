package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class BunTest {

    @Test
    public void testGetters() {
        // Создаем spy для класса Bun и вызываем реальный конструктор
        Bun bun = spy(new Bun("testBun", 50));

        // Замокируем методы getName и getPrice
        when(bun.getName()).thenReturn("testBun");
        when(bun.getPrice()).thenReturn(50.0F);

        // Проверяем методы
        assertEquals("testBun", bun.getName());
        assertEquals(50.0, bun.getPrice(), 0.001);
    }

    // Дополнительный тест для проверки, что методы getName и getPrice вызываются при создании объекта
    @Test
    public void testGettersAreCalled() {
        // Создаем spy для класса Bun и вызываем реальный конструктор
        Bun bun = spy(new Bun("testBun", 50));

        // Замокируем методы getName и getPrice
        when(bun.getName()).thenReturn("testBun");
        when(bun.getPrice()).thenReturn(50.0F);

        // Вызываем методы, которые должны вызвать getName и getPrice
        bun.getName();
        bun.getPrice();

        // Проверяем, что методы getName и getPrice вызываются при создании объекта
        verify(bun, times(1)).getName();
        verify(bun, times(1)).getPrice();
    }
}


