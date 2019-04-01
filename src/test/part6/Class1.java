package test.part6;

public class Class1 {
	public int Calculate(int amount, int type, int years) {
		int result = 0;
		float disc = (years > 5) ? (float) 5 / 100 : (float) years / 100;
		if (type == 1) {
			result = amount;
		} else if (type == 2) {
			result = (int) ((amount - (0.1 * amount)) - disc * (amount - (0.1 * amount)));
		} else if (type == 3) {
			result = (int) ((0.7 * amount) - disc * (0.7 * amount));
		} else if (type == 4) {
			result = (int) ((amount - (0.5 * amount)) - disc * (amount - (0.5 * amount)));
		}
		return result;
	}
}
