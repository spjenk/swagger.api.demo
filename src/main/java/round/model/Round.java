package round.model;

import java.util.List;
import java.util.function.Predicate;

public class Round {
	
	private long roundId;
	private String roundName; 
	private List<MainEvent> mainEvents;
	
	public long getRoundId() {
		return roundId;
	}
	public void setRoundId(long roundId) {
		this.roundId = roundId;
	}
	public String getRoundName() {
		return roundName;
	}
	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}
	public List<MainEvent> getMainEvents() {
		return mainEvents;
	}
	public void setMainEvents(List<MainEvent> mainEvents) {
		this.mainEvents = mainEvents;
	}
	
	public static Round findFirst(List<Round> rounds, Predicate<Round> tester) {
		for (Round r : rounds) {
			if (tester.test(r)) {
				return r;
			}
		}
		return null;
	}
}
