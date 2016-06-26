package round.reader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import io.swagger.model.InlineResponse2001;
import io.swagger.model.RoundTips;
import round.model.MainEvent;
import round.model.Round;
import round.model.Tip;

public class ReadRound {

	private JSONParser parser;
	
	public ReadRound() {
		parser = new JSONParser();
	}
	
	public List<Round> getRoundTips() {
		
		List<Round> roundTips = new ArrayList<Round>();
		
		try {
			 
            Object obj = parser.parse(new FileReader("C:/Temp/UBETTipping/0.0.1/config/tips.json"));
            
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray rounds = (JSONArray) jsonObject.get("Rounds");
            rounds.forEach(round -> roundTips.add(parseRound((JSONObject)round)));
            
		} catch (Exception e) {
            e.printStackTrace();
        }
		return roundTips;
	}
	
	public InlineResponse2001 createRound(MainEvent mainEvent) {
		InlineResponse2001 event = new InlineResponse2001();
		event.setEventName(mainEvent.getName());
		List<RoundTips> roundTips = new ArrayList<RoundTips>();
		mainEvent.getTip().forEach(t -> roundTips.add(createTip(t)));
		event.setTips(roundTips);
		return event;
	}

	public RoundTips createTip(Tip tip) {
		RoundTips roundTip = new RoundTips();
		roundTip.setId(tip.getId());
		roundTip.setTip(tip.getName());
		roundTip.setOdds(tip.getOdds());
		return roundTip;
	}
	
	private Round parseRound(JSONObject jsonObject) {
		Round round = new Round();
		round.setRoundId((long) jsonObject.get("RoundId"));
        round.setRoundName((String) jsonObject.get("RoundName"));
		
        List<MainEvent> roundMainEvents = new ArrayList<MainEvent>();
		JSONArray mainEvents = (JSONArray) jsonObject.get("MainEvents");
		mainEvents.forEach(mainEvent -> roundMainEvents.add(parseMainEvent((JSONObject)mainEvent)));
		round.setMainEvents(roundMainEvents);
		return round;
	}
	
	private MainEvent parseMainEvent(JSONObject jsonObject) {
		MainEvent mainEvent = new MainEvent();
		mainEvent.setId((String) jsonObject.get("MainEventId"));
		mainEvent.setName((String) jsonObject.get("MainEventName"));
		
		List<Tip> mainEventTips = new ArrayList<Tip>();
		JSONArray tips = (JSONArray) jsonObject.get("Tips");
		tips.forEach(tip -> mainEventTips.add(parseTip((JSONObject)tip)));
		mainEvent.setTip(mainEventTips);
		return mainEvent;
	}
	
	private Tip parseTip(JSONObject jsonObject) {
		Tip tip = new Tip();
		tip.setId((String) jsonObject.get("OfferId"));
		tip.setName((String) jsonObject.get("OfferName"));
		tip.setOdds((String) jsonObject.get("odds"));
		return tip;
	}
}
