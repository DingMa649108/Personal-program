package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// some parts of this class is inspired by JsonSerializationDemo
// link for JsonSerializationDemo: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represent a character having name, age, gender, states, skills, and items.
public class Role implements Writable {
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
    private final List<Item> itemList;  // A list of items character has
    private final List<Skill> skillList;  // A list of skills character has
    static final Random dice = new Random();      // A dice with arbitrary faces
    //    static final Random d6 = new Random();      // A dice with 6 faces
//    static final Random d20 = new Random();    // A dice with 20 faces
//    static final Random d100 = new Random();  // A dice with 100 faces
    static final int MAX_STATES = 90;            // The limitation of character's states

    //EFFECTS: creat a new character card with no data stored.
    public Role() {
        name = "None";
        age = 0;
        gender = "None";
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
        hp = 0;
        sanity = 0;
        credit = 0;
        movement = 0;
        bonusDamage = 0;
        skillList = new ArrayList<>();
        itemList = new ArrayList<>();
        job = new Job();
        job.setJob();
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

    //MODIFIES: this
    //EFFECTS: set job to artist and set credits to character card
    public void setJobArtist() {
        this.job = new Artist();
        job.setJob();
        this.credit = job.getCredit();
    }

    //MODIFIES: this
    //EFFECTS: set job to nurse and st credits to character card
    public void setJobNurse() {
        this.job = new Nurse();
        job.setJob();
        this.credit = job.getCredit();
    }

    //MODIFIES: this
    //EFFECTS: set job to policeman and set credits to character card
    public void setJobPoliceman() {
        this.job = new Policeman();
        job.setJob();
        this.credit = job.getCredit();
    }

    //MODIFIES: this
    //EFFECTS: add job skills to the skill list
    public void addJobSkills() {
        for (int i = 0; i < job.skillList.size(); i++) {
            skillList.add(i, job.skillList.get(i));
        }
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

    //MODIFIES: this
    //EFFECTS: add given amount hp to character's hp
    public void addHP(int hp) {
        this.hp += hp;
    }

    //MODIFIES: this
    //EFFECTS: add given amount of sanity to character's hp
    public void addSan(int san) {
        sanity += san;
    }

    //MODIFIES: this
    //EFFECTS: reduce given amount of sanity from character's sanity
    public void removeSan(int san) {
        sanity -= san;
    }

    //MODIFIES: this
    //EFFECTS: reduce given amount of hp to character's hp
    public void removeHP(int hp) {
        this.hp -= hp;
    }

    //MODIFIES: this
    //EFFECTS: set up character's states with random numbers.(The function of calculating states
    // obeys the Call of Cthulhu Quick-Start Rules 7th Edition)
    public void setStates() {
        this.strength = (this.roll(6) + this.roll(6) + this.roll(6)) * 5;
        this.constitution = (this.roll(6) + this.roll(6) + this.roll(6)) * 5;
        this.size = (this.roll(6) + this.roll(6) + 6) * 5;
        this.dexterity = (this.roll(6) + this.roll(6) + this.roll(6)) * 5;
        this.appearance = (this.roll(6) + this.roll(6) + this.roll(6)) * 5;
        this.intelligence = (this.roll(6) + this.roll(6) + 6) * 5;
        this.power = (this.roll(6) + this.roll(6) + this.roll(6)) * 5;
        this.education = (this.roll(6) + this.roll(6) + 6) * 5;
        this.luck = (this.roll(6) + this.roll(6) + this.roll(6)) * 5;
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

    public List<Item> getItemList() {
        return itemList;
    }

    //MODIFIES: this
    //EFFECTS: set up character's bonus damage based on the sum of character's strength and size
    // (formula obeys the formula in Call of the Call of Cthulhu Quick-Start Rules 7th Edition).
    public void setBonusDamage() {
        if ((strength + size) >= 55 && (strength + size) < 97) {
            this.bonusDamage = -1;
        } else if ((strength + size) >= 97 && (strength + size) < 139) {
            this.bonusDamage = 0;
        } else if ((strength + size) >= 139 && (strength + size) < 181) {
            this.bonusDamage = 1;
        } else {
            this.bonusDamage = 0;
        }
    }

    public void setBonusDamage(int bonusDamage) {
        this.bonusDamage = bonusDamage;
    }

    //MODIFIES: this
    //EFFECTS: set up character's HP based on character's constitution and size
    // (formula obeys the formula in Call of the Call of Cthulhu Quick-Start Rules 7th Edition)
    public void setHitPoints() {
        hp = (size + constitution) / 10;
    }

    //MODIFIES: this
    //EFFECTS: set up character's movement based on character's strength, dexterity, and size
    // (formula obeys the formula in Call of the Call of Cthulhu Quick-Start Rules 7th Edition)
    public void setMovement() {
        if (strength < size && dexterity < size) {
            movement = 9;
        } else if (strength == size && dexterity == size) {
            movement = 8;
        } else if (strength > size && dexterity > size) {
            movement = 7;
        } else if (strength > size) {
            movement = 8;
        } else {
            movement = 8;
        }
        if (age > 60) {
            movement -= 2;
        }
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    //MODIFIES: this
    //EFFECTS: set up character's sanity based on the sum of character's power
    // (formula obeys the formula in Call of the Call of Cthulhu Quick-Start Rules 7th Edition)
    public void setSanity() {
        sanity = this.power;
    }

    public void setSanity(int sanity) {
        this.sanity = sanity;
    }

    //MODIFIES: this
    //EFFECTS: set free skill points depends on the different jobs of the character.
    //(formula obeys the formula in Call of the Call of Cthulhu Quick-Start Rules 7th Edition)
    public void setFreeSkillPoints() {
        if (job.getName().equalsIgnoreCase("Artist")) {
            freeSkillPoints = education * 2 + power * 2 + intelligence * 2;
        } else if (job.getName().equalsIgnoreCase("Nurse")) {
            freeSkillPoints = education * 4 + intelligence * 2;
        } else if (job.getName().equalsIgnoreCase("Policeman")) {
            freeSkillPoints = education * 2 + strength * 2 + intelligence * 2;
        } else {
            freeSkillPoints = 0;
        }
    }

    public void setFreeSkillPoints(int freeSkillPoints) {
        this.freeSkillPoints = freeSkillPoints;
    }

    //REQUIRES: skill name should not be null, 0 <= points <= MAX_STATES, passed skill should not exist in skill list
    //MODIFIES: this
    //EFFECTS: add the skill with given name and skill points to the skill list
    public void addSkills(String skillName, int points) {
        skillList.add(new Skill(skillName, points));
        freeSkillPoints -= points;
    }

    //MODIFIES: this
    //EFFECTS: add the given skill object to the skill list
    public void addSkills(Skill skill) {
        skillList.add(skill);
    }

    //REQUIRES: skill name should exist in current skill list, 0 <= points
    //MODIFIES: this
    //EFFECTS: add skill points to given skill. And subtract given points from free skill points
    //return ture if the adding will not make skill point exceed the MAX_STATES, false otherwise
    public boolean addSkillsPoints(String name, int points) {
        for (Skill s : skillList) {
            if (s.getSkill().equalsIgnoreCase(name)
                    && points + s.getSkillPoints() <= MAX_STATES) {
                s.addSkillPoints(points);
                freeSkillPoints -= points;
                return true;
            }
        }
        return false;
    }

    //REQUIRES: skill name should exist in current skill list, 0 <= points
    //MODIFIES: this
    //EFFECTS: remove skill points from given skill. And add given points from free skill points
    //return ture if the subtracting will not make skill negative, false otherwise
    public boolean removeSkillPoints(String name, int points) {
        for (Skill s : skillList) {
            if (s.getSkill().equalsIgnoreCase(name) && points <= s.getSkillPoints()) {
                s.removeSkillPoints(points);
                freeSkillPoints += points;
                return true;
            }
        }
        return false;
    }

    //REQUIRES: skill name should exist in current skill list
    //MODIFIES: this
    //EFFECTS: remove the skill with given skill name from the skill list.
    // Return ture if skill with skill name is in the skill list, false otherwise.
    public boolean removeSkill(String skillName) {
        for (int i = 0; i < skillList.size(); i++) {
            if (skillList.get(i).getSkill().equalsIgnoreCase(skillName)) {
                freeSkillPoints += skillList.get(i).getSkillPoints();
                skillList.remove(i);
                return true;
            }
        }
        return false;
    }

    //EFFECTS: return a result of rolling 3 faces dice
    public int roll(int faces) {
        return dice.nextInt(faces) + 1;
    }
//
//    //EFFECTS: return a result of rolling 6 faces dice
//    public int roll(6) {
//        return d6.nextInt(6) + 1;
//    }
//
//    //EFFECTS: return a result of rolling 20 faces dice
//    public int rollD20() {
//        return d20.nextInt(20) + 1;
//    }
//
//    //EFFECTS: return a result of rolling 100 faces dice
//    public int rollD100() {
//        return d100.nextInt(100) + 1;
//    }

    //REQUIRES: passed item should not exist in the item list
    //MODIFIES: this
    //EFFECTS: add an item to item list
    public void addItem(String item) {
        itemList.add(new Item(item));
    }

    //MODIFIES: this
    //EFFECTS: remove an item in the give index
    public void removeItems(int index) {
        itemList.remove(index);
    }

    //REQUIRES: given item exist in item list
    //EFFECTS: return the index of the given item, -1 if no item funded
    public int getItemsIndex(String item) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemName().equalsIgnoreCase(item)) {
                return i;
            }
        }
        return -1;
    }

    //REQUIRES: given skill exist in skill list
    //EFFECTS: return the index of the given skill name, -1 if no skill name funded
    public int getSkillIndex(String skillName) {
        for (int i = 0; i < skillList.size(); i++) {
            if (skillList.get(i).getSkill().equalsIgnoreCase(skillName)) {
                return i;
            }
        }
        return -1;
    }

    public void setStrength(int str) {
        strength = str;
    }

    public void setSize(int siz) {
        size = siz;
    }

    public void setDexterity(int dex) {
        dexterity = dex;
    }

    public void setAppearance(int appearance) {
        this.appearance = appearance;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setPower(int power) {
        this.power = power;
    }


    public void setCredit(int credit) {
        this.credit = credit;
    }


    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public void setJobName(String jobName) {
        job.setJobName(jobName);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("age", age);
        json.put("gender", gender);
        json.put("job", getJob().getName());
        json.put("STR", strength);
        json.put("CON", constitution);
        json.put("POW", power);
        json.put("DEX", dexterity);
        json.put("APP", appearance);
        json.put("SIZ", size);
        json.put("INT", intelligence);
        json.put("EDU", education);
        json.put("LUC", luck);
        json.put("free skill points", freeSkillPoints);
        json.put("bonus damage", bonusDamage);
        json.put("hp", hp);
        json.put("MOV", movement);
        json.put("SAN", sanity);
        json.put("credit", credit);
        json.put("skills", skillsToJson());
        json.put("items", itemsToJson());
        return json;
    }

    // EFFECTS: returns skills in this role card as a JSON array
    private JSONArray skillsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Skill skill : skillList) {
            jsonArray.put(skill.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: returns items in this role card as a JSON array
    private JSONArray itemsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Item item : itemList) {
            jsonArray.put(item.toJson());
        }

        return jsonArray;
    }
}
