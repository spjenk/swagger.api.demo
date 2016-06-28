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
import round.constants.Consts;
import round.model.Picks;

public class Selection {

	public boolean saveTips(Picks picks) {

		MongoClient mongoClient = new MongoClient();
		MongoCollection<Document> collection = getCollection(mongoClient);

		BasicDBObject whereQuery = getTipUsingID(picks.getUser(), picks.getRound());

		if (collection.count(whereQuery) > 0) {
			collection.findOneAndReplace(whereQuery, getDocument(picks));
		} else {
			collection.insertOne(getDocument(picks));
		}

		FindIterable<Document> documents = collection.find();
		for (Document document : documents) {
			System.out.println(document.toString());
		}
		
		documents = collection.find(whereQuery);
		if (documents != null && documents.first() != null) {
			System.out.println("Selection saved: " + documents.first().toString());
		} else {
			System.out.println("Could not find newly written selection");
		}

		mongoClient.close();

		return true;
	}

	private BasicDBObject getTipUsingID(String user, int round) {
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("_id", user + round);
		return whereQuery;
	}
	
	public List<InlineResponse200> getTips(String user, int round) {
		
		List<InlineResponse200> responseList = new ArrayList<InlineResponse200>();
		
		MongoClient mongoClient = new MongoClient();
		MongoCollection<Document> collection = getCollection(mongoClient);

		BasicDBObject whereQuery = getTipUsingID(user, round);
		
		Picks picks = new Picks();
		picks.setUser(user);
		picks.setRound(round);
		
		FindIterable<Document> documents = collection.find(whereQuery);
		if (documents != null && documents.first() != null) {
			Document d = documents.first();
			System.out.println("Selection retrieved: " + d.toString());
			picks.setTips((List<String>)d.get("selection"));
		} else {
			System.out.println("Could not find user record");
		}

		mongoClient.close();
		
		picks.getTips().forEach(t -> responseList.add(createResponse(t)));
		
		return responseList;
	}
	
	public void processSelections(TipSelection tips) {
		Picks picks = new Picks();
		picks.setRound(tips.getWeek().intValue());
		picks.setUser(tips.getUser());
		picks.setTips(tips.getSelection());

		saveTips(picks);
	}
	
	private Document getDocument(Picks picks) {
		return new Document("_id", picks.getId()).append("user", picks.getUser())
				.append("round", picks.getRound()).append("selection", picks.getTips());
	}
	
	private InlineResponse200 createResponse(String tip) {
		InlineResponse200 response = new InlineResponse200();
		response.setEventName(tip);
		return response;
	}
	
	private MongoCollection<Document> getCollection(MongoClient mongoClient) {
		MongoDatabase db = mongoClient.getDatabase(Consts.DB);
		MongoCollection<Document> collection = db.getCollection(Consts.ROUND_COLLECTION);
		return collection;
	}

}
