import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.example.Feline;
import org.junit.runners.Parameterized;
import com.example.Lion;
import org.mockito.Mockito;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    private Feline feline;
    private Lion lion;
    private final String sex;
    private boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Test
    public void testPassedLionSex() throws Exception {

        lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(hasMane, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        Feline feline = Mockito.spy(Feline.class);
        Lion lion = new Lion(sex, feline);

        List<String> expected= List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, lion.getFood());
    }

    @Test
    public void getKittensTest() throws Exception {
        Feline feline = Mockito.spy(Feline.class);
        Lion lion = new Lion(sex, feline);

        lion.getKittens();
        Mockito.verify(feline).getKittens();
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveManeExceptionTest() throws Exception {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Нет пола", feline);
        });
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }


}
