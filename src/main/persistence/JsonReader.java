package persistence;

import model.Job;
import model.Role;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Skill;
import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private final String source;
    private String name;
    private int age;
    private String gender;
    private String job;
    protected int strength;
    protected int constitution;
    protected int power;
    protected int dexterity;
    protected int appearance;
    protected int size;
    protected int intelligence;
    protected int education;
    protected int luck;
    protected int freeSkillPoints;
    private int bonusDamage;
    private int hp;
    private int movement;
    private int sanity;
    private int credit;
    Role role;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Role read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkRoom(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }


    // EFFECTS: parses workroom from JSON object and returns it
    private Role parseWorkRoom(JSONObject jsonObject) {
        name = jsonObject.getString("name");
        age = jsonObject.getInt("age");
        gender = jsonObject.getString("gender");
        job = jsonObject.getString("job");
        strength = jsonObject.getInt("STR");
        constitution = jsonObject.getInt("CON");
        power = jsonObject.getInt("POW");
        dexterity = jsonObject.getInt("DEX");
        appearance = jsonObject.getInt("APP");
        size = jsonObject.getInt("SIZ");
        intelligence = jsonObject.getInt("INT");
        education = jsonObject.getInt("EDU");
        luck = jsonObject.getInt("LUC");
        freeSkillPoints = jsonObject.getInt("free skill points");
        bonusDamage = jsonObject.getInt("bonus damage");
        hp = jsonObject.getInt("hp");
        movement = jsonObject.getInt("MOV");
        sanity = jsonObject.getInt("SAN");
        credit = jsonObject.getInt("credit");
        Role role = new Role();
        setRole(role, jsonObject);
        return role;
    }


    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to role
    private void addSkills(Role role, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("skills");
        for (Object json : jsonArray) {
            JSONObject nextSkill = (JSONObject) json;
            addSkill(role, nextSkill);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to role
    private void addSkill(Role role, JSONObject jsonObject) {
        String skillName = jsonObject.getString("Skill name");
        int skillPoints = jsonObject.getInt("Skill points");
        role.addSkills(new Skill(skillName, skillPoints));
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to role
    private void addItems(Role role, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItem(role, nextItem);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to role
    private void addItem(Role role, JSONObject jsonObject) {
        String itemName = jsonObject.getString("Item name");
        role.addItem(itemName);
    }

    private void setRole(Role role, JSONObject jsonObject) {
        role.setStrength(strength);
        role.setDexterity(dexterity);
        role.setAge(age);
        role.setName(name);
        role.setGender(gender);
        role.setConstitution(constitution);
        role.setPower(power);
        role.setAppearance(appearance);
        role.setSize(size);
        role.setIntelligence(intelligence);
        role.setEducation(education);
        role.setLuck(luck);
        role.setFreeSkillPoints(freeSkillPoints);
        role.setBonusDamage(bonusDamage);
        role.setHp(hp);
        role.setMovement(movement);
        role.setSanity(sanity);
        role.setCredit(credit);
        role.setJobName(job);
        addSkills(role, jsonObject);
        addItems(role, jsonObject);
    }
}

