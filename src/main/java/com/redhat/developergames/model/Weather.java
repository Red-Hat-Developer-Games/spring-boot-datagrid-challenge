package com.redhat.developergames.model;

import java.io.Serializable;
import java.util.Objects;

public class Weather implements Serializable {
   private Float temperature;
   private WeatherCondition condition;
   private String city;

   public Weather(Float temperature, WeatherCondition condition, String city) {
      this.temperature = temperature;
      this.condition = condition;
      this.city = city;
   }

   public Float getTemperature() {
      return temperature;
   }

   public void setTemperature(Float temperature) {
      this.temperature = temperature;
   }

   public WeatherCondition getCondition() {
      return condition;
   }

   public void setCondition(WeatherCondition condition) {
      this.condition = condition;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Weather weather = (Weather) o;
      return Float.compare(weather.temperature, temperature) == 0 && condition == weather.condition && Objects
            .equals(city, weather.city);
   }

   @Override
   public int hashCode() {
      return Objects.hash(temperature, condition, city);
   }

   @Override
   public String toString() {
      return "Weather{" + "temperature=" + temperature + ", condition=" + condition + ", city='" + city + '\'' + '}';
   }
}
