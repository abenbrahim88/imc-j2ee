package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import models.Person;
public class TestPerson {
	Person P1,P2,P3,P4,P5,P6,P7,P8,P9;

	@Before
	public void setUp() {

		P1=new Person(1.50,1);
		P2=new Person(1.50,-1);
		P3=new Person(2.50,65);
		P4=new Person(-2.50,65);
		P5=new Person(2.50,1);
		P6=new Person(-2.50,-1);
		P7=new Person(0,45);
		P8=new Person(1.45,0);
		P9=new Person(1.72,55);
	}

	@Test
	//person with bad value of weight and correct value of height
	public void testBadValueOfWeight() {
		assertEquals("bad value",P1.CalculateIMC());
		assertEquals("bad value",P2.CalculateIMC());

	}
	@Test
	//person with bad value of height and correct value of weight
	public void testBadValueOfHeight() {
		assertEquals("bad value",P3.CalculateIMC());
		assertEquals("bad value",P4.CalculateIMC());
	}
	@Test
	//person with bad values of height and weight
	public void testBadValueOfWeightandHeight() {
		assertEquals("bad value",P5.CalculateIMC());
		assertEquals("bad value",P6.CalculateIMC());
		;
	}
	@Test
	// person with zero in height
	public void testBadValueOfZeroHeight() {
		assertEquals("bad value",P7.CalculateIMC());
	}
	@Test
	//person with zero in weight
	public void testBadValueOfZeroWeight() {
		assertEquals("bad value",P8.CalculateIMC());
	}
	@Test
	//person with correct values of height and weight
	public void testCorrectValueOfWeightAndHeight() {
		assertEquals("18.59",P9.CalculateIMC());
	}


}
