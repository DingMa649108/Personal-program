import model.Job;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestJob {
    @Test
    public void testSetJob() {
        Job job = new Job();
        job.setJob();
        assertEquals("None",job.getName());
        assertEquals(0,job.getCredit());
        assertEquals(0,job.getSkillList().size());
    }
}
