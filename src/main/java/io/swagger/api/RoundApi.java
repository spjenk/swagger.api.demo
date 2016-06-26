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
import io.swagger.model.InlineResponse2001;
import round.model.Round;
import round.reader.ReadRound;

@Controller
@RequestMapping(value = "/round", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/round", description = "the round API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-06-26T03:56:38.503Z")
public class RoundApi {

	@ApiOperation(value = "", notes = "The Events and Tips available for a tipping week ", response = InlineResponse2001.class, responseContainer = "List")
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = InlineResponse2001.class) })
	@RequestMapping(value = "",

	method = RequestMethod.GET)
	public ResponseEntity<List<InlineResponse2001>> roundGet(
			@ApiParam(value = "Round week", required = true) @RequestParam(value = "week", required = true) int week

	) throws NotFoundException {

		List<InlineResponse2001> responseList = new ArrayList<InlineResponse2001>();
		ReadRound readRound = new ReadRound();

		Round round = Round.findFirst(readRound.getRoundTips(), r -> r.getRoundId() == week);
		round.getMainEvents().forEach(m -> responseList.add(readRound.createRound(m)));
		return new ResponseEntity<List<InlineResponse2001>>(responseList, HttpStatus.OK);
	}

}
