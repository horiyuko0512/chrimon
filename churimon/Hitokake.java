package churimon;

public class Hitokake extends Monster3{

	//コンストラクタ
	public Hitokake() {
		// TODO 自動生成されたコンストラクター・スタブ
		super.setCharacter("ヒトカケ");
	}
	public Hitokake(String trainer, String name) {
		super(trainer, name);
		super.setCharacter("ヒトカケ");
	}
	public Hitokake(String trainer, String name, int lv) {
		super(trainer, name, lv);
		super.setCharacter("ヒトカケ");
	}

	public void levelUp(int upLevel) {
		setLv(getLv() + upLevel * 1);
		setHpMax(getHpMax() + upLevel * 14);
		setAtk(getAtk() + upLevel * 8);
		setDef(getDef() + upLevel * 5);
		setSpd(getSpd() + upLevel * 9);
		setHp(getHpMax());
	}
}
