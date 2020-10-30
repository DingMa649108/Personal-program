package persistence;

import model.Role;
import model.Skill;
import model.Item;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// some parts of this class is inspired by JsonSerializationDemo
// link for JsonSerializationDemo: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Role role = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyRoleCard() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyRoleCard.json");
        try {
            Role role = new Role();
            JsonWriter writer = new JsonWriter("./data/testReaderEmptyRoleCard.json");
            writer.open();
            writer.write(role);
            writer.close();

            role = reader.read();
            assertEquals("None", role.getName());
            assertEquals("None", role.getGender());
            assertEquals(0, role.getAge());
            assertEquals(0, role.getStrength());
            assertEquals(0, role.getConstitution());
            assertEquals(0, role.getPower());
            assertEquals(0, role.getDexterity());
            assertEquals(0, role.getAppearance());
            assertEquals(0, role.getSize());
            assertEquals(0, role.getIntelligence());
            assertEquals(0, role.getEducation());
            assertEquals(0, role.getLuck());
            assertEquals(0, role.getFreeSkillPoints());
            assertEquals(0, role.getHp());
            assertEquals(0, role.getSanity());
            assertEquals(0, role.getMovement());
            assertEquals(0, role.getBonusDamage());
            assertEquals(0, role.getItemList().size());
            assertEquals(0, role.getSkillList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralRoleCard() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralRoleCard.json");
        try {
            Role role = new Role();
            role.setJobArtist();
            role.setName("Ding");
            role.setAge(22);
            role.setGender("male");
            role.addJobSkills();
            role.setStrength(5);
            role.setConstitution(5);
            role.setPower(5);
            role.setDexterity(5);
            role.setAppearance(10);
            role.setSize(10);
            role.setIntelligence(10);
            role.setEducation(10);
            role.setLuck(15);
            role.setFreeSkillPoints(15);
            role.setHp(15);
            role.setSanity(15);
            role.setMovement(20);
            role.setBonusDamage(20);
            role.addItem("Bag");
            role.addItem("Knife");
            JsonWriter writer = new JsonWriter("./data/testReaderGeneralRoleCard.json");
            writer.open();
            writer.write(role);
            writer.close();

            role = reader.read();
            assertEquals("Ding", role.getName());
            assertEquals("male", role.getGender());
            assertEquals(22, role.getAge());
            assertEquals(5, role.getStrength());
            assertEquals(5, role.getConstitution());
            assertEquals(5, role.getPower());
            assertEquals(5, role.getDexterity());
            assertEquals(10, role.getAppearance());
            assertEquals(10, role.getSize());
            assertEquals(10, role.getIntelligence());
            assertEquals(10, role.getEducation());
            assertEquals(15, role.getLuck());
            assertEquals(15, role.getFreeSkillPoints());
            assertEquals(15, role.getHp());
            assertEquals(15, role.getSanity());
            assertEquals(20, role.getMovement());
            assertEquals(20, role.getBonusDamage());
            List<Item> items = role.getItemList();
            assertEquals(2, items.size());
            checkItem("Bag", items.get(0));
            checkItem("Knife", items.get(1));
            List<Skill> skills = role.getSkillList();
            assertEquals(7, skills.size());
            checkSkill("Art", 0 , skills.get(0));
            checkSkill("Bargain",0,  skills.get(1));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}