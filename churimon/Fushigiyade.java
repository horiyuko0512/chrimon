package churimon;

public class Fushigiyade extends Monster3{

	public Fushigiyade() {
		// TODO 自動生成されたコンストラクター・スタブ
		super.setCharacter("フシギヤデ");
	}
	public Fushigiyade(String trainer, String name) {
		super(trainer, name);
		super.setCharacter("フシギヤデ");
	}
	public Fushigiyade(String trainer, String name, int lv) {
		super(trainer, name, lv);
		super.setCharacter("フシギヤデ");
	}

	public void levelUp(int upLevel) {
		setLv(getLv() + upLevel * 1);
		setHpMax(getHpMax() + upLevel * 16);
		setAtk(getAtk() + upLevel * 6);
		setDef(getDef() + upLevel * 7);
		setSpd(getSpd() + upLevel * 8);
		setHp(getHpMax());
	}

}
