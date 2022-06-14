package heloo.core;

import heloo.core.discount.DiscountPolicy;
import heloo.core.discount.FixDiscountPolicy;
import heloo.core.discount.RateDiscountPolijcy;
import heloo.core.member.MemberRepository;
import heloo.core.member.MemberService;
import heloo.core.member.MemberServiceImpl;
import heloo.core.member.MemoryMemberRepository;
import heloo.core.order.OrderService;
import heloo.core.order.OrderServiceImpl;

public class AppConfig {

    //생성자를 통해서 구현체가 무엇이 들어갈지 결정
    //생성자 주입
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolijcy();
    }
}
