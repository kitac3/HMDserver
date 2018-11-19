package hello;


public class Message{
	int userId;
	String body;
	public Message(int userId, String body) {
		super();
		this.userId = userId;
		this.body = body;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	public Message() {
		super();
	}

}
