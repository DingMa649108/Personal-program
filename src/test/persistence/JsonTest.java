package persistence;

import model.Skill;
import model.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

// some parts of this class is inspired by JsonSerializationDemo
// link for JsonSerializationDemo: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonTest {
    protected void checkSkill(String skillName, int skillPoints, Skill skill) {
        assertEquals(skillName, skill.getSkill());
        assertEquals(skillPoints, skill.getSkillPoints());
    }

    protected void checkItem(String ItemName, Item item) {
        assertEquals(ItemName, item.getItemName());
    }

}
