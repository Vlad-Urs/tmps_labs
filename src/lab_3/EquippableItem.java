package lab_3;

public class EquippableItem {
    private String itemName;
    private String boostedSkillType;
    private int boostAmount;

    public EquippableItem(String itemName, String boostedSkillType, int boostAmount) {
        this.itemName = itemName;
        this.boostedSkillType = boostedSkillType;
        this.boostAmount = boostAmount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBoostedSkillType() {
        return boostedSkillType;
    }

    public void setBoostedSkillType(String boostedSkillType) {
        this.boostedSkillType = boostedSkillType;
    }

    public int getBoostAmount() {
        return boostAmount;
    }

    public void setBoostAmount(int boostAmount) {
        this.boostAmount = boostAmount;
    }
}
