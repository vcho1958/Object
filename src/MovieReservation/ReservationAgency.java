package MovieReservation;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();
        boolean discountable = false;
        for (DiscountCondition condition : movie.getDiscountConditions()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                LocalDateTime whenScreened = screening.getWhenScreened();
                discountable = whenScreened.getDayOfWeek().equals(condition.getDayOfWeek()) &&
                        condition.getStartTime().isBefore(whenScreened.toLocalTime()) &&
                        condition.getEndTime().isAfter(whenScreened.toLocalTime());

            } else {
                discountable = condition.getSequence() == screening.getSequence();
            }
            if (discountable) {
                break;
            }
        }
        Money fee;
        if (discountable) {
            Money discountAmount = Money.ZERO;
            switch (movie.getMovieType()) {
                case NONE_DISCOUNT -> discountAmount = Money.ZERO;
                case AMOUNT_DISCOUNT -> discountAmount = movie.getDiscountAmount();
                case PERCENT_DISCOUNT -> discountAmount = movie.getFee().times(movie.getDiscountPercent());
            }
            fee = movie.getFee().minus(discountAmount);
        } else {
            fee = movie.getFee();
        }
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
