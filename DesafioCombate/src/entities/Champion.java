package entities;

public class Champion {

	private String name;
	private int life;
	private int attack;
	private int armor;

	public String getName(){
		return this.name;
	}

	public String setName(String name){
		return this.name = name;
	}

	public int getLife(){
		return this.life;
	}

	public int setLife(int life){
		return this.life = life;
	}

	public int getAttack(){
		return this.attack;
	}

	public int setAttack(int attack) {
		return this.attack = attack;
	}

	public int getArmor() {
		return this.armor;
	}

	public int setArmor(int armor) {
		return this.armor = armor;
	}

	public void takeDamage(Champion champion1, Champion champion2) {

		int damageChampion1 = champion1.getLife() - (champion2.getAttack() - champion1.getArmor());
		int damageChampion2 = champion2.getLife() - (champion1.getAttack() - champion2.getArmor());
			

		if(champion1.getAttack() < champion2.getArmor()){
			champion2.setLife(champion2.getLife() - 1);
		} else {
			champion2.setLife(damageChampion2);
		}

		if(champion2.getAttack() < champion1.getArmor()){
			champion1.setLife(champion1.getLife() - 1);
		} else {
			champion1.setLife(damageChampion1);
		}
	}

	public static String status(Champion champion){
		String gameOver = champion.getName() + ": 0 de vida (morreu)";
		String status1 = champion.getName() + ": " + champion.getLife() + " de vida";

		if(champion.getLife() < 1) {
			return gameOver;
		} else {
			return status1;
		}
	}
}
