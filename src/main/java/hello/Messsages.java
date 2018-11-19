

package hello;

import java.util.ArrayList;

public class Messsages {

	private static Messsages m;
	private static ArrayList<Message> messages1;
	private static ArrayList<Message> messages2;
	private static ArrayList<Message> messages;
	

	public Messsages() {
		messages1 = new ArrayList<Message>();
		messages2 = new ArrayList<Message>();
		messages = new ArrayList<Message>();
	}

	public Message getMessage1() {
		if (messages1.size() == 0) {
			return null;
		}
		Message s = messages1.get(0);
		messages1.remove(0);
		return s;
	}
	public Message getMessage2() {
		if (messages2.size() == 0) {
			return null;
		}
		Message s = messages2.get(0);
		messages2.remove(0);
		return s;
	}
	public Message getMessage(int i) {
		if (messages.size() < i) {
			return null;
		}
		Message s = messages.get(i-1);
//		messages.remove(0);
		return s;
	}

	public void addMessage(int id,String s) {
		messages.add(new Message(id,s));
	}

	public void addMessage(Message m) {
		messages.add(m);
	}

	public void addMessage1(Message m){
		messages1.add(m);
		messages2.add(m);

	}

	public void addMessage2(Message m){
		messages1.add(m);
		messages2.add(m);
	}
	public static Messsages initMessages() {
		if (m == null) {
			m = new Messsages();
		}
		return m;
	}

}