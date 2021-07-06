package esFacebook;

public class Friend {

	private String name;
	private String surname;
	private int age;
	private String userTag;
	
	public Friend(String name, String surname, int age, String userTag) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.userTag = userTag;
	}

	@Override
	public String toString() {
		return "Name=[" + name + "], surname=[" + surname + "], age=[" + age + "]";
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getAge() {
		return age;
	}
	
	public String getUserTag() {
		return userTag;
	}
}
