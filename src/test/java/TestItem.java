import org.example.StandardClasses.Item;
import org.example.MAPPERS.ItemMAPPER;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestItem {
    @Test
    public void testConvertJSONItem() {
        //given
        String name = "knife";
        String json = "{\"name\": \"" + name + "\",\"quantity\": \"" + 1 + "\"}";
        //when
        Item actual = ItemMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(name, actual.getName());
    }

    @Test
    public void testConvertJSONItemWithWhiteSigns() {
        //given
        String name = "knife  ";
        String json = "{\"name\": \"" + name + "\",\"quantity\": \"" + 1 + "\"}";
        //when
        Item actual = ItemMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(name, actual.getName());
    }

    @Test
    public void testConvertJSONItemWithEmptyString() {
        //given
        String name = " ";
        String json = "{\"name\": \"" + name + "\",\"quantity\": \"" + 1 + "\"}";
        //when
        Item actual = ItemMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(name, actual.getName());
    }

    @Test
    public void testConvertJSONItemOnlyWithWhiteSigns() {
        //given
        String name = "\t \r \n";
        String json = "{\"name\": \"" + name + "\",\"quantity\": \"" + 1 + "\"}";
        //when
        Item actual = ItemMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    @Test
    public void testConvertJSONquantity() {
        //given
        int quantity = 10;
        String name = "knife";
        String json = "{\"name\": \"" + name + "\",\"quantity\": " + quantity + "}";
        //when
        Item actual = ItemMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(quantity, actual.getQuantity());
    }

    @Test
    public void testConvertJSONWithMinusquantity() {
        //given
        int quantity = -1;
        String name = "Charisma";
        String json = "{\"name\": \"" + name + "\",\"quantity\": \"" + quantity + "\"}";
        //when
        Item actual = ItemMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(quantity, actual.getQuantity());
    }

    @Test
    public void testConvertJSONWithMinusZero() {
        //given
        int quantity = 0;
        String name = "Charisma";
        String json = "{\"name\": \"" + name + "\",\"quantity\": \"" + quantity + "\"}";
        //when
        Item actual = ItemMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(quantity, actual.getQuantity());
    }

    @Test
    public void testErroneusConvertJSONItem() {
        //given
        String name = "knife";
        String json = "{\"name\": \"" + name + "\",\"quantity\": \"" + 1 + "\"";
        //when
        Item actual = ItemMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    @Test
    public void testErroneusConvertJSONItemWithoutQuote() {
        //given
        String name = "knife";
        String json = "{\name\": \"" + name + "\",\"quantity\": \"" + 1 + "\"}";
        //when
        Item actual = ItemMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    @Test
    public void testErroneusConvertJSONItemWithWrongNameType() {
        //given
        String json = "{\"name\": " + 1 + ",\"quantity\": \"" + 1 + "\"}";
        //when
        Item actual = ItemMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals("1", actual.getName());
    }

    @Test
    public void testErroneusConvertJSONItemWithSomething() {
        //given
        String json = "{\"name\": " + 1 + ",\"quantity\": " + "something" + "}";
        //when
        Item actual = ItemMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }
}
