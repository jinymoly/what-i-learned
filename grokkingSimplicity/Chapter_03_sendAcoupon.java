package grokkingSimplicity;

import java.util.ArrayList;
import java.util.List;

class Subscriber {
    String email;
    int rec_count;
}

class Coupon {
    String code;
    String rank;
}

class Message { 
    String from;
    String to;
    String subject;
    String body;
}

public class Chapter_03_sendAcoupon {

    /**
     * 쿠폰 등급을 결정 
     * @param subscriber
     * @return
     */
    public static String subCouponRank(Subscriber subscriber){
        if(subscriber.rec_count >= 10) 
        return "best";
        else
        return "good";
    }
    
    /**
     * 특정 등급의 쿠폰 목록을 선택하는 계산
     * @param coupons
     * @param rank
     * @return
     */
    public static List<String> selectCouponsByRank(List<Coupon> coupons, String rank){
        List<String> ret = new ArrayList<>();
        for(Coupon coupon : coupons){
            if(coupon.rank.equals(rank)) // 현재 쿠폰이 주어진 등급에 맞으면 쿠폰 코드를 배열에 넣음 
            ret.add(coupon.code);
        }
        return ret;
    }
    
    /**
     * 구독자가 받을 이메일 계획하는 계산
     * @param subscriber
     * @param goods
     * @param bests
     * @return
     */
    public static Message emailForSubscriber(Subscriber subscriber, List<String> goods, List<String> bests){
        String rank = subCouponRank(subscriber);
        if(rank.equals("best")){
            Message email = new Message();
            email.from = "newsletter@coupon.co";
            email.to = subscriber.email;
            email.subject = "Your best weekly coupons inside";
            email.body = "Here are the best coupons :" + String.join(", ", bests);
            return email;
        } else {
            Message email = new Message();
            email.from = "newsletter@coupon.co";
            email.to = subscriber.email;
            email.subject = "Your best weekly coupons inside";
            email.body = "Here are the best coupons :" + String.join(", ", goods);
            return email;
        }
    }

    /**
     * 보낼 이메일 목록 준비하기
     * @param subscribers
     * @param goods
     * @param bests
     * @return
     */
    public static List<Message> emailsForSubscribers(List<Subscriber> subscribers, List<String> goods, List<String> bests){
        List<Message> emails = new ArrayList<>();
        for(Subscriber subscriber : subscribers){
            Message email = emailForSubscriber(subscriber, goods, bests);
            emails.add(email);
        }
        return emails;
    }

    /**
     * 이메일을 보내기 - 액션
     * @param email
     */
    public static void sendEmail(Message email){

    }
    
    public static List<Coupon> fetchCouponsFromDB(){
        return new ArrayList<>();
    }

    public static List<Subscriber> fetchSubscribersFromDB(int page){
        return new ArrayList<>();
    }
    
    public void sendIssue() {
        List<Coupon> coupons = fetchCouponsFromDB();
        List<String> goodCoupons = selectCouponsByRank(coupons, "good");
        List<String> bestCoupons = selectCouponsByRank(coupons, "best");
        int page = 0;
        List<Subscriber> subscribers = fetchSubscribersFromDB(page);
        while(subscribers.size() > 0){
        List<Message> emails = emailsForSubscribers(subscribers, goodCoupons, bestCoupons);
        for(int e = 0; e < emails.size(); e++) {
          Message email = emails.get(e);
          emailSystem.send(email);
        }
        page ++;
        subscribers = fetchSubscribersFromDB(page);
      }
    }
    
    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber();
        subscriber.email = "sam@pmail.com";
        subscriber.rec_count = 16;
        
        String rank1 = "best";
        String rank2 = "good";

        String couponRank = subCouponRank(subscriber);

        Coupon coupon = new Coupon();
        coupon.code = "10PERSENT";
        coupon.rank = "bad";

        List<Coupon> coupons = fetchCouponsFromDB();
        List<String> goodCoupons = selectCouponsByRank(coupons, "good");
        List<String> bestCoupons = selectCouponsByRank(coupons, "best");

        List<Subscriber> subscribers = fetchSubscribersFromDB(20);
        List<Message> emails = emailsForSubscribers(subscribers, goodCoupons, bestCoupons);

        for(Message email : emails){
            sendEmail(email);
        }

    }
}
