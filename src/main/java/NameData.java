
/**
 *This record represents records of U.S. state-specific Birth statistics.
 * Reference <a href="https://www.ssa.gov/oact/babynames/limits.html">...</a>
 * The order on NameData objects is given by the names.
 * @param gender Gender of the people who got this name.
 * @param state  US-State of record.
 * @param year   Year of the record
 * @param name   First name.
 * @param number How many times was the name given in that year in that state.
 */
public record NameData(State state, Gender gender, int year, String name, int number) implements Comparable<NameData> {

  /**
   * constructor, which creates the record from an entry of the state-specific files contained in names. The string is passed in the case
   * is passed to the ctor as a string!
   * Each entry contains the 5 fields comma-separated. Example:
   * NE,F,2008,Jaylee,7
   param string csv string with values corresponding to the attributes of this class.
   * @throws IllegalArgumentException, if the string cannot be parsed correctly.
   */
  public NameData(String string) {
    this(string.split(","));
  }

  private NameData(String[] fields) {
    this(State.valueOf(fields[0]),
        Gender.fromSingleCharacterString(fields[1]),
        Integer.parseInt(fields[2]),
        fields[3],
        Integer.parseInt(fields[4]));
  }

  @Override
  public int compareTo(NameData other) {
    return this.name().compareTo(other.name());
  }

}
