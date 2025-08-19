
public class TimeKeeping {
	
	public static long calculateDeltaTime(long comparisonTime) {
		return System.currentTimeMillis() - comparisonTime;
	}

}
