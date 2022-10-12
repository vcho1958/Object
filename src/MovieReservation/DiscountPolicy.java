package MovieReservation;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
