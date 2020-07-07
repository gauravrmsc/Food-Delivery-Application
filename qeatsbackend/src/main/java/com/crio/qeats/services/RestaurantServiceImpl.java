
/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.services;

import com.crio.qeats.dto.Restaurant;
import com.crio.qeats.exchanges.GetRestaurantsRequest;
import com.crio.qeats.exchanges.GetRestaurantsResponse;
import com.crio.qeats.repositoryservices.RestaurantRepositoryService;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RestaurantServiceImpl implements RestaurantService {

  private final Double peakHoursServingRadiusInKms = 3.0;
  private final Double normalHoursServingRadiusInKms = 5.0;
  private static final List<List<LocalTime>> peakTimeList = new ArrayList<List<LocalTime>>();
  @Autowired
  private RestaurantRepositoryService restaurantRepositoryService;

  static {
    String[] peakTimeRanges = { "08:00-10:00", "13:00-14:00", "19:00-21:00" };
    for (String peakTimeRange : peakTimeRanges) {
      String[] range = peakTimeRange.split("-");
      List<LocalTime> peakTime = new ArrayList<>();
      peakTime.add(LocalTime.parse(range[0]));
      peakTime.add(LocalTime.parse(range[1]));
      peakTimeList.add(peakTime);
    }
  }

  // TODO: CRIO_TASK_MODULE_RESTAURANTSAPI - Implement findAllRestaurantsCloseby.
  // Check RestaurantService.java file for the interface contract.
  // peak hours: 8AM - 10AM, 1PM-2PM, 7PM-9PM
  // CHECKSTYLE:OFF
  @Override
  public GetRestaurantsResponse findAllRestaurantsCloseBy(GetRestaurantsRequest getRestaurantsRequest,
      LocalTime currentTime) {
    Double latitude = getRestaurantsRequest.getLatitude();
    Double longitude = getRestaurantsRequest.getLongitude();
    Double servingRadius = normalHoursServingRadiusInKms;
    for (List<LocalTime> peakTime : peakTimeList) {
      if (currentTime.compareTo(peakTime.get(0)) >= 0 && 
          currentTime.compareTo(peakTime.get(1)) <= 0) {
        servingRadius = peakHoursServingRadiusInKms;
      }
    }
    List<Restaurant> restaurants = restaurantRepositoryService.findAllRestaurantsCloseBy(latitude, longitude,
        currentTime, servingRadius);
    GetRestaurantsResponse response = new GetRestaurantsResponse(restaurants);
    return response;
  }

}
