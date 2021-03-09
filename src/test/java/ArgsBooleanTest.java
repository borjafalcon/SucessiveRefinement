import org.junit.Test;

import static org.junit.Assert.*;

public class ArgsBooleanTest {

  @Test
  public void testCreateWithNoSchemaArguments() {
    ArgsBoolean args = new ArgsBoolean("", new String[0]);
    assertEquals(0, args.cardinality());
  }

  @Test
  public void testCreateWithNoSchemaOneArgument() {
    ArgsBoolean args = new ArgsBoolean("", new String[] {"-x"});
    assertFalse(args.isValid());
  }

  @Test
  public void testCreateWithNoSchemaMultipleArguments() {
    ArgsBoolean args = new ArgsBoolean("", new String[] {"-x", "-y"});
    assertFalse(args.isValid());
  }

  @Test
  public void testCreateWithNoSchemaBooleanArgument() {
    ArgsBoolean args = new ArgsBoolean("x", new String[] {"-x"});
    assertEquals(1, args.cardinality());
    assertTrue(args.getBoolean('x'));
  }

  @Test
  public void testCreateWithNoSchemaStringArgument() {
    ArgsBoolean args = new ArgsBoolean("x*", new String[] {"-x", "directory"});
    assertEquals(1, args.cardinality());
    assertEquals("directory", args.getString('x'));
  }
}
