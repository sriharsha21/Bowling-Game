package kent.bg.Harsha;


import static org.junit.Assert.*;

import org.junit.Test;


public class Testgame {
	private Game game = new Game();
 
	@Test
	public void testforgutterGame() throws Exception  {
		rollBall (20,0);
		assertEquals(0,game.score());
		
	}
	@Test
	public void testforallones () throws Exception {
		rollBall(20,1);
		assertEquals(20,game.score());
	}
	@Test
	public void testforOnespare () throws Exception {
		rollspare();
		game.roll(3);
		rollBall(17,0);
		assertEquals(16,game.score());
	}
	@Test
	public void testForOneStrike () throws Exception {
		rollStrike();
		game.roll(5);
		game.roll(3);
		rollBall(16,0);
		assertEquals(26,game.score());
	}
	@Test
	public void testForPerfectGame () throws Exception {
		rollBall (12,10);
		assertEquals(300,game.score());
	}
	
	private void rollStrike(){
		game.roll(10);
	}
	
	private void rollspare(){
		game.roll(5);
		game.roll(5);
	}
	
	private void rollBall (int n,int pins){
		for (int i=0;i<n;i++){
			game.roll(pins);
		}
	}
}
