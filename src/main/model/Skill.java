package model;

import org.json.JSONObject;
import persistence.Writable;

public class Skill implements Writable {

    private String skill;       // Skill's name
    private int skillPoints;    // A measure of how professional the skill is

    public Skill() {
        this.skill = null;
        this.skillPoints = 0;
    }

    //REQUIRES: skill points greater or equal to 0
    //EFFECTS: set up information for a skill
    public Skill(String skill, int skillPoints) {
        this.skill = skill;
        this.skillPoints = skillPoints;
    }

    public void addSkillName(String skill) {
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public String toString() {
        return skill + " " + skillPoints;
    }

    //REQUIRES: points greater or equal to 0, point smaller than 99
    //MODIFIES: this
    //EFFECTS: add given points to skills skill points.
    public void addSkillPoints(int points) {
        this.skillPoints += points;
    }

    //REQUIRES: points smaller or equal to current skill points
    //MODIFIES: this
    //EFFECTS: remove given points to skills skill points.
    public void removeSkillPoints(int points) {
        this.skillPoints -= points;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Skill name", skill);
        json.put("Skill points", skillPoints);
        return json;
    }

}
