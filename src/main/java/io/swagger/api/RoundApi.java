package io.swagger.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.model.RoundApiModel;
import io.swagger.model.RoundTips;
import round.model.MainEvent;
import round.model.Round;
import round.model.Tip;
import round.reader.ReadRound;

@Controller
@RequestMapping(value = "/round", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/round", description = "the round API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-06-12T09:25:07.992Z")
public class RoundApi {

	@ApiOperation(value = "", notes = "Gets round available tips. ", response = RoundApiModel.class, responseContainer = "List")
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = RoundApiModel.class) })
	@RequestMapping(value = "", method = RequestMethod.GET)

	public ResponseEntity<List<RoundApiModel>> roundGet(
			@ApiParam(value = "Round week", required = true) @RequestParam(value = "week", required = true) int week)
					throws NotFoundException {

		List<RoundApiModel> responseList = new ArrayList<RoundApiModel>();
		ReadRound readRound = new ReadRound();

		Round round = Round.findFirst(readRound.getRoundTips(), r -> r.getRoundId() == week);
		round.getMainEvents().forEach(m -> responseList.add(createRound(m)));
		return new ResponseEntity<List<RoundApiModel>>(responseList, HttpStatus.OK);
	}
	
	private RoundApiModel createRound(MainEvent mainEvent) {
		RoundApiModel event = new RoundApiModel();
		event.setEventName(mainEvent.getName());
		List<RoundTips> roundTips = new ArrayList<RoundTips>();
		mainEvent.getTip().forEach(t -> roundTips.add(createTip(t)));
		event.setTips(roundTips);
		return event;
	}

	private RoundTips createTip(Tip tip) {
		RoundTips roundTip = new RoundTips();
		roundTip.setId(tip.getId());
		roundTip.setTip(tip.getName());
		roundTip.setOdds(tip.getOdds());
		return roundTip;
	}


}
