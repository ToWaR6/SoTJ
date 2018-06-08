package model;

public class User {

	private int userId;
	private String pseudo;
	private int reputation;
	
	//CONSTRUCTEUR
	public User(int userId, String pseudo, int reputation) {
		super();
		this.userId = userId;
		this.pseudo = pseudo;
		this.reputation = reputation;
	}

	//GETTER & SETTER
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}	
	
	//FONCTION
	public String toString() {
		return "Id:"+this.userId+" | pseudo:"+this.pseudo+" | reputation:"+this.reputation;
	}
	
}
