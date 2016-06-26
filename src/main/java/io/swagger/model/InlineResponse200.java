package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-06-26T03:56:38.503Z")
public class InlineResponse200  {
  
  private String eventName = null;
  private String eventId = null;

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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(eventName, inlineResponse200.eventName) &&
        Objects.equals(eventId, inlineResponse200.eventId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventName, eventId);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("  eventName: ").append(eventName).append("\n");
    sb.append("  eventId: ").append(eventId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
