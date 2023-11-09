package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Controller는 반환 값이 String이면 뷰 이름으로 인식됨 -> 뷰를 찾고 뷰가 렌더링됨
 * @RestController는 반환 값으로 뷰를 찾는 것이 아니라, HTTP 메시지 바디에 바로 입력함
 *  -> 실행 결과로 ok 메시지를 받을 수 있음
 */
@RestController
@Slf4j
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        /*
         *로깅 레벨 심각도 순으로
         * trace가 가장 낮고, error가 가장 높음
         * ex) application.properties에 debug 레벨로 설정하면 debug, info, warn, error가 찍힘
         *
         */
        log.trace("trace log={}", name);
        log.debug("debug log={}", name); // 개발 서버에서
        log.info("info log={}", name);   // 운영 서버에서
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
