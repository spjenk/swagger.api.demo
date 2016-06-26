package round.model;

import java.util.List;

public class Picks {
	
	private String user;
	private int round;
	private List<String> tips;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public List<String> getTips() {
		return tips;
	}
	public void setTips(List<String> tips) {
		this.tips = tips;
	}
	public String getId() {
		return user + round;
	}
}
