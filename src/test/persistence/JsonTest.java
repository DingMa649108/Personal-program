package persistence;

import model.Skill;
import model.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkSkill(String skillName, int skillPoints, Skill skill) {
        assertEquals(skillName, skill.getSkill());
        assertEquals(skillPoints, skill.getSkillPoints());
    }

    protected void checkItem(String ItemName, Item item) {
        assertEquals(ItemName, item.getItemName());
    }

}
