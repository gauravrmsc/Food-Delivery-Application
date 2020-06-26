
/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.dto;

import java.util.List;



// TODO: CRIO_TASK_MODULE_SERIALIZATION
//  Implement Restaurant class.
// Complete the class such that it produces the following JSON during serialization.
// {
//  "restaurantId": "10",
//  "name": "A2B",
//  "city": "Hsr Layout",
//  "imageUrl": "www.google.com",
//  "latitude": 20.027,
//  "longitude": 30.0,
//  "opensAt": "18:00",
//  "closesAt": "23:00",
//  "attributes": [
//    "Tamil",
//    "South Indian"
//  ]
// }

public class Restaurant {
  String restaurantId;
  String name;
  String city;
  String imageUrl;
  double latitude;
  double longitude;
  String opensAt;
  String closesAt;
  List<String> attributes;
  
  public String getRestaurantId() {
    return restaurantId;
  }
  
  public void setRestaurantId(String restaurantId) {
    this.restaurantId = restaurantId;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getCity() {
    return city;
  }
  
  public void setCity(String city) {
    this.city = city;
  }
  
  public String getImageUrl() {
    return imageUrl;
  }
  
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
  
  public double getLatitude() {
    return latitude;
  }
  
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }
  
  public double getLongitude() {
    return longitude;
  }
  
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
  
  public String getOpensAt() {
    return opensAt;
  }
  
  public void setOpensAt(String opensAt) {
    this.opensAt = opensAt;
  }
  
  public String getClosesAt() {
    return closesAt;
  }
  
  public void setClosesAt(String closesAt) {
    this.closesAt = closesAt;
  }
  
  public List<String> getAttributes() {
    return attributes;
  }
  
  public void setAttributes(List<String> attributes) {
    this.attributes = attributes;
  }
}
  
  