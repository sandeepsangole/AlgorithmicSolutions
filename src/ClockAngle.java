
/*
 360 - Clock Circle - eg 3 hr, 40 mins

 1. Angle Per Min  : 360/60 = 6
 2. Angle Per Hour : 360/12 = 30
 3. Angle for minutes  - mins * ANGLE_PER_MIN
 4. hourAngle (tricky one) ( Calculates the before part)
   - hr * anglePerHour
   - (passed_mins / 60 ) * anglePerHr
 5. diff between minAngle - hourAngle
 6. check if angle is greater than 180 to return the smaller angle.

 */

public class ClockAngle {

	public static void main(String[] args) {
		ClockAngle clockAngle = new ClockAngle();
		System.out.println(clockAngle.calculateAngleClock(3, 40));
	}

	public double calculateAngleClock(int hr, int min) {

		if ((hr > 12 || hr < 0) || (min > 60 && min < 0)) {
			//throw new IllegalArgumentException("Hours must be between 1- 12 and min 0-60");
			return 0;
		}
		final double MINUTES_PER_HOUR = 60;
		final double ANGLE_PER_MIN    = 360 / 60;
		final double ANGLE_PER_HOUR   = 360 / 12;

		//Calculates Angle for minutes
		double minAngle = min * ANGLE_PER_MIN;
		//Angle for given hour(before)
		double hrAngle = hr * ANGLE_PER_HOUR;
		//Gap between hour and actual hour
		double hrAngleGap = (min / MINUTES_PER_HOUR) * ANGLE_PER_HOUR;
		double hourAngle  = hrAngle + hrAngleGap;
		double diff       = Math.abs(minAngle - hourAngle);

		//This part took little longer - which returns the smaller angle and not the outer one
		if (diff > 180) {
			return 360 - diff;
		} else {
			return diff;
		}
	}

}