package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * Tip object
 **/
@ApiModel(description = "Tip object")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-06-25T10:47:23.644Z")
public class TipSelection  {
  
  private String user = null;
  private String week = null;
  private List<String> selection = new ArrayList<String>();

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("user")
  public String getUser() {
    return user;
  }
  public void setUser(String user) {
    this.user = user;
  }

  /**
   * the round
   **/
  @ApiModelProperty(required = true, value = "the round")
  @JsonProperty("week")
  public String getWeek() {
    return week;
  }
  public void setWeek(String week) {
    this.week = week;
  }

  /**
   * Tip event
   **/
  @ApiModelProperty(required = true, value = "Tip event")
  @JsonProperty("selection")
  public List<String> getSelection() {
    return selection;
  }
  public void setSelection(List<String> selection) {
    this.selection = selection;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TipSelection tipSelection = (TipSelection) o;
    return Objects.equals(user, tipSelection.user) &&
        Objects.equals(week, tipSelection.week) &&
        Objects.equals(selection, tipSelection.selection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, week, selection);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TipSelection {\n");
    
    sb.append("  user: ").append(user).append("\n");
    sb.append("  week: ").append(week).append("\n");
    sb.append("  selection: ").append(selection).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
