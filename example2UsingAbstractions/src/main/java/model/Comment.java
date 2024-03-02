package model;

public class Comment {
	
	private String author;
	private String message;
	
	public Comment(String author, String message) {
		super();
		this.author = author;
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Comment [author=" + author + ", message=" + message + "]";
	}
	
	
}
