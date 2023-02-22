package me.demo.demodevops.controller;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import me.demo.demodevops.dto.LogDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class LogController {

  @GetMapping("/successLog")
  public String successLog(HttpServletRequest request) {
    LogDto logDto = new LogDto();
    logDto.setStatus_code(200);
    logDto.setHttp_method(request.getMethod());
    logDto.setRequest_uri(request.getRequestURI());
    logDto.setRequest_params("noParam");
    logDto.setUser_id("testUserID");

    log.info(new Gson().toJson(logDto));
    return "successLog Success";
  }

  @PostMapping("/postLog")
  public String postLog(HttpServletRequest request,
      @RequestBody Map<String, Object> reqBody) {

    LogDto logDto = LogDto.builder()
        .level("info")
        .ip("192.168")
        .elapsed(0000)
        .service("demo-devops")
        .task("demo-devops-task")
        .cluster("demo-devops-cluster")
        .status_code(201)
        .http_method(request.getMethod())
        .request_uri(request.getRequestURI())
        .request_params("noParam")
        .user_id("testUserID")
        .request_body(reqBody)
        .response_body((Map<String, Object>) new HashMap<>().put("response", "success"))
        .data((Map<String, Object>) new HashMap<>().put("dataKey1", "dataValue1"))
        .build();

    log.info(new Gson().toJson(logDto));
    return "postLog Success";
  }
}
