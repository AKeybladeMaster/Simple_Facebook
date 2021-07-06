package esFacebook;

import java.util.ArrayList;

public class FbManager {
	ArrayList<Friend> list_of_people = new ArrayList<Friend>();
	ArrayList<Photo> list_of_photos = new ArrayList<Photo>();

	public boolean addPeople(Friend p) {
		list_of_people.add(p);
		return true;
	}

	public boolean addPhoto(Photo f) {
		list_of_photos.add(f);
		return true;
	}

	public void printFriends() {
		for (Friend p : list_of_people) {
			System.out.println(p.toString());
		}
	}

	public Friend find(String surname, String name) {
		for (Friend p : list_of_people) {
			if (surname.equalsIgnoreCase(p.getSurname()) && name.equalsIgnoreCase(p.getName())) {
				return p;
			}
		}
		return null;
	}

	public int countUserTag(String userTagged) {
		int cont = 0;
		for (Photo f : list_of_photos) {
			if (userTagged.equalsIgnoreCase(f.getTag())) {
				cont++;
			}
		}
		return cont;
	}

	public String findMostTaggedUser() {
		int max = 0;
		String result = null;
		for (int i = 0; i < list_of_people.size(); i++) {
			int conta = 0;
			for (int k = 0; k < list_of_photos.size(); k++) {
				if (list_of_people.get(i).getUserTag().equals(list_of_photos.get(k).getTag())) {
					conta++;
				}
			}
			if (conta > max) {
				max = conta;
				result = list_of_people.get(i).getName() + " " + list_of_people.get(i).getSurname();
			}
		}
		if (null == result)
			return "The most tagged user is no one";
		return "The most tagged user is '" + result + "'";
	}

	public String printAFriend(Friend a) {
		return a.toString() + "\n";
	}
}
