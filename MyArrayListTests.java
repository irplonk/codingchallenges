import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MyArrayListTests {

  private MyArrayList<String> arrayList;

  @Before
  public void setUp() {
    arrayList = new MyArrayList<>();
  }

  @Test
  public void init_StandardConditions_InitializesArrayList() {
    assertTrue(arrayList.isEmpty());
    assertEquals(0, arrayList.size());
  }
   
  @Test(expected = IndexOutOfBoundsException.class)
  public void get_InvalidIndex_ThrowsIndexOutOfBoundsException() {
    arrayList.get(0);
  }

  @Test
  public void add_OneElement_AddsElement() {
    arrayList.add("strawberry");
    assertEquals("strawberry", arrayList.get(0));
    assertEquals(1, arrayList.size());
  }

  @Test
  public void add_MultipleElements_AddsElement() {
    arrayList.add("strawberry");
    arrayList.add("blueberry");
    arrayList.add("raspberry");
    assertEquals("blueberry", arrayList.get(1));
    assertEquals(3, arrayList.size());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void remove_EmptyArrayList_ThrowsIndexOutOfBoundsException() {
    arrayList.remove(0);
  }

  public void remove_GivenElement_RemovesElement() {
    arrayList.add("strawberry");
    arrayList.add("blueberry");
    arrayList.add("raspberry");
    arrayList.remove("strawberry");
    assertFalse(arrayList.contains("strawberry"));
    assertEquals(2, arrayList.size());
  }

  public void remove_GivenValidIndex_RemovesElement() {
    arrayList.add("strawberry");
    arrayList.add("blueberry");
    arrayList.add("raspberry");
    arrayList.remove(0);
    assertFalse(arrayList.contains("strawberry"));
    assertEquals(2, arrayList.size());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void remove_GivenInvalidIndex_ThrowsIndexOutOfBoundsException() {
    arrayList.remove(0);
  }

  @Test
  public void add_GivenIndex_AddsElement() {
    arrayList.add(0, "strawberry");
    assertEquals("strawberry", arrayList.get(0));
    assertEquals(1, arrayList.size());
  }

  @Test
  public void clear_StandardConditions_EmptiesArray() {
    arrayList.add("strawberry");
    arrayList.add("blueberry");
    assertEquals(2, arrayList.size());
    arrayList.clear();
    assertEquals(0, arrayList.size());
  }

  @Test
  public void add_LotsOfElements_AddsAllElements() {
    arrayList.add("strawberry");
    arrayList.add("blueberry");
    arrayList.add("raspberry");
    arrayList.add("elderberry");
    arrayList.add("blackberry");
    arrayList.add("gooseberry");
    arrayList.add("boysenberry");
    arrayList.add("huckleberry");
    arrayList.add("mulberry");
    arrayList.add("wolfberry");
    arrayList.add("youngberry");
    assertEquals(11, arrayList.size());
    assertEquals("youngberry", arrayList.get(10));
  }
}