package model;

import java.util.ArrayList;

public class Policeman extends Job {
    public void setJob() {
        this.jobName = "Policeman";
        this.credit = 40;
        skillList = new ArrayList<>();
        skillList.add(new Skill("Club",0));
        skillList.add(new Skill("Drive Automobile",0));
        skillList.add(new Skill("Firearms",0));
        skillList.add(new Skill("Law",0));
        skillList.add(new Skill("Fist/Punch",0));
        skillList.add(new Skill("Grapple",0));
        skillList.add(new Skill("Kick",0));
        skillList.add(new Skill("Track",0));
        skillList.add(new Skill("Persuade",0));
    }
}
