package study.springmvc.basic.requestmapping;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MappingController {

    @RequestMapping("/hello-basic")
    private String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @GetMapping("/mapping-get-v2")
    private String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    // PathVariable(경로 변수) 사용
    @GetMapping("/mapping/{userId}")
    private String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId = {}", userId);
        return "ok";
    }

    // PathVariable 다중 사용
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    private String mappingPath(@PathVariable String userId, @PathVariable int orderId) {
        log.info("mappingPath userId = {}, orderId = {}", userId, orderId);
        return "ok";
    }

    // 특정 헤더로 추가 매핑
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    private String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    // 미디어 타입 추가 매핑
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    private String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    // 미디어 타입 추가 매핑
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    private String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }

}
