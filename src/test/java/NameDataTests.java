import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.IOException;


public class NameDataTests {
  
  @Test
  public void testCtorFromString() {
    NameData nameData = new NameData("AK,F,1911,Helen,6");
    assertEquals(State.AK, nameData.state());
    assertEquals(Gender.Female, nameData.gender());
    assertEquals(1911, nameData.year());
    assertEquals("Helen", nameData.name());
    assertEquals(6, nameData.number());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalNumberOfValues() {
    NameData nameData = new NameData("");
  }
}
