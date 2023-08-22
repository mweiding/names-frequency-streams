import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class AnalyzerTest {

    @Test
    public void getMostFrequentName() throws IOException {
        Map.Entry<String, Integer> entry = new AbstractMap.SimpleEntry<>("Sheronda", 13);
        NamesReader reader = new NamesReader("testNames.txt");
        Analyzer analyze = new Analyzer(reader);
        assertEquals(entry, analyze.getMostFrequentName(Gender.Female));
    }

    @Test
    public void getAllNames() throws IOException {
        List<String> names = new ArrayList<>();
        names.add("Rosann");
        names.add("Roshunda");
        names.add("Sabina");
        names.add("Samara");
        names.add("Sammi");
        names.add("Sana");
        names.add("Santos");
        names.add("Sarina");
        names.add("Sergio");
        names.add("Shandy");
        names.add("Shanique");
        names.add("Shante");
        names.add("Sheronda");
        names.add("Shewiqua");

        NamesReader reader = new NamesReader("testNames.txt");
        Analyzer analyze = new Analyzer(reader);
        assertEquals(names, analyze.getAllNames());
    }

    @Test
    public void getAllNamesFor() throws IOException {
        List<NameData> yearNames = new ArrayList<>();
        yearNames.add(new NameData(State.TX, Gender.Female, 1983, "Shanique", 6));
        yearNames.add(new NameData(State.KS, Gender.Female, 1983, "Sheronda", 6));
        yearNames.add(new NameData(State.TX, Gender.Female, 1983, "Shewiqua", 6));

        NamesReader reader = new NamesReader("testNames.txt");
        Analyzer analyze = new Analyzer(reader);
        assertEquals(yearNames, analyze.getAllNamesFor(1983));
    }

    @Test
    public void genderNeutralNames() throws IOException {
        Set<String> neutral = new HashSet<>();
        neutral.add("Sammi");

        NamesReader reader = new NamesReader("testNames.txt");
        Analyzer analyze = new Analyzer(reader);
        assertEquals(neutral, analyze.genderNeutralNames());
    }
}