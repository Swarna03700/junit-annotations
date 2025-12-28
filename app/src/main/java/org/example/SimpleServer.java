package org.example;

import java.util.ArrayList;
import java.util.List;

public class SimpleServer {
	
	private List<String> data = new ArrayList<>();
	
	public void connect() {
		System.out.println("Server connecting ...");
	}
	
	public void disconnect() {
		System.out.println("Server disconnecting ...");
	}
	
	public void addData(String item) {
		data.add(item);
	}
	
	public void clearData() {
		data.clear();
	}
	
	public int countItems() {
		return data.size();
	}
}
