package kent.bg.Harsha;

public class Game {
	private int[] rolls = new int[21];
	private int currentRoll;
	public void roll (int pins){
		rolls [currentRoll++] = pins;
	}
	public int score(){
		int score = 0;
		int frameIndex=0;
		for(int frame=0;frame< 10;frame++){
			if (isAStrike(frameIndex)){
				score +=10 + strikeBonus(frameIndex);
				frameIndex++;
			}
			else if (isASpare (frameIndex)){
				score +=10 + spareBonus(frameIndex);
				frameIndex +=2;
			}
			else {
				score += sumOfAllIBallsinFrame(frameIndex);
				frameIndex +=2;
				
			}
		}
		return score;
	}
	private int strikeBonus(int frameIndex){
		return rolls[frameIndex +1]+ rolls[frameIndex+2];
	}
	private int spareBonus(int frameIndex){
		return rolls[frameIndex +2];
	}
	private int sumOfAllIBallsinFrame(int frameIndex){
		return rolls[frameIndex] + rolls [frameIndex +1];
	}
	private boolean isASpare (int frameIndex){
		return rolls[frameIndex]+rolls[frameIndex +1]==10;
	}
	private boolean isAStrike(int frameIndex){
		return rolls[frameIndex]==10;
	}
}

