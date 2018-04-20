package application;

public class Game {
	
	private Team team1, team2;
	private int[] score;
	private boolean isCompleted;
	private Team winner;
	

	Game(){
		team1 = new Team(); team2 = new Team();
		winner = team1;
		boolean isCompleted = true;
		score = new int[]{0, 0};
	}
	Game(Team team1, Team team2){
		this(team1, team2, 0, 0);
	}
	Game(Team team1, Team team2, int[] score){
		this.team1 = team1;
		this.team2 = team2;
		this.score = score;
		this.isCompleted = false;
		this.winner = null;
	}
	Game(Team team1, Team team2, int score1, int score2){
		this(team1, team2, new int[]{score1, score2});
	}
	
	//Setters
	public void setWinner(Team team){winner = team;}
	public void setWinner(boolean team1Won){winner = (team1Won) ? team1 : team2;}
	public void setScore(int score1, int score2){score[0] = score1; score[1] = score2;}
	public void setScore(int[] scores){score = scores;}
	public void setCompleted(boolean isCompleted){this.isCompleted = isCompleted;}
	
	//Getters
	public int[] getScores(){return score;}
	public Team getWinner(){return winner;}
	public boolean getCompleted(){return isCompleted;}
	public Team getTeam1(){return team1;}
	public Team getTeam2(){return team2;}
	
	//Methods
	public void completeGame(){
		if (score[0] == score[1]){ // tie
			winner = (team1.compareTo(team2) > 0) ? team1 : team2;
		} else winner = (score[0] > score[1]) ? team1 : team2;
		isCompleted = true;
		team1.addScore(score[0]);
		team2.addScore(score[1]);
	}
	
}
