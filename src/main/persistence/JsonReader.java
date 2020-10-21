package persistence;

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
    private String source;

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
        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");
        String gender = jsonObject.getString("gender");
        String job = jsonObject.getString("job");
        int strength = jsonObject.getInt("STR");
        int constitution = jsonObject.getInt("CON");
        int power = jsonObject.getInt("POW");
        int dexterity = jsonObject.getInt("DEX");
        int appearance = jsonObject.getInt("APP");
        int size = jsonObject.getInt("SIZ");
        int intelligence = jsonObject.getInt("INT");
        int education = jsonObject.getInt("EDU");
        int luck = jsonObject.getInt("LUC");
        int freeSkillPoints = jsonObject.getInt("free skill points");
        int bonusDamage = jsonObject.getInt("bonus damage");
        int hp = jsonObject.getInt("hp");
        int movement = jsonObject.getInt("MOV");
        int sanity = jsonObject.getInt("SAN");
        int credit = jsonObject.getInt("credit");
        Role role = new Role();
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
        role.addSkills(new Skill(skillName,skillPoints));
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
}

