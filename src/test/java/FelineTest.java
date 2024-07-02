import org.junit.Test;
import org.junit.runner.RunWith;
import com.example.Feline;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {


    @Spy// создали мок
    private Feline feline = new Feline();

    @Test
    public void eatMeatTest() throws Exception { // сам тест
        List<String> actualResult = feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualResult);
    }

    @Test
    public void getFamilyTest() {
        String actual = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        assertEquals("Кошачьи", actual);
    }

    @Test
    public void getKittensTest() {
        int actual = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        assertEquals(1, actual);
    }

    @Test
    public void getKittensTest2() {
        int actual = feline.getKittens(5);
        Mockito.verify(feline, Mockito.times(1)).getKittens(5);
        assertEquals(5, actual);
    }

}
