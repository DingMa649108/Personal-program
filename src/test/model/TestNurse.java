package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNurse {
    @Test
    public void testSetJob() {
        Job artist = new Nurse();
        artist.setJob();
        assertEquals("Nurse",artist.getName());
        assertEquals(35,artist.getCredit());
        assertEquals(8,artist.getSkillList().size());
    }
}
