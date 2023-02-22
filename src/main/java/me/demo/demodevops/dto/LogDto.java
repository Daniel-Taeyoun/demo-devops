package me.demo.demodevops.dto;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : daniel
 * @packageName : me.demo.demodevops.dto
 * @date : 2023/01/19
 * @description :
 */
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogDto {

  private String level = "info";
  private String ip = "192.168";
  private Integer elapsed = 000;
  private String service = "demo-devops";
  private String task = "demo-devops-task";
  private String cluster = "demo-devops-cluster";
  private Integer status_code;
  private String http_method;
  private String request_uri;
  private String request_params;
  private String user_id;
  private Map<String, Object> request_body;
  private Map<String, Object> response_body;
  private String responseBodyString;
  private Map<String, Object> data;

}
