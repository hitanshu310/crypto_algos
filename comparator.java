import java.util.*;
class Main
{
	public static void main(String[] args)throws Exception
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> stuArray = new ArrayList<Student>();
		Student s1 = new Student("hitansh", 96);
		stuArray.add(s1);		
		Student s2 = new Student("hitanshu", 99);
		stuArray.add(s2);
		Student s3 = new Student("siby", 94);
		stuArray.add(s3);
    Collections.sort(stuArray, new compareClass());
    for(int i = 0; i < stuArray.size(); i++ )
    {
      Student stu = (Student) stuArray.get(i);
      stu.getStringOut();
    }
	}
}
class Student
{
	String name;
	int marks;
	Student(String name, int marks)
	{
		this.name = name;
		this.marks = marks;
	}
  public void getStringOut()
  {
    System.out.print(name+" "+marks);
    System.out.println();
  }
}
class compareClass implements Comparator<Student>
{
  public int compare(Student a, Student b)
  {
    return a.marks - b.marks;
  }
} 