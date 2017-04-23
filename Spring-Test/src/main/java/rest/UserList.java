package rest;

import java.util.ArrayList;
import java.util.List;

public class UserList{
	private List<User> users = new ArrayList<User>();

	public List<User> getUserList(){
		return users;
	}

	public void setUserList(List<User> users){
		this.users = users;
	}
}
