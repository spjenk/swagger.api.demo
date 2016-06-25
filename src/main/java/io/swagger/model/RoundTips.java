package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-06-25T10:47:23.644Z")
public class RoundTips  {
  
  private String id = null;
  private String tip = null;
  private String odds = null;

  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("tip")
  public String getTip() {
    return tip;
  }
  public void setTip(String tip) {
    this.tip = tip;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("odds")
  public String getOdds() {
    return odds;
  }
  public void setOdds(String odds) {
    this.odds = odds;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoundTips roundTips = (RoundTips) o;
    return Objects.equals(id, roundTips.id) &&
        Objects.equals(tip, roundTips.tip) &&
        Objects.equals(odds, roundTips.odds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tip, odds);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoundTips {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  tip: ").append(tip).append("\n");
    sb.append("  odds: ").append(odds).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
