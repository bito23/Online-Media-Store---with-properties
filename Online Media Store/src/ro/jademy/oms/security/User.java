package ro.jademy.oms.security;

public class User {
private String user;
private String password;
private String fullName;
private boolean enable = true;

public boolean isEnable() {
	return enable;
}

public void setEnable(boolean enable) {
	this.enable = enable;
}

public void setUser(String user){
	this.user = user;
}

public String getUser(){
	return user;
}

@Override
public String toString() {
	return "User [user=" + user + ", password=" + password + ", fullName=" + fullName + "]";
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}
}
