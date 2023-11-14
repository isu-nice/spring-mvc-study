package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/hello-basic", "/hello-go"}) // 여러 개 가능
    public String helloBasic1() {
        log.info("helloBasic1");
        return "ok";
    }

    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    public String helloBasic2() {
        log.info("helloBasic2");
        return "ok";
    }

    // 애노테이션을 사용하는 것이 직관적임
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        return "ok";
    }

    // @PathVariable
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data);
        return "ok";
    }
    /*
     * 잘 사용하지는 않음
     * consumes -> Content-Type 헤더 기반 추가 매핑
     * produces -> Accept 헤더 기반 추가 매핑
     */
    @PostMapping(value = "/mapping-consumes",
            consumes = "!application/json",
            produces = "text/html")
    public String mappingConsumes1() {
        return "ok";
    }

}
