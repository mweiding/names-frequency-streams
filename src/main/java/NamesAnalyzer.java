import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

public interface NamesAnalyzer {

  /**
   * Returns the most common girl or boy name across all states and years.
   * @param gender Gender to which the search is restricted.
   * @return mapping name to absolute frequency.
   * @throws IOException if there are problems reading the records.
   */
  Entry<String, Integer> getMostFrequentName(Gender gender) throws IOException;
  
  /**
   * Provides an alphabetically sorted list of all names that occur at all without differentiation by gender or similar.
   * @return Alphabetically sorted list of all occurring names.
   * @throws IOException if problems occur while reading the records.
   */
  List<String> getAllNames() throws IOException;

  /**
   * returns a list of all names occurring in a given calendar year
   * with absolute frequency, regardless of gender or state,
   * but sorted alphabetically by name.
   * @param year Calendar year for which all occurring names are searched.
   * @return Alphabetically sorted by name list of {@code NameData} objects for which.
   * {@code State.ANY} is entered as state.
   * @throws IOException if problems occur when reading the records.
   */
  List<NameData> getAllNamesFor(int year) throws IOException;

  /**
   * Returns a list of all names that have been assigned at least once each as male and
   * one time each as a female given name.
   * @return list with gender-neutral names.
   * @throws IOException if problems occur when reading the records.
   */
  Collection<String> genderNeutralNames() throws IOException;

}
