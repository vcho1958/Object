package MovieReservation;

//public interface DiscountCondition {
//    boolean isSatisfiedBy(Screening screening);
//}

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public DiscountConditionType getType() {
        return type;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public int getSequence() {
        return sequence;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}