package models;

public class Artist extends User {
	
	private String mahlas;
	
	
	
	public Artist(String username,String password){
		super(username,password);
	}
	public Artist() {
		super();
	}
	public String getMahlas() {
		return mahlas;
	}
	public void setMahlas(String mahlas) {
		this.mahlas = mahlas;
	}
}
