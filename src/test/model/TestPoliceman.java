package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPoliceman {
    @Test
    public void testSetJob() {
        Job artist = new Policeman();
        artist.setJob();
        assertEquals("Policeman", artist.getName());
        assertEquals(40, artist.getCredit());
        assertEquals(9, artist.getSkillList().size());
    }
}
