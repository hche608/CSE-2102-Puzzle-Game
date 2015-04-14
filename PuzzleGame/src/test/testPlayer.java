package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import application.Player;

public class testPlayer {

	Player p1 = new Player();
	Player p2 = new Player("Hao");

	@Test
	public void testGetPlayerName() {
		assertEquals(p1.getPlayerName(), "Alex");
		assertEquals(p2.getPlayerName(), "Hao");
	}

	@Test
	public void testSetPlayerName() {
		p1.setPlayerName("TestName");
		p2.setPlayerName("TestName");
		assertEquals(p1.getPlayerName(), "TestName");
		assertEquals(p2.getPlayerName(), "TestName");
	}

	@Test
	public void testGetScore() {
		assertEquals(p1.getScore(), 0);
		assertEquals(p2.getScore(), 0);
	}

	@Test
	public void testSetScore() {
		p1.setScore(10);
		p2.setScore(20);
		assertEquals(p1.getScore(), 10);
		assertEquals(p2.getScore(), 20);
	}

}
