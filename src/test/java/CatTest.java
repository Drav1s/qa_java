import org.junit.Test;
import org.junit.runner.RunWith;
import com.example.Feline;
import com.example.Cat;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Spy
    Feline feline;

    @Test
    public void getSoundTest() {
        Cat predator = new Cat(feline);
        String actual = predator.getSound();
        assertEquals("Мяу", actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat predator = new Cat(feline);
        List<String> actualResult = predator.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualResult);
    }

}
