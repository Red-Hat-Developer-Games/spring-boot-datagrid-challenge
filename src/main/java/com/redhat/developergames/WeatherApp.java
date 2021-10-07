package com.redhat.developergames;

import com.redhat.developergames.model.Weather;
import com.redhat.developergames.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.dekorate.openshift.annotation.OpenshiftApplication;

@OpenshiftApplication
@SpringBootApplication
@RestController
@EnableCaching
public class WeatherApp {

   @Autowired
   WeatherRepository weatherRepository;

   @GetMapping("/")
   public String index() {
      return "Greetings from Spring Boot with Data Grid!";
   }

   @GetMapping("/weather/{location}")
   public Object getByLocation(@PathVariable String location) {
      Weather weather = weatherRepository.getByLocation(location);
      if (weather == null) {
         return String.format("Weather for location %s not found", location);
      }
      return weather;
   }

   @GetMapping("/latest")
   public String latestLocation() {
      return "ops, I did it again!";
   }

   public static void main(String... args) {
      new SpringApplicationBuilder().sources(WeatherApp.class).run(args);
   }
}
