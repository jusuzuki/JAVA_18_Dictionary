import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> instances = new ArrayList<Word>();

  private String mWord;
  private int mId;
  private ArrayList<Definition> mDefinition;

  public Word (String word){
    mWord = word;
    instances.add(this);
    mId = instances.size();
    mDefinition = new ArrayList<Definition>();
  }

  public String getWord(){
    return mWord;
  }

  public int getId() {
    return mId;
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinition;
  }

  public void addDefinition(Definition definition){
    mDefinition.add(definition);
  }

  public static Word find(int id){
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }


}
