import java.util.*;
import java.util.stream.Collectors;

public class Lymbda {

	public enum Gender{
		MALE,FEMALE
	}
	public static void main(String args[]){
				List<Person> pList = new ArrayList<Person>();

		Person p1 = new Person(1,"Sandeep",10,4567890,Gender.MALE);
		Person p2 = new Person(2,"Deepak",14,5463266,Gender.FEMALE);
		Person p3 = new Person(3,"Ashok",40,5673247,Gender.MALE);
		Person p4 = new Person(4,"Sandy",60,9876545,Gender.FEMALE);
		Person p5 = new Person(5,"HP",30,4568789,Gender.FEMALE);
		Person p6 = new Person(6,"Riti",4,4567890,Gender.FEMALE);
		Person p7 = new Person(7,"Shra",4,5463266,Gender.FEMALE);
		Person p8 = new Person(8,"ridhi",16,345698,Gender.FEMALE);
		Person p9 = new Person(9,"Sandy",25,98745,Gender.MALE);
		Person p10 = new Person(10,"HP",18,5678989,Gender.MALE);

		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		pList.add(p4);
		pList.add(p5);
		pList.add(p6);
		pList.add(p7);
		pList.add(p8);
		pList.add(p9);
		pList.add(p10);

		Lymbda l = new Lymbda();
		l.sortListByName(pList);

	}



	public void sortListByName(List<Person> lst){

		for(Person p : lst){
			System.out.println(p.name);
		}

		System.out.println("=============================");

		Collections.sort(lst,(Person p1,Person p2)->p1.name.compareTo(p2.name));

		for(Person p : lst){
			System.out.println(p.name);
		}

		List<Person> filter =
				lst.stream().filter(p -> p.getAge() > 20).filter(p->p.getGender() == Gender.FEMALE).
						collect(Collectors.toList());

		System.out.println(filter);

		System.out.println();
		System.out.println();
		System.out.println();

		Person filterByName = lst.stream().
					filter(p -> (p.getName().equals("Sandeep") && p.age > 1))
				.findAny()
				.orElse(null);

		System.out.println(filterByName != null  ? filterByName.toString() : null);

		String name = lst.stream().filter( p -> p.getName().equals("Sandeep")).
				map(Person::getName)
				.findAny()
				.orElse("");

		System.out.println("-->"+name);

		List<String> lstString = lst.stream().map(Person::getName).
				collect(Collectors.toList());

		System.out.println("lstString-->"+lstString);
	}


}

class Person {

	int           id;
	String        name;
	int           age;
	int           mobileNo;
	Lymbda.Gender gender;

	Person(int id, String n, int a, int m, Lymbda.Gender g){
		this.id = id;
		this.name = n;
		this.age = a;
		this.mobileNo = m;
		this.gender = g;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Lymbda.Gender getGender() {
		return gender;
	}

	public void setGender(Lymbda.Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", mobileNo=" + mobileNo +
				", gender=" + gender +
				'}';
	}
}
