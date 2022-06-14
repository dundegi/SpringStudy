package heloo.core.discount;

import heloo.core.member.Grade;
import heloo.core.member.Member;

public class RateDiscountPolijcy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else {
            return 0;
        }

    }
}
