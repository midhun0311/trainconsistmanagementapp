import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainAppUC8Test {

    private List<Bogie> getBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 72)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 80)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("General", 90),
                new Bogie("AC Chair", 56)
        );

        List<Bogie> result = list.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 100)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 80),
                new Bogie("B", 90)
        );

        List<Bogie> result = list.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        List<Bogie> result = list.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = getBogies();

        List<Bogie> result = original.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(3, original.size()); // original unchanged
    }
}
