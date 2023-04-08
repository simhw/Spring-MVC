package study.servlet.web.frontcontroller.v3;

import java.util.Map;

import study.servlet.web.frontcontroller.ModelView;

public interface ControllerV3 {
    
    ModelView process(Map<String, String> paramMap);
    
}
