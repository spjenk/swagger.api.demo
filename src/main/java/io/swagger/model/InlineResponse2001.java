package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.RoundTips;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-06-26T03:56:38.503Z")
public class InlineResponse2001  {
  
  private String eventName = null;
  private String eventId = null;
  private List<RoundTips> tips = new ArrayList<RoundTips>();

  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("eventName")
  public String getEventName() {
    return eventName;
  }
  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("eventId")
  public String getEventId() {
    return eventId;
  }
  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("tips")
  public List<RoundTips> getTips() {
    return tips;
  }
  public void setTips(List<RoundTips> tips) {
    this.tips = tips;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2001 inlineResponse2001 = (InlineResponse2001) o;
    return Objects.equals(eventName, inlineResponse2001.eventName) &&
        Objects.equals(eventId, inlineResponse2001.eventId) &&
        Objects.equals(tips, inlineResponse2001.tips);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventName, eventId, tips);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001 {\n");
    
    sb.append("  eventName: ").append(eventName).append("\n");
    sb.append("  eventId: ").append(eventId).append("\n");
    sb.append("  tips: ").append(tips).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
