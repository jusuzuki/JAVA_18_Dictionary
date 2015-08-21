import java.util.HashMap;
import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> instances = new ArrayList<Word>();

  private String mWord;
  private int mId;

  public Word (String word){
    mWord = word;
    instances.add(this);
    mId = instances.size();
  }

  public String getWord(){
    return mWord;
  }

  public int getId() {
    return mId;
  }

}
