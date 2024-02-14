package churimon;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Monster3 {


	//フィールド
	private String character;  //種族
	private String trainer;       //トレーナー
	private String name;        //名前
	private int lv;                      //レベル
	private int hp;                     //HP
	private int atk;                    //攻撃
	private int def;	                 //防御
	private int spd;                    //スピード
	private int hpMax;	                 //HP初期値
	private String wazaNm;    //技
	private String wazaDmgRate;	     //技倍率

	//定数
	final String WAZA_DMG_RATE_REGEXP = "^[0-9]+\\.[0-9]$";
	final String DMG_CORRECTION_120 = "120";
	final String DMG_CORRECTION_1   = "1";
	
	//コンストラクタ
	Monster3(){
		this.character = "(unknown)";
		this.trainer = "(wild)";
		this.name = "(noname)";
		this.lv = 1;
		this.hp = 30;
		this.atk = 15;
		this.def = 10;
		this.spd = 10;
		this.hpMax = 30;
		this.wazaNm = "たいあたり";
		this.wazaDmgRate = "1.0";
	}
	Monster3(String trainer, String name){
		this();
		this.trainer = trainer;
		this.name = name;
	}
	Monster3(String trainer, String name, int lv){
		this(trainer, name);
		if(lv > 1) {
			levelUp(lv - 1);
		}
	}
	

	public String toString() {
		String status = " [ " + name + " lv" + lv + " HP" + hp + "/" + hpMax + " ] "
				+ "(status) character:" + character + " trainer:" + trainer 
				+ " atk:" + atk + " def:" + def + "spd:" + spd + " wazaNm:"
				+ wazaNm + " wazaDmRate:" + wazaDmgRate; 
		return status;
	}

	public void levelUp(int upLevel) {
		lv += upLevel * 1;
		hpMax += upLevel * 15; 
		atk += upLevel * 5;
		def += upLevel * 5;
		spd += upLevel * 5;
		hp = hpMax;
	}

	public void setWaza(String wazaName, String wazaDR) {
		if(wazaDR.matches(WAZA_DMG_RATE_REGEXP)) {
			wazaNm = wazaName;
			wazaDmgRate = wazaDR;
		}
		else {
			System.out.println("[ERROR]技の設定に失敗しました");
		}
	}

	public String getStatus() {
		String status = " [ " + name + " lv" + lv + " HP" + hp + "/" + hpMax + " ]";
		return status;
	}

	public int useWaza() {
		BigDecimal atak = new BigDecimal(atk);
		BigDecimal DmgRate = new BigDecimal(wazaDmgRate);
		int dmg = (atak.multiply(DmgRate)).intValue();
		return dmg;
	}

	public int damaged(int dmg) {
		BigDecimal bddmg = new BigDecimal(dmg);
		BigDecimal dmgCor1 = new BigDecimal(DMG_CORRECTION_120);
		BigDecimal dmgCor2 = new BigDecimal(DMG_CORRECTION_1);
		BigDecimal defe = new BigDecimal(def);
		BigDecimal dmgSubRate = dmgCor1.divide(dmgCor1.add(defe.divide(dmgCor2)),2,RoundingMode.DOWN);
		int realdmg = bddmg.multiply(dmgSubRate).intValue();

		if(realdmg < hp) {	
			hp -= realdmg;
		}
		else {
			hp = 0;
		}
		return realdmg;
	}
	
	//getter,setter
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getSpd() {
		return spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}
	public int getHpMax() {
		return hpMax;
	}
	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}
	public String getWazaNm() {
		return wazaNm;
	}
	public void setWazaNm(String wazaNm) {
		this.wazaNm = wazaNm;
	}
	public String getWazaDmgRate() {
		return wazaDmgRate;
	}
	public void setWazaDmgRate(String wazaDmgRate) {
		this.wazaDmgRate = wazaDmgRate;
	}
}

