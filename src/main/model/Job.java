package model;

import java.util.ArrayList;
import java.util.List;

public class Job {
    protected String jobName;     // Job name
    protected int credit;         // A measure of job class
    List<Skill> skillList;        // A list of skill this job have

    //EFFECTS: set up all information for a job
    public void setJob() {
        jobName = "None";
        credit = 0;
        skillList = new ArrayList<>();
    }

    public String getName() {
        return jobName;
    }

    public int getCredit() {
        return credit;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }


}
