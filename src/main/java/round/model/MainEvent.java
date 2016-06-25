package round.model;

import java.util.List;

public class MainEvent {
	
	private String id;
	private String name;
	private List<Tip> tip;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Tip> getTip() {
		return tip;
	}
	public void setTip(List<Tip> tip) {
		this.tip = tip;
	}
	

}
