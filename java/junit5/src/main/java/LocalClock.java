import java.time.LocalTime;

public final class LocalClock implements Clock {

  @Override
  public int getHour() {
    return LocalTime.now().getHour();
  }
}
