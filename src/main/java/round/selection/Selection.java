package round.selection;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import io.swagger.model.InlineResponse200;
import io.swagger.model.TipSelection;
import round.model.Picks;

public class Selection {

	public boolean saveTips(Picks picks) {

		MongoClient mongoClient = new MongoClient();

		MongoDatabase db = mongoClient.getDatabase("tipping");
		MongoCollection<Document> collection = db.getCollection("RoundTips");

		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("_id", picks.getId());

		if (collection.count(whereQuery) > 0) {
			collection.findOneAndReplace(whereQuery, getDocument(picks));
		} else {
			collection.insertOne(getDocument(picks));
		}

		FindIterable<Document> documents = db.getCollection("RoundTips").find();
		for (Document document : documents) {
			System.out.println(document.toString());
		}

		mongoClient.close();

		return true;
	}

	private Document getDocument(Picks picks) {
		return new Document("_id", picks.getId()).append("user", picks.getUser())
				.append("round", picks.getRound()).append("selection", picks.getTips());
	}
	
	public List<InlineResponse200> getTips(String user, int round) {
		
		List<InlineResponse200> responseList = new ArrayList<InlineResponse200>();
		
		MongoClient mongoClient = new MongoClient();

		MongoDatabase db = mongoClient.getDatabase("tipping");
		MongoCollection<Document> collection = db.getCollection("RoundTips");
		
		System.out.println("_id: " + user + round);

		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("_id", user + round);
		//whereQuery.put("round", round);
		
		Picks picks = new Picks();
		
		FindIterable<Document> documents = collection.find(whereQuery);
		if (documents != null && documents.first() != null) {
			Document d = documents.first();
			System.out.println("Found User Record: " + d.getString("user"));
		} else {
			System.out.println("Could not find user record");
		}

		mongoClient.close();
		
		InlineResponse200 response = new InlineResponse200();
		response.setEventName("Broncos");
		responseList.add(response);
		
		return responseList;
	}
	
	public void processSelections(TipSelection tips) {
		Picks picks = new Picks();
		picks.setRound(tips.getWeek().intValue());
		picks.setUser(tips.getUser());
		picks.setTips(tips.getSelection());

		saveTips(picks);
	}

}
