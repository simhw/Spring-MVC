package study.springmvc.basic.request;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping(value = "/headers", method = RequestMethod.GET)
    public String headers(HttpMethod method, Locale locale,
            @RequestHeader MultiValueMap<String, String> headerMap, @RequestHeader("host") String host,
            @CookieValue(value = "myCookie", required = false) String cookie) {

        log.info("method = {}", method);
        log.info("locale = {}", locale);
        log.info("headerMap = {}", headerMap);
        log.info("host = {}", host);
        log.info("cookie = {}", cookie);

        return "ok";
    }

}
