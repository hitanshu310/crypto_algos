import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
// columnar transposition cipher
class Main {
  static String plain_text;
  static String cipher_text;
  static String key;
  static int col_len;
  static ArrayList<Column> cols;
  static int determineLength(String pText, String key)
  {
    if(pText.length() % key.length() != 0)
      return pText.length() / key.length() + 1;
    else
      return pText.length() / key.length();
  }
  static String encode(ArrayList<Column> col, String key)
  {
    Collections.sort(col, new CompareClass());
    String ctext = "";
      for(int i = 0; i < cols.size(); i++)
    {
      Column c = cols.get(i);
      ctext = ctext + c.getOutString();
    }
    return ctext;
  }
  static String decode(ArrayList<Column> cols, String key)
  {
    for(int i = 0; i < cols.size(); i++)
    {
      int ind = (int) key.charAt(i);
      for(int j = 0; j < cols.size(); j++)
      {
        Column tempcol = cols.get(j);
        if(tempcol.getInd() == ind)
        {
          Collections.swap(cols, i, j);
        }
      }
    }
    int counter = 0;
    char[] ctext = new char[cipher_text.length()];
    for(int i = 0; i < col_len; i++)
    {
      for(int j = 0; j < cols.size(); j++)
      {
        Column colm = cols.get(j);
        if(counter < plain_text.length())
          ctext[counter] = colm.colChar[i];
        counter++;
      }
    }
    return new String(ctext);
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    plain_text = sc.next();
    key = sc.next();
    col_len = determineLength(plain_text, key);
    cols = new ArrayList<Column>();
    for(int i = 0; i < key.length(); i++)
    {
      Column c = new Column();
      c.initColChar(col_len);
      c.setInd((int) key.charAt(i));
      char[] tempArray = new char[col_len];
      for(int j = 0; j < tempArray.length; j++)
      {
        if(j*key.length() + i >= plain_text.length())
          tempArray[j] = '_';
        else
          tempArray[j] = plain_text.charAt(j * key.length() + i); 
      }
      c.setColChar(tempArray);
      cols.add(c);
    } 
    cipher_text = encode(cols, key);
    System.out.println(cipher_text);
    System.out.println(decode(cols, key));
  }
}
class Column 
{
  private int sortInd;
  public char[] colChar;
  public void initColChar(int index)
  {
    this.colChar = new char[index];
  } 
  public void setInd(int n)
  {
    this.sortInd = n;
  }
  public int getInd()
  {
    return this.sortInd;
  }
  public void traverse()
  {
    for(int i = 0; i < this.colChar.length; i++)
    {
      System.out.print(colChar[i]+" ");
    }
  }
  public String getOutString()
  {
    String string = new String(colChar);
    return string;
  }
  public void setColChar(char[] colChar)
  {
    this.colChar = colChar;
  }
}
class CompareClass implements Comparator<Column>
{
  public int compare(Column a, Column b)
  {
    return a.getInd() - b.getInd();
  }
} 

