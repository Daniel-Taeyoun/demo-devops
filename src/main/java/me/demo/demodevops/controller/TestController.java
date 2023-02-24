package me.demo.demodevops.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class TestController {

  private final RedisTemplate<String, String> redisTemplate;

  @GetMapping("/cicd")
  public String healthCheck() {
    log.info("*** CI/CD Success");
    return "CI/CD Success";
  }

  @GetMapping("/testApi")
  public String testApi() {
    log.info("*** testApi Test");
    return "Test Ok";
  }

  @GetMapping("/k8sTest")
  public String k8sTest() {
    log.info("*** docker-image-v1.0");
    return "docker-image-v1.0";
  }

  @GetMapping("/redis")
  public String callRedis() {
    redisTemplate.opsForValue().setIfAbsent("count", "0");
    int countIndex = Integer.valueOf(redisTemplate.opsForValue().get("count"));
    countIndex++;
    redisTemplate.opsForValue().set("count", String.valueOf(countIndex));
    return "Redis Count : "+countIndex;
  }

}
