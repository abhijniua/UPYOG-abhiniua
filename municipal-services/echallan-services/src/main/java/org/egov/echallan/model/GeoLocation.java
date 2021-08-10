/*
 * eChallan System
 * ### API Specs For eChallan System ### 1. Generate the new challan. 2. Update the details of existing challan 3. Search the existing challan 4. Generate the demand and bill for the challan amount so that collection can be done in online and offline mode. 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: contact@egovernments.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package org.egov.echallan.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * GeoLocation
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-08-10T16:46:24.044+05:30[Asia/Calcutta]")public class GeoLocation {

  @JsonProperty("latitude")

  private Double latitude = null;

  @JsonProperty("longitude")

  private Double longitude = null;

  @JsonProperty("additionalDetails")

  private Object additionalDetails = null;
  public GeoLocation latitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

  

  /**
  * latitude of the address
  * @return latitude
  **/
  public Double getLatitude() {
    return latitude;
  }
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }
  public GeoLocation longitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

  

  /**
  * longitude of the address
  * @return longitude
  **/
  public Double getLongitude() {
    return longitude;
  }
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }
  public GeoLocation additionalDetails(Object additionalDetails) {
    this.additionalDetails = additionalDetails;
    return this;
  }

  

  /**
  * Json object to capture any extra information which is not accommodated by model
  * @return additionalDetails
  **/
  public Object getAdditionalDetails() {
    return additionalDetails;
  }
  public void setAdditionalDetails(Object additionalDetails) {
    this.additionalDetails = additionalDetails;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoLocation geoLocation = (GeoLocation) o;
    return Objects.equals(this.latitude, geoLocation.latitude) &&
        Objects.equals(this.longitude, geoLocation.longitude) &&
        Objects.equals(this.additionalDetails, geoLocation.additionalDetails);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(latitude, longitude, additionalDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoLocation {\n");
    
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    additionalDetails: ").append(toIndentedString(additionalDetails)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
