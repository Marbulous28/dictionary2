import java.util.ArrayList;

public class Definition {
  private String mDefinition;
  private static ArrayList<Definition> instances = new ArrayList<Definition>();

  public Definition(String definition) {
    mDefinition = definition;
    instances.add(this);
  }

  public String getDefinition() {
    return mDefinition;
  }

  public static ArrayList<Definition> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

}
