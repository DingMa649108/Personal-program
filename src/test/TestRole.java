import model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRole {
    Role role;

    @BeforeEach
    public void setUp() {
        role = new Role();
    }

    @Test
    public void testSetStatesWithinRange() {
        for (int i = 0; i < 100000; i++) {
            role.setStates();
            assertTrue(role.getStrength() >= 15 && role.getStrength() <= 90);
            assertTrue(role.getConstitution() >= 15 && role.getConstitution() <= 90);
            assertTrue(role.getSize() >= 40 && role.getSize() <= 90);
            assertTrue(role.getDexterity() >= 15 && role.getDexterity() <= 90);
            assertTrue(role.getAppearance() >= 15 && role.getAppearance() <= 90);
            assertTrue(role.getIntelligence() >= 40 && role.getIntelligence() <= 90);
            assertTrue(role.getPower() >= 15 && role.getPower() <= 90);
            assertTrue(role.getEducation() >= 40 && role.getEducation() <= 90);
            assertTrue(role.getLuck() >= 15 && role.getLuck() <= 90);
        }
    }

    @Test
    public void testSetStatesRandom() {
        int count = 0;
        Role role2 = new Role();
        for (int i = 0; i < 100000; i++) {
            role.setStates();
            role2.setStates();
            if (role.getStrength() == role2.getStrength() &&
                    role.getConstitution() == role2.getConstitution() &&
                    role.getSize() == role2.getSize() &&
                    role.getDexterity() == role2.getDexterity() &&
                    role.getAppearance() == role2.getAppearance() &&
                    role.getIntelligence() == role2.getIntelligence() &&
                    role.getPower() == role2.getPower() &&
                    role.getEducation() == role2.getEducation() &&
                    role.getLuck() == role2.getLuck()) {
                count++;
            }
        }
        assertTrue(count < 20);
    }

    @Test
    public void testSetJobArtist() {
        role.setJobArtist();
        role.addJobSkills();
        assertEquals(7, role.getSkillList().size());
        assertEquals("Artist", role.getJob().getName());
        assertEquals(30, role.getCredit());
    }

    @Test
    public void testSetJobNurse() {
        role.setJobNurse();
        role.addJobSkills();
        assertEquals(8, role.getSkillList().size());
        assertEquals("Nurse", role.getJob().getName());
        assertEquals(35, role.getCredit());
    }

    @Test
    public void testSetJobPoliceman() {
        role.setJobPoliceman();
        role.addJobSkills();
        assertEquals(9, role.getSkillList().size());
        assertEquals("Policeman", role.getJob().getName());
        assertEquals(40, role.getCredit());
    }

    @Test
    public void testHalfValue() {
        for (int i = 0; i < 20; i++) {
            role.setStates();
            assertEquals(role.getStrength() / 2, role.halfValue(role.getStrength()));
            assertEquals(role.getConstitution() / 2, role.halfValue(role.getConstitution()));
            assertEquals(role.getSize() / 2, role.halfValue(role.getSize()));
            assertEquals(role.getDexterity() / 2, role.halfValue(role.getDexterity()));
            assertEquals(role.getAppearance() / 2, role.halfValue(role.getAppearance()));
            assertEquals(role.getIntelligence() / 2, role.halfValue(role.getIntelligence()));
            assertEquals(role.getPower() / 2, role.halfValue(role.getPower()));
            assertEquals(role.getEducation() / 2, role.halfValue(role.getEducation()));
            assertEquals(role.getLuck() / 2, role.halfValue(role.getLuck()));
        }
    }

    @Test
    public void testFifthValue() {
        for (int i = 0; i < 20; i++) {
            role.setStates();
            assertEquals(role.getStrength() / 5, role.fifthValue(role.getStrength()));
            assertEquals(role.getConstitution() / 5, role.fifthValue(role.getConstitution()));
            assertEquals(role.getSize() / 5, role.fifthValue(role.getSize()));
            assertEquals(role.getDexterity() / 5, role.fifthValue(role.getDexterity()));
            assertEquals(role.getAppearance() / 5, role.fifthValue(role.getAppearance()));
            assertEquals(role.getIntelligence() / 5, role.fifthValue(role.getIntelligence()));
            assertEquals(role.getPower() / 5, role.fifthValue(role.getPower()));
            assertEquals(role.getEducation() / 5, role.fifthValue(role.getEducation()));
            assertEquals(role.getLuck() / 5, role.fifthValue(role.getLuck()));
        }
    }

    @Test
    public void testSetBonusDamage() {
        role.setStrength(16);
        role.setSize(40);
        role.setBonusDamage();
        assertEquals(-1, role.getBonusDamage());
        role.setStrength(60);
        role.setSize(36);
        role.setBonusDamage();
        assertEquals(-1, role.getBonusDamage());
        role.setStrength(40);
        role.setSize(40);
        role.setBonusDamage();
        assertEquals(-1, role.getBonusDamage());
        role.setStrength(36);
        role.setSize(61);
        role.setBonusDamage();
        assertEquals(0, role.getBonusDamage());
        role.setStrength(77);
        role.setSize(61);
        role.setBonusDamage();
        assertEquals(0, role.getBonusDamage());
        role.setStrength(66);
        role.setSize(55);
        role.setBonusDamage();
        assertEquals(0, role.getBonusDamage());
        role.setStrength(77);
        role.setSize(62);
        role.setBonusDamage();
        assertEquals(1, role.getBonusDamage());
        role.setStrength(88);
        role.setSize(77);
        role.setBonusDamage();
        assertEquals(1, role.getBonusDamage());
        role.setStrength(90);
        role.setSize(90);
        role.setBonusDamage();
        assertEquals(1, role.getBonusDamage());
        role.setStrength(0);
        role.setSize(0);
        role.setBonusDamage();
        assertEquals(0, role.getBonusDamage());
        role.setStrength(100);
        role.setSize(100);
        role.setBonusDamage();
        assertEquals(0, role.getBonusDamage());
    }

    @Test
    public void testSetHitPoints() {
        for (int i = 0; i < 20; i++) {
            role.setStates();
            role.setHitPoints();
            assertEquals((role.getSize() + role.getConstitution()) / 10, role.getHp());
        }
    }

    @Test
    public void testSetSanity() {
        for (int i = 0; i < 20; i++) {
            role.setStates();
            role.setSanity();
            assertEquals(role.getPower(), role.getSanity());
        }
    }

    @Test
    public void testSetJobSkillPointsArtist() {
        for (int i = 0; i < 20; i++) {
            role.setJobArtist();
            role.addJobSkills();
            role.setStates();
            role.setFreeSkillPoints();
            assertEquals(role.getEducation() * 2 + role.getPower() * 2 + role.getIntelligence() * 2,
                    role.getFreeSkillPoints());
        }
    }

    @Test
    public void testSetJobSkillPointsNurse() {
        for (int i = 0; i < 20; i++) {
            role.setJobNurse();
            role.addJobSkills();
            role.setStates();
            role.setFreeSkillPoints();
            assertEquals(role.getEducation() * 4 + role.getIntelligence() * 2,
                    role.getFreeSkillPoints());
        }
    }

    @Test
    public void testSetJobSkillPointsPoliceman() {
        for (int i = 0; i < 20; i++) {
            role.setJobPoliceman();
            role.addJobSkills();
            role.setStates();
            role.setFreeSkillPoints();
            assertEquals(role.getEducation() * 2 + role.getStrength() * 2 + role.getIntelligence() * 2,
                    role.getFreeSkillPoints());
        }
    }

    @Test
    public void testSetJobSkillPointsNoJob() {
        for (int i = 0; i < 20; i++) {
            role.setStates();
            role.setFreeSkillPoints();
            assertEquals(0, role.getFreeSkillPoints());
        }
    }

    @Test
    public void testSetMovementYoung() {
        role.setAge(60);
        role.setSize(10);
        role.setDexterity(5);
        role.setStrength(5);
        role.setMovement();
        assertEquals(9, role.getMovement());
        role.setSize(10);
        role.setDexterity(15);
        role.setStrength(10);
        role.setMovement();
        assertEquals(8, role.getMovement());
        role.setSize(10);
        role.setDexterity(10);
        role.setStrength(15);
        role.setMovement();
        assertEquals(8, role.getMovement());
        role.setSize(10);
        role.setDexterity(5);
        role.setStrength(15);
        role.setMovement();
        assertEquals(8, role.getMovement());
        role.setSize(10);
        role.setDexterity(15);
        role.setStrength(5);
        role.setMovement();
        assertEquals(8, role.getMovement());
        role.setSize(10);
        role.setDexterity(10);
        role.setStrength(10);
        role.setMovement();
        assertEquals(8, role.getMovement());
        role.setSize(10);
        role.setDexterity(15);
        role.setStrength(15);
        role.setMovement();
        assertEquals(7, role.getMovement());
    }

    @Test
    public void testSetMovementOld() {
        role.setAge(61);
        role.setSize(10);
        role.setDexterity(5);
        role.setStrength(5);
        role.setMovement();
        assertEquals(7, role.getMovement());
        role.setSize(10);
        role.setDexterity(15);
        role.setStrength(10);
        role.setMovement();
        assertEquals(6, role.getMovement());
        role.setSize(10);
        role.setDexterity(10);
        role.setStrength(15);
        role.setMovement();
        assertEquals(6, role.getMovement());
        role.setSize(10);
        role.setDexterity(5);
        role.setStrength(15);
        role.setMovement();
        assertEquals(6, role.getMovement());
        role.setSize(10);
        role.setDexterity(15);
        role.setStrength(5);
        role.setMovement();
        assertEquals(6, role.getMovement());
        role.setSize(10);
        role.setDexterity(10);
        role.setStrength(10);
        role.setMovement();
        assertEquals(6, role.getMovement());
        role.setSize(10);
        role.setDexterity(15);
        role.setStrength(15);
        role.setMovement();
        assertEquals(5, role.getMovement());
    }

    @Test
    public void testAddSkills() {
        role.setStates();
        role.setJobArtist();
        role.addJobSkills();
        role.setFreeSkillPoints();
        int points = role.getFreeSkillPoints();
        role.addSkills("Sleep", 10);
        role.addSkills("Eat", 10);
        role.addSkills("Drive", 10);
        assertEquals(10, role.getSkillList().size());
        assertEquals(points - 30, role.getFreeSkillPoints());
    }

    @Test
    public void testRemoveSkillsInList() {
        role.setStates();
        role.setJobArtist();
        role.addJobSkills();
        role.setFreeSkillPoints();
        int points = role.getFreeSkillPoints();
        role.addSkills("Sleep", 10);
        role.addSkills("Eat", 10);
        role.addSkills("Drive", 10);
        assertEquals(10, role.getSkillList().size());
        assertEquals(points - 30, role.getFreeSkillPoints());
        assertTrue(role.removeSkill("sleep"));
        assertEquals(9, role.getSkillList().size());
        assertEquals(points - 20, role.getFreeSkillPoints());
    }

    @Test
    public void testRemoveSkillsNotInList() {
        role.setStates();
        role.setJobArtist();
        role.addJobSkills();
        role.setFreeSkillPoints();
        int points = role.getFreeSkillPoints();
        role.addSkills("Sleep", 10);
        role.addSkills("Eat", 10);
        role.addSkills("Drive", 10);
        assertEquals(10, role.getSkillList().size());
        assertEquals(points - 30, role.getFreeSkillPoints());
        assertFalse(role.removeSkill("jump"));
        assertEquals(10, role.getSkillList().size());
        assertEquals(points - 30, role.getFreeSkillPoints());
    }

    @Test
    public void testAddSkillPoints() {
        role.setStates();
        role.setJobArtist();
        role.addJobSkills();
        role.setFreeSkillPoints();
        int points = role.getFreeSkillPoints();
        role.addSkills("Sleep", 10);
        role.addSkills("Eat", 10);
        role.addSkills("Drive", 10);
        assertEquals(10, role.getSkillList().size());
        assertEquals(points - 30, role.getFreeSkillPoints());
        assertTrue(role.addSkillsPoints("Sleep", 10));
        assertFalse(role.addSkillsPoints("Eat", 100));
        assertEquals(20, role.getSkillList().get(role.getSkillIndex("Sleep")).getSkillPoints());
        assertEquals(points - 40, role.getFreeSkillPoints());
    }

    @Test
    public void testRemoveSkillPoints() {
        role.setStates();
        role.setJobArtist();
        role.addJobSkills();
        role.setFreeSkillPoints();
        int points = role.getFreeSkillPoints();
        role.addSkills("Sleep", 10);
        role.addSkills("Eat", 10);
        role.addSkills("Drive", 10);
        assertEquals(10, role.getSkillList().size());
        assertEquals(points - 30, role.getFreeSkillPoints());
        assertTrue(role.removeSkillPoints("Sleep", 5));
        assertFalse(role.removeSkillPoints("Eat", points));
        assertEquals(5, role.getSkillList().get(role.getSkillIndex("Sleep")).getSkillPoints());
        assertEquals(points - 25, role.getFreeSkillPoints());
    }

    @Test
    public void testAddItem() {
        role.addItem("Flash Light");
        role.addItem("Knife");
        role.addItem("Pills");
        assertEquals(3, role.getItemList().size());
    }

    @Test
    public void testRemoveItem() {
        role.addItem("Flash Light");
        role.addItem("Knife");
        role.addItem("Pills");
        role.removeItems(role.getItemsIndex("Pills"));
        assertEquals(2, role.getItemList().size());
    }

    @Test
    public void testAddHP() {
        role.setStates();
        role.setHitPoints();
        int hp = (role.getSize() + role.getConstitution()) / 10;
        role.addHP(5);
        assertEquals(hp + 5, role.getHp());
    }

    @Test
    public void testRemoveHP() {
        role.setStates();
        role.setHitPoints();
        int hp = (role.getSize() + role.getConstitution()) / 10;
        role.removeHP(5);
        assertEquals(hp - 5, role.getHp());
    }

    @Test
    public void testAddSan() {
        role.setStates();
        role.setSanity();
        int san = role.getPower();
        role.addSan(5);
        assertEquals(san + 5, role.getSanity());
    }

    @Test
    public void testRemoveSan() {
        role.setStates();
        role.setSanity();
        int san = role.getPower();
        role.removeSan(5);
        assertEquals(san - 5, role.getSanity());
    }

    @Test
    public void testGetItemIndexNone() {
        role.addItem("Flash Light");
        role.addItem("Knife");
        role.addItem("Pills");
        assertEquals(-1, role.getItemsIndex("Bag"));
    }

    @Test
    public void testGetSkillsNone() {
        role.setStates();
        role.setJobArtist();
        role.addJobSkills();
        role.setFreeSkillPoints();
        int points = role.getFreeSkillPoints();
        role.addSkills("Sleep", 10);
        role.addSkills("Eat", 10);
        role.addSkills("Drive", 10);
        assertEquals(-1, role.getSkillIndex("Run"));
    }

    @Test
    public void testGenerallSetterAndGetter() {
        role.setName("Ding");
        role.setAge(20);
        role.setGender("male");
        assertEquals("Ding", role.getName());
        assertEquals(20, role.getAge());
        assertEquals("male", role.getGender());
    }

    @Test
    public void dicesInRange() {
        for (int i = 0; i < 100; i++) {
            assertTrue(1 <= role.rollD3() && role.rollD3() <= 3);
            assertTrue(1 <= role.rollD6() && role.rollD6() <= 6);
            assertTrue(1 <= role.rollD20() && role.rollD20() <= 20);
            assertTrue(1 <= role.rollD100() && role.rollD100() <= 100);
        }
    }

    @Test
    public void dicesRandom() {
        int count = 0;
        Role role2 = new Role();
        for (int i = 0; i < 100; i++) {
            if (role.rollD3() == role2.rollD3()
                    && role.rollD6() == role2.rollD6()
                    && role.rollD20() == role2.rollD20()
                    && role.rollD100() == role2.rollD100()) {
                count++;
            }
        }
        assertTrue(count != 100);
    }
}
