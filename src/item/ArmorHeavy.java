package item;

import util.ResultMessage;

import java.util.Random;

public class ArmorHeavy extends Armor {
    /**
     * 重甲强化，加2-7血
     * @return
     */
    @Override
    public ResultMessage strength() {
        if (this.getLeftStrength() > 0) {
            this.setExtraHP(this.getExtraHP() + new Random().nextInt(6) + 2);
            this.setLeftStrength(this.getLeftStrength() - 1);
            return new ResultMessage(true, getName().concat("已强化，当前增加生命值" + String.valueOf(this.getExtraHP())), this.getExtraHP());
        } else {
            return new ResultMessage(false,"强化失败，剩余强化次数不够",this.getExtraHP());
        }
    }

    public ArmorHeavy(String name, String description, int extraHP) {
        this.setName(name);
        this.setArmorType("warrior");
        this.setDescription(description);
        this.setLevel(1);
        this.setExtraHP(extraHP);
    }

    public ResultMessage levelUp(){
        ResultMessage resultMessage;
        int level = this.getLevel();
        if (level < 100) {
            this.setExtraHP(this.getExtraHP() + level * 10);
            this.setLevel(level++);
            this.setValue(10 * level + new Random().nextInt(10));
            resultMessage = new ResultMessage(true, "盔甲已升级到" + String.valueOf(level) + "级", level);
            return resultMessage;
        } else {
            resultMessage = new ResultMessage(false, "武器升级失败，已达到100级", level);
            return resultMessage;
        }
    }
}
