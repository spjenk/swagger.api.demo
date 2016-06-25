package io.swagger.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.model.TipSelection;
import round.model.Picks;
import round.selection.Selection;

@Controller
@RequestMapping(value = "/pick", produces = {APPLICATION_JSON_VALUE})
@Api(value = "/pick", description = "the pick API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-06-25T10:47:23.644Z")
public class PickApi {

  @ApiOperation(value = "", notes = "Tip Selections for a round ", response = String.class)
  @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = String.class),
    @io.swagger.annotations.ApiResponse(code = 500, message = "Error", response = String.class) })
  @RequestMapping(value = "",
    
    
    method = RequestMethod.POST)
  public ResponseEntity<String> pickPost(

@ApiParam(value = "Round selection" ,required=true ) @RequestBody TipSelection tips
) throws NotFoundException {
	  System.out.println("User:" + tips.getUser());
	  
	  Selection selection = new Selection();
	  Picks picks = new Picks();
	  picks.setRound(tips.getWeek());
	  picks.setUser(tips.getUser());
	  picks.setTip(tips.getSelection().get(0));
	  
	  selection.SaveTips(picks);
	  
      // do some magic!
      return new ResponseEntity<String>(HttpStatus.OK);
  }

}
