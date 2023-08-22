
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

/**
 * Class for parsing the data from:
 * <a href="https://www.ssa.gov/oact/babynames/limits.html">
 */
public final class NamesReader {

  private final String fileName;

  /**
   * constructor, which is passed the path or name of the file containing the
   * records.
   * @param fileName Name of the file containing the records.
   */
  public NamesReader(String fileName) {
    this.fileName = fileName;
  }

  /**
   * Reads all records and creates a {@code NameData} object for each record.
   * @return Immutable collection with all read records.
   * @throws IOException If something goes wrong while opening or reading the file.
   */
  public Collection<NameData> readData() throws IOException {
    InputStream resourceStream = null;
    if ((resourceStream = this.getClass().getResourceAsStream("/" + fileName)) == null) {
      throw new IllegalArgumentException("Could not open resource " + fileName);
    }
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceStream))) {
      return reader
          .lines()
          .map(NameData::new)
          .toList();
    }
  }
}
