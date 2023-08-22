import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.junit.Test;


public class NamesReaderTests {

  @Test
  public void testReader() throws IOException {
    NamesReader namesReader = new NamesReader("names.txt");
    assertEquals(6_311_504, namesReader.readData().size());
  }

}
