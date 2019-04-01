package test.part1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.sun.tracing.dtrace.ArgsAttributes;

class NumberCountTest {

	@Test
	void testTest1() {
		NumberCount nc = new NumberCount();
		nc.test1(8, 100);
	}

	@Test
	void testTest2() {
		NumberCount nc = new NumberCount();
		nc.test2(8, 100);
	}

	@Test
	void testTest3() {
		NumberCount nc = new NumberCount();
		nc.test3(8, 100);
	}

	@Test
	void testMain() {
		NumberCount nc = new NumberCount();
		String[] args = null;
		nc.main(args);
	}

}
