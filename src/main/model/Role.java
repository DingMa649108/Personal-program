package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Represent a character having name, age, gender, states, skills, and items.
public class Role {
    private String name;            // Character's name
    private int age;                // Character's age
    private String gender;          // Character's gender
    private Job job;                // Character's job
    protected int strength;           // A measure of character's physical power
    protected int constitution;       // A measure of character's health
    protected int power;              // A measure of character's force of will and metal stability
    protected int dexterity;          // A measure of character's physical agility and speed
    protected int appearance;         // A measure of character's physical appeal
    protected int size;               // A measure of character's height and weight
    protected int intelligence;       // A measure of character's investigator’s cunning
    protected int education;          // A measure of character's  knowledge that accumulated through formal education
    protected int luck;               // A measure of how lucky character's is
    protected int freeSkillPoints;    // Skill points that could be applied to any skills freely
    private int bonusDamage;        // How much extra damage character can do
    private int hp;                 // Hit points that represents how many damages character could take.
    private int movement;           // A measure of how far character can move in one term
    private int sanity;             // Character’s ability to remain stoic in the face of horrors
    private int credit;             // An indicator of character's wealth and class.
    private List<String> itemList;  // A list of items character has
    private List<Skill> skillList;  // A list of skills character has
    static final Random d3 = new Random();      // A dice with 3 faces
    static final Random d6 = new Random();      // A dice with 6 faces
    static final Random d20 = new Random();    // A dice with 20 faces
    static final Random d100 = new Random();  // A dice with 100 faces
    static final int MAX_STATES = 90;            // The limitation of character's states

    //EFFECTS: creat a new character card with no data stored.
    public Role() {
        name = null;
        age = 0;
        gender = null;
        job = null;
        strength = 0;
        constitution = 0;
        power = 0;
        dexterity = 0;
        appearance = 0;
        size = 0;
        intelligence = 0;
        education = 0;
        luck = 0;
        freeSkillPoints = 0;
        skillList = new ArrayList<>();
        itemList = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setJobArtist() {
        this.job = new Artist();
        job.setJob();
        for (int i = 0; i < job.skillList.size(); i++) {
            skillList.add(i,job.skillList.get(i));
        }
        this.credit = job.getCredit();
    }

    public void setJobNurse() {
        this.job = new Nurse();
        job.setJob();
        for (int i = 0; i < job.skillList.size(); i++) {
            skillList.add(i,job.skillList.get(i));
        }
        this.credit = job.getCredit();
    }

    public void setJobPoliceman() {
        this.job = new Policeman();
        job.setJob();
        for (int i = 0; i < job.skillList.size(); i++) {
            skillList.add(i,job.skillList.get(i));
        }
        this.credit = job.getCredit();
    }

    //EFFECTS: returns the half of the given value
    public int halfValue(int value) {
        return value / 2;
    }

    //EFFECTS: returns the fifth of the given value
    public int fifthValue(int value) {
        return value / 5;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Job getJob() {
        return job;
    }

    public int getFreeSkillPoints() {
        return freeSkillPoints;
    }

    public int getBonusDamage() {
        return bonusDamage;
    }

    public int getHp() {
        return hp;
    }

    public int getMovement() {
        return movement;
    }

    public int getSanity() {
        return sanity;
    }

    public int getCredit() {
        return credit;
    }

    public void addHP(int hp) {
        this.hp += hp;
    }

    public void addSan(int san) {
        sanity += san;
    }

    public void removeSan(int san) {
        sanity -= san;
    }

    public void removeHP(int hp) {
        this.hp -= hp;
    }

    //MODIFIES: this
    //EFFECTS: set up character's states with random numbers.(The function of calculating states
    // obeys the Call of Cthulhu Quick-Start Rules 7th Edition)
    public void setStates() {
        this.strength = (this.rollD6() + this.rollD6() + this.rollD6()) * 5;
        this.constitution = (this.rollD6() + this.rollD6() + this.rollD6()) * 5;
        this.size = (this.rollD6() + this.rollD6() + 6) * 5;
        this.dexterity = (this.rollD6() + this.rollD6() + this.rollD6()) * 5;
        this.appearance = (this.rollD6() + this.rollD6() + this.rollD6()) * 5;
        this.intelligence = (this.rollD6() + this.rollD6() + 6) * 5;
        this.power = (this.rollD6() + this.rollD6() + this.rollD6()) * 5;
        this.education = (this.rollD6() + this.rollD6() + 6) * 5;
        this.luck = (this.rollD6() + this.rollD6() + this.rollD6()) * 5;
    }

    public int getStrength() {
        return strength;
    }

    public int getAppearance() {
        return appearance;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getEducation() {
        return education;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getLuck() {
        return luck;
    }

    public int getPower() {
        return power;
    }

    public int getSize() {
        return size;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public List<String> getItemList() {
        return itemList;
    }


    public void setBonusDamage() {
        if ((strength + size) >= 2 && (strength + size) < 85) {
            this.bonusDamage = -1;
        } else if ((strength + size) >= 85 && (strength + size) < 124) {
            this.bonusDamage = 0;
        } else if ((strength + size) >= 124 && (strength + size) <= 180) {
            this.bonusDamage = 1;
        }
    }

    public void setHitPoints() {
        hp = (size + constitution) / 10;
    }

    public void setMovement() {
        if (strength < size && dexterity < size) {
            movement = 7;
        } else if (strength == size && dexterity == size) {
            movement = 8;
        } else if (strength > size || dexterity > size) {
            movement = 8;
        } else {
            movement = 9;
        }
        if (age > 60) {
            movement -= 2;
        }
    }

    public void setSanity() {
        sanity = this.power;
    }

    //MODIFIES: this
    //EFFECTS; set free skill points depends on the education of the character.
    public void setFreeSkillPoints() {
        if (job.getName().equalsIgnoreCase("Artist")) {
            freeSkillPoints = education * 2 + power * 2 + intelligence * 2;
        } else if (job.getName().equalsIgnoreCase("Nurse")) {
            freeSkillPoints = education * 4 + intelligence * 2;
        } else {
            freeSkillPoints = education * 2 + strength * 2 + intelligence * 2;
        }
    }

    public void addSkills(String skillName,int points) {
        skillList.add(new Skill(skillName,points));
        freeSkillPoints -= points;
    }

    public boolean addSkillsPoints(String name, int points) {
        for (Skill s: skillList) {
            if (s.getSkill().equalsIgnoreCase(name)
                    && (points + s.getSkillPoints()) < MAX_STATES) {
                s.addSkillPoints(points);
                freeSkillPoints -= points;
                return true;
            }
        }
        return false;
    }

    public boolean removeSkillPoints(String name, int points) {
        for (Skill s: skillList) {
            if (s.getSkill().equalsIgnoreCase(name) && points <= s.getSkillPoints()
                    && s.getSkillPoints() >= points) {
                s.removeSkillPoints(points);
                freeSkillPoints += points;
                return true;
            }
        }
        return false;
    }

    public int rollD3() {
        return d3.nextInt(3) + 1;
    }

    public int rollD6() {
        return d6.nextInt(6) + 1;
    }

    public int rollD20() {
        return d20.nextInt(20) + 1;
    }

    public int rollD100() {
        return d100.nextInt(100) + 1;
    }

    public void addItems(String item) {
        itemList.add(item);
    }

    public void removeItems(int index) {
        itemList.remove(index);
    }

    public int getItemsIndex(String item) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).equalsIgnoreCase(item)) {
                return i;
            }
        }
        return -1;
    }

    public int getSkill(String skillName) {
        for (int i = 0; i < skillList.size(); i++) {
            if (skillList.get(i).getSkill().equalsIgnoreCase(skillName)) {
                return i;
            }
        }
        return -1;
    }
}
