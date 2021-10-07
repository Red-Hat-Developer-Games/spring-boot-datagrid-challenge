package com.redhat.developergames.repository;

import com.redhat.developergames.model.Weather;
import com.redhat.developergames.model.WeatherCondition;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class WeatherRepository {
   List<String> locations = Arrays.asList(
         "paris",
         "london",
         "berlin",
         "madrid",
         "lisboa",
         "ibiza",
         "oslo",
         "stockholm",
         "lima",
         "tokyo");

   private Random random = new Random();

   @Cacheable(value="weather",key="#location", unless="#result==null" )
   public Weather getByLocation(String location) {
      return fetchWeather(location);
   }

   private Weather fetchWeather(String location) {
      // Emulates a slow service. Don't change this. Use Spring Boot Cache with Data Grid
      try {
         TimeUnit.MILLISECONDS.sleep(1000);
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
      }

      if(!locations.contains(location)) {
         return null;
      }

      return new Weather(random.nextFloat() * 20f + 5f, WeatherCondition.values()[random.nextInt(10)], location);
   }
}
