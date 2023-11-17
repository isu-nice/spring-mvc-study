package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 @ResponseBody를 클래스 레벨에서 설정하고 싶은 경우,
 @Controller + @ResponseBody 대신 @RestController 애노테이션을 사용하면 된다.
 */
@Controller
@Slf4j
public class ResponseBodyController {

    // HttpServletResponse 객체를 통해 HTTP 메시지 바디에 직접 ok 응답 메시지를 전달
    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    // ResponseEntity를 리턴하는 방식 -> 메시지의 헤더, 바디 정보를 담고 있음
    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    // view를 사용하지 않고 HTTP 메시지 컨버터를 통해 메시지를 직접 입력
    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    }

    // HTTP 메시지 컨버터를 통해 JSON 형식으로 변환되어 리턴
    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);

        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    // @ResponseBody를 사용하면 상태코드 설정이 까다롭기 때문에 @ResponseStatus를 사용하여 상태코드 설정
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return helloData;
    }
}
