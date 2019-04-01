package test.part6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Class1Test {

	@Test
	void testCalculate() {
		Class1 c = new Class1();
		double result;

		result = c.Calculate(100, 1, 4);
		assertEquals(100, result);

		result = c.Calculate(100, 1, 2019);
		assertEquals(100, result);

		result = c.Calculate(100, 2, 2019);
		assertEquals(85, result);

		result = c.Calculate(100, 3, 2019);
		assertEquals(66, result);

		result = c.Calculate(100, 4, 2019);
		assertEquals(47, result);

		result = c.Calculate(100, 5, 2019);
		assertEquals(0, result);
	}

}
