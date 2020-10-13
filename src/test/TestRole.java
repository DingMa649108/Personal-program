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
        for(int i = 0; i<20; i++) {
            role.setStates();
            assertTrue(role.getStrength()>=15 && role.getStrength()<=90);
            assertTrue(role.getConstitution()>=15&&role.getConstitution()<=90);
            assertTrue(role.getSize()>=40&&role.getSize()<=90);
            assertTrue(role.getDexterity()>=15&&role.getDexterity()<=90);
            assertTrue(role.getAppearance()>=15&&role.getAppearance()<=90);
            assertTrue(role.getIntelligence()>=40&&role.getIntelligence()<=90);
            assertTrue(role.getPower()>=15&&role.getPower() <=90);
            assertTrue(role.getEducation()>=40&&role.getEducation()<=90);
            assertTrue(role.getLuck()>=15&&role.getLuck()<=90);
        }
    }
    @Test
    public void testSetStatesRandom() {
        int count = 0;
        Role role2 = new Role();
        for(int i = 0; i<20; i++) {
            role.setStates();
            role2.setStates();
            if(role.getStrength() == role2.getStrength() &&
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
        assertEquals(7,role.getSkillList().size());
        assertEquals("Artist",role.getJob().getName());
        assertEquals(30,role.getCredit());
    }
    @Test
    public void testSetJobNurse() {
        role.setJobNurse();
        assertEquals(8,role.getSkillList().size());
        assertEquals("Nurse",role.getJob().getName());
        assertEquals(35,role.getCredit());
    }
    @Test
    public void testSetJobPoliceman() {
        role.setJobPoliceman();
        assertEquals(9,role.getSkillList().size());
        assertEquals("Policeman",role.getJob().getName());
        assertEquals(40,role.getCredit());
    }
    @Test
    public void testHalfValue() {
        for(int i = 0; i<20; i++) {
            role.setStates();
            assertTrue(role.getStrength() / 2 == role.halfValue(role.getStrength()));
            assertTrue(role.getConstitution() / 2 == role.halfValue(role.getConstitution()));
            assertTrue(role.getSize() / 2 == role.halfValue(role.getSize()));
            assertTrue(role.getDexterity() / 2 == role.halfValue(role.getDexterity()));
            assertTrue(role.getAppearance() / 2 == role.halfValue(role.getAppearance()));
            assertTrue(role.getIntelligence() / 2 == role.halfValue(role.getIntelligence()));
            assertTrue(role.getPower() / 2 == role.halfValue(role.getPower()));
            assertTrue(role.getEducation() / 2 == role.halfValue(role.getEducation()));
            assertTrue(role.getLuck() / 2 == role.halfValue(role.getLuck()));
        }
    }
    @Test
    public void testFifthValue() {
        for(int i = 0; i<20; i++) {
            role.setStates();
            assertTrue(role.getStrength() / 5 == role.fifthValue(role.getStrength()));
            assertTrue(role.getConstitution() / 5 == role.fifthValue(role.getConstitution()));
            assertTrue(role.getSize() / 5 == role.fifthValue(role.getSize()));
            assertTrue(role.getDexterity() / 5 == role.fifthValue(role.getDexterity()));
            assertTrue(role.getAppearance() / 5 == role.fifthValue(role.getAppearance()));
            assertTrue(role.getIntelligence() / 5 == role.fifthValue(role.getIntelligence()));
            assertTrue(role.getPower() / 5 == role.fifthValue(role.getPower()));
            assertTrue(role.getEducation() / 5 == role.fifthValue(role.getEducation()));
            assertTrue(role.getLuck() / 5 == role.fifthValue(role.getLuck()));
        }
    }
    @Test
    public void testSetBonusDamage() {
        for(int i = 0; i<20; i++) {
            role.setStates();
            role.setBonusDamage();
            if ((role.getStrength() + role.getSize()) >= 2 && (role.getStrength() + role.getSize()) < 85) {
                assertEquals(-1,role.getBonusDamage());
            } else if ((role.getStrength() + role.getSize()) >= 85 && (role.getStrength() + role.getSize()) < 124) {
                assertEquals(0,role.getBonusDamage());
            } else if (((role.getStrength() + role.getSize()) >= 124 && (role.getStrength() + role.getSize()) <= 180)) {
                assertEquals(1,role.getBonusDamage());
            }
        }
    }
    @Test
    public void testSetHitPoints() {
        for(int i = 0; i<20; i++) {
            role.setStates();
            role.setHitPoints();
            assertEquals((role.getSize() + role.getConstitution()) / 10 , role.getHp());
        }
    }
    @Test
    public void testSetSanity() {
        for(int i = 0; i<20; i++) {
            role.setStates();
            role.setSanity();
            assertEquals(role.getPower() , role.getSanity());
        }
    }
    @Test
    public void testSetJobSkillPointsArtist() {
        for(int i = 0; i<20; i++) {
            role.setJobArtist();
            role.setStates();
            role.setFreeSkillPoints();
            assertEquals(role.getEducation() * 2 + role.getPower() * 2 + role.getIntelligence() * 2 ,
                    role.getFreeSkillPoints());
        }
    }
    @Test
    public void testSetJobSkillPointsNurse() {
        for(int i = 0; i<20; i++) {
            role.setJobNurse();
            role.setStates();
            role.setFreeSkillPoints();
            assertEquals(role.getEducation() * 4 + role.getIntelligence() * 2 ,
                    role.getFreeSkillPoints());
        }
    }
    @Test
    public void testSetJobSkillPointsPoliceman() {
        for(int i = 0; i<20; i++) {
            role.setJobPoliceman();
            role.setStates();
            role.setFreeSkillPoints();
            assertEquals(role.getEducation() * 2 + role.getStrength() * 2 + role.getIntelligence() * 2 ,
                    role.getFreeSkillPoints());
        }
    }
    @Test
    public void testSetMovement() {
        for(int i = 0; i<20; i++) {
            role.setAge(role.rollD100());
            role.setStates();
            role.setMovement();
            if (role.getStrength() < role.getSize() && role.getDexterity() < role.getSize()) {
                if (role.getAge()> 60) {
                    assertEquals(5,role.getMovement());
                }
            } else if (role.getStrength() == role.getSize() && role.getDexterity() == role.getSize()) {
                if (role.getAge()> 60) {
                    assertEquals(6,role.getMovement());
                }
            } else if (role.getStrength() > role.getSize() || role.getDexterity() > role.getSize()) {
                if (role.getAge()> 60) {
                    assertEquals(6,role.getMovement());
                }
            } else {
                if (role.getAge()> 60) {
                    assertEquals(7,role.getMovement());
                }
            }
        }
    }
    @Test
    public void testAddSkills() {
        role.setStates();
        role.setJobArtist();
        role.setFreeSkillPoints();
        int points = role.getFreeSkillPoints();
        role.addSkills("Sleep",10);
        role.addSkills("Eat",10);
        role.addSkills("Drive",10);
        assertEquals(10,role.getSkillList().size());
        assertEquals(points-30,role.getFreeSkillPoints());
    }
    @Test
    public void testAddSkillPoints() {
        role.setStates();
        role.setJobArtist();
        role.setFreeSkillPoints();
        int points = role.getFreeSkillPoints();
        role.addSkills("Sleep",10);
        role.addSkills("Eat",10);
        role.addSkills("Drive",10);
        assertEquals(10,role.getSkillList().size());
        assertEquals(points-30,role.getFreeSkillPoints());
        assertTrue(role.addSkillsPoints("Sleep",10));
        assertFalse(role.addSkillsPoints("Eat",100));
        assertEquals(20,role.getSkillList().get(role.getSkill("Sleep")).getSkillPoints());
        assertEquals(points-40,role.getFreeSkillPoints());
    }
    @Test
    public void testRemoveSkillPoints() {
        role.setStates();
        role.setJobArtist();
        role.setFreeSkillPoints();
        int points = role.getFreeSkillPoints();
        role.addSkills("Sleep",10);
        role.addSkills("Eat",10);
        role.addSkills("Drive",10);
        assertEquals(10,role.getSkillList().size());
        assertEquals(points-30,role.getFreeSkillPoints());
        assertTrue(role.removeSkillPoints("Sleep",5));
        assertFalse(role.removeSkillPoints("Eat",points));
        assertEquals(5,role.getSkillList().get(role.getSkill("Sleep")).getSkillPoints());
        assertEquals(points-25,role.getFreeSkillPoints());
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
}
