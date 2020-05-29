import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Enumeration;

public class MyHashTableTests {

  private MyHashTable<String, String> myHashTable;

  @Before
  public void setUp() {
    myHashTable = new MyHashTable<>();
  }

  @Test
  public void put_KeyDoesNotExist_AddsKeyValuePair() {
    myHashTable.put("cat", "Daisy");
    assertEquals(1, myHashTable.size());
    assertEquals("Daisy", myHashTable.get("cat"));
  }

  @Test
  public void put_KeyExists_ReplacesValue() {
    myHashTable.put("cat", "Daisy");
    myHashTable.put("cat", "William");
    assertEquals(1, myHashTable.size());
    assertEquals("William", myHashTable.get("cat"));
  }

  @Test
  public void remove_KeyDoesNotExist_ReturnsNull() {
    assertEquals(null, myHashTable.remove("cat"));
  }

  @Test
  public void remove_KeyExists_ReturnsValue() {
    myHashTable.put("cat", "Daisy");
    assertEquals("Daisy", myHashTable.remove("cat"));
    assertEquals(0, myHashTable.size());
    assertEquals(null, myHashTable.get("cat"));
  }

  @Test
  public void clear_StandardConditions_ClearsHashTable() {
    myHashTable.put("cat", "Daisy");
    myHashTable.clear();
    assertEquals(0, myHashTable.size());
    assertEquals(null, myHashTable.get("cat"));
  }

  @Test
  public void keys_StandardConditions_ReturnsKeys() {
    myHashTable.put("cat", "Daisy");
    myHashTable.put("pig", "Wilbur");
    myHashTable.put("dog", "Beethoven");
    Enumeration<String> enumeration = myHashTable.keys();
    assertEquals("pig", enumeration.nextElement());
    assertEquals("cat", enumeration.nextElement());
    assertEquals("dog", enumeration.nextElement());
  }
}