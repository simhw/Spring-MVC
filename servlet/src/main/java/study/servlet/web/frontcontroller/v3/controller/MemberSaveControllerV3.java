package study.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

import study.servlet.domain.member.Member;
import study.servlet.domain.member.MemberRepository;
import study.servlet.web.frontcontroller.ModelView;
import study.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", member);

        return modelView;
    }
}
