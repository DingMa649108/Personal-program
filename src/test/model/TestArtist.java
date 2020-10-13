package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestArtist {
    @Test
    public void testSetJob() {
        Job artist = new Artist();
        artist.setJob();
        assertEquals("Artist", artist.getName());
        assertEquals(30, artist.getCredit());
        assertEquals(7, artist.getSkillList().size());
    }

}
