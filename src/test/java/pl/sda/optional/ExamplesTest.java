package pl.sda.optional;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Optional;

public class ExamplesTest {
    @Test
    public void whenCreateEmptyOptional_thenReturnFalse() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    public void givenNonNull() {
        String name = "Celinka";
        Optional<String> optional = Optional.of(name);
        assertEquals("Optional[Celinka]", optional.toString());
    }

    @Test(expected = NullPointerException.class)
    public void givenNull_whenErrorOnCreate_thenCorrect() {
        //nie można tworzyć optionala który jest nullem
        String name = null;
        Optional<String> optional = Optional.of(name);
    }
    @Test
    public void givenNull_whenCreateNullable_thenCorrect() {
        String name = null;
        Optional<String> optional = Optional.ofNullable(name);
        assertEquals("Optional.empty", optional.toString());

    }

    @Test
    public void givenOptional_whenIfPresent_thenCorrect() {
        Optional<String> name = Optional.ofNullable("Fryderyczek");
        name.ifPresent(nm -> System.out.println("Witaj: " + nm));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenOrElse_thenCorrect() {
        String name = null;
       // String nameGood = Optional.ofNullable(name).orElse("Henryczek");
        String nameException =
                Optional.ofNullable(name).orElseThrow(() -> new IllegalArgumentException()); //lambda style
        String nameException2 =
                Optional.ofNullable(name).orElseThrow(IllegalArgumentException::new); //referencja
        Optional<String> opt = Optional.of("Wartość");
        opt.get();
        System.out.println(opt);
       // assertEquals();
    }


}