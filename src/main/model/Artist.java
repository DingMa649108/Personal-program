package model;

import java.util.ArrayList;

public class Artist extends Job {

    @Override
    public void setJob() {
        this.jobName = "Artist";
        this.credit = 30;
        skillList = new ArrayList<>();
        skillList.add(new Skill("Art", 0));
        skillList.add(new Skill("Bargain", 0));
        skillList.add(new Skill("History", 0));
        skillList.add(new Skill("Library Use", 0));
        skillList.add(new Skill("Persuade", 0));
        skillList.add(new Skill("Photography", 0));
        skillList.add(new Skill("Psychology", 0));
    }
}
