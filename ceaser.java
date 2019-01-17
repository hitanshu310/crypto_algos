import java.util.*;
class Main
{
	static int key;
	static String plain_text;
	static String cipher_text;
  static char[] cipher;
  static String encode(int key, String plain_text)
  {
    cipher = new char[plain_text.length()];
    for(int i = 0; i < plain_text.length(); i++)
    {
      char c = plain_text.charAt(i);
      char ct = (char) (((int) c + key%26) - 32);
      cipher[i] = ct;
    }
    String cipher_text = String.copyValueOf(cipher);
    return cipher_text;
  }
  static String decode(int key, String cipher_text)
  {
    cipher = new char[plain_text.length()];
    for(int i = 0; i < cipher_text.length(); i++)
    {
      char c = cipher_text.charAt(i);
      int m = (int) c - 65;
      if(m - key < 0)
      {
        m = m + 26;
      }
      char x = (char) (m - key + 97);
      cipher[i] = x;
    }
    String plain_text = String.copyValueOf(cipher);
    return plain_text;
  }
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the plain_text");
		plain_text = sc.next();
    System.out.println("Enter the key");
    key = sc.nextInt();
    cipher_text = encode(3, plain_text);
    System.out.println(cipher_text);
    String new_plain = decode(key, cipher_text); 
    System.out.println(new_plain); 
	}
}
