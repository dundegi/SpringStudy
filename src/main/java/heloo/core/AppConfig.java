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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //애플리케이션의 구성정보 담당, 설정정보 담당
public class AppConfig {

    //생성자를 통해서 구현체가 무엇이 들어갈지 결정
    //생성자 주입
    @Bean //각 메소드에 Bean을 붙이면 스프링 컨테이너에 등록됨.
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolijcy();
    }
}
