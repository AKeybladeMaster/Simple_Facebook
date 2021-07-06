package esFacebook;

public class Photo {

	private String title;
	private String tag;
	
	public Photo(String title, String tag) {
		this.title = title;
		this.tag = tag;
}

	public String getTitle() {
		return title;
	}

	public String getTag() {
		return tag;
	}
	
	@Override
	public String toString() {
		return "Photo - title=[" + title + "], tag=[" + tag + "]";
	}

}
