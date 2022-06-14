package heloo.core;


import heloo.core.member.Grade;
import heloo.core.member.Member;
import heloo.core.member.MemberService;
import heloo.core.member.MemberServiceImpl;
import heloo.core.order.Order;
import heloo.core.order.OrderService;
import heloo.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();


        //MemberService memberService = new MemberServiceImpl(null);
        //OrderService orderService = new OrderServiceImpl(null, null);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println();

    }
}
