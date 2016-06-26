package io.swagger.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.model.InlineResponse200;
import io.swagger.model.TipSelection;
import round.model.Picks;
import round.selection.Selection;

@Controller
@RequestMapping(value = "/pick", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/pick", description = "the pick API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-06-26T03:56:38.503Z")
public class PickApi {

	@ApiOperation(value = "", notes = "The Events selected by a user for a tipping week ", response = InlineResponse200.class, responseContainer = "List")
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = InlineResponse200.class) })
	@RequestMapping(value = "",

	method = RequestMethod.GET)
	public ResponseEntity<List<InlineResponse200>> pickGet(
			@ApiParam(value = "User whos selections we want", required = true) @RequestParam(value = "user", required = true) String user

	, @ApiParam(value = "Round week", required = true) @RequestParam(value = "week", required = true) BigDecimal week

	) throws NotFoundException {
		return new ResponseEntity<List<InlineResponse200>>(new Selection().getTips(user, week.intValue()), HttpStatus.OK);
	}

	@ApiOperation(value = "", notes = "Tip Selections for a round ", response = String.class)
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = String.class),
			@io.swagger.annotations.ApiResponse(code = 500, message = "Error", response = String.class) })
	@RequestMapping(value = "",

	method = RequestMethod.POST)
	public ResponseEntity<String> pickPost(

			@ApiParam(value = "Round selection", required = true) @RequestBody TipSelection tips)
					throws NotFoundException {

		Selection selection = new Selection();
		selection.processSelections(tips);

		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
