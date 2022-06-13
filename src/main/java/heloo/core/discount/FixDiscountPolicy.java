package heloo.core.discount;

import heloo.core.member.Grade;
import heloo.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;


    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP){ //enum 클래스는 == 쓴다.
            return discountFixAmount;

        }else {
            return 0;
        }

    }
}
