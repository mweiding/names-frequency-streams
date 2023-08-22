
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Analyzer implements NamesAnalyzer {
    private final Collection<NameData> allData;

    public Analyzer(NamesReader namesReader) throws IOException {
        allData = namesReader.readData();
    }

    @Override
    public Map.Entry<String, Integer> getMostFrequentName(Gender gender) throws IOException {
        return allData.stream()
                .filter(nameData -> nameData.gender() == gender)
                .collect(Collectors.groupingBy(NameData::name, Collectors.summingInt(NameData::number)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> Map.entry(e.getKey(), e.getValue()))
                .orElse(null);
    }

    @Override
    public List<String> getAllNames() throws IOException {
        return allData.stream()
                .map(NameData::name)
                .distinct()
                .sorted()
                .toList();
    }

    @Override
    public List<NameData> getAllNamesFor(int year) throws IOException {
        return allData.stream()
                .filter(nameData -> nameData.year() == year)
                .distinct()
                .sorted()
                .toList();
    }

    @Override
    public Collection<String> genderNeutralNames() throws IOException {
        Set<String> maleNames = new HashSet<>();
        Set<String> femaleNames = new HashSet<>();
        Set<String> genderNeutralNames = new HashSet<>();

        allData.stream()
                .filter(nd -> nd.gender() == Gender.Male)
                .map(NameData::name)
                .forEach(maleNames::add);

        allData.stream()
                .filter(nd -> nd.gender() == Gender.Female)
                .map(NameData::name)
                .forEach(femaleNames::add);

        // Find gender-neutral names
        maleNames.forEach(name -> {
            if (femaleNames.contains(name)) {
                genderNeutralNames.add(name);
            }
        });

        return genderNeutralNames;
    }
}
