package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSkill {
    @Test
    public void testConstructor() {
        Skill skill = new Skill("Punch", 10);
        assertEquals("Punch", skill.getSkill());
        assertEquals(10, skill.getSkillPoints());
    }

    @Test
    public void addSkill() {
        Skill skill = new Skill();
        skill.addSkillName("Kick");
        assertEquals("Kick", skill.getSkill());
    }

    @Test
    public void addSkillPoints() {
        Skill skill = new Skill("Talk", 10);
        skill.addSkillPoints(5);
        assertEquals(15, skill.getSkillPoints());
    }

    @Test
    public void removeSkillPoints() {
        Skill skill = new Skill("Talk", 10);
        skill.removeSkillPoints(5);
        assertEquals(5, skill.getSkillPoints());
    }

    @Test
    public void removeToString() {
        Skill skill = new Skill("Talk", 10);
        assertEquals("Talk 10", skill.toString());
    }
}
