package model;

import java.util.ArrayList;

public class Nurse extends Job {
    public void setJob() {
        this.jobName = "Nurse";
        this.credit = 35;
        skillList = new ArrayList<>();
        skillList.add(new Skill("Biology",0));
        skillList.add(new Skill("Psychology",0));
        skillList.add(new Skill("First Aid",0));
        skillList.add(new Skill("Computer Use",0));
        skillList.add(new Skill("Persuade",0));
        skillList.add(new Skill("Medicine",0));
        skillList.add(new Skill("Pharmacy",0));
        skillList.add(new Skill("Reputation",0));
    }
}
