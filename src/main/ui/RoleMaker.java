package ui;

import model.Item;
import model.Role;
import model.Skill;
import persistence.JsonWriter;
import persistence.JsonReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// some parts of this class is inspired by JsonSerializationDemo
// link for JsonSerializationDemo: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class RoleMaker implements ActionListener {
    private static final String JSON_STORE = "./data/Role.json";
    private final Scanner input = new Scanner(System.in);
    protected Role role;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    JFrame frame;
    JButton button;
    JPanel panel;
    JLabel label;


    //EFFECTS: run the role maker application
    public RoleMaker() {
        frame = new JFrame();

        label = new JLabel();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        panel.setLayout(new GridLayout(0,1));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000,1000);
        frame.setVisible(true);
        frame.setResizable(true);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runRoleMaker();
    }

    //EFFECTS: Run the role maker program
    public void runRoleMaker() {
        role = new Role();
        mainMenu();
    }

    //MODIFIES: this
    //EFFECTS: display the main menu for the program and allow users to choose the different actions
    //1.making role card,
    // 2.do in game actions,
    // 3.roll dice,
    // 4.display the role card
    // 5.quit program
    public void mainMenu() {
        panel.removeAll();
        JLabel label = new JLabel("Please choose one of following:");
        panel.add(label);
        setRoleCardButton();
        setActionButton();
        setRollButton();
        setDisplayButton();
        setSaveButton();
        setLoadButton();
        setQuitButton();
        frame.add(panel,BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }

    public void setRoleCardButton() {
        JButton button = new JButton("1. Make role card");
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cardMenu(role);
                    }
                }
        );
        panel.add(button);
    }

    public void setActionButton() {
        JButton button = new JButton("2. Actions(Please make role first before choosing action)");
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        actionMenu(role);
                    }
                }
        );
        panel.add(button);
    }

    public void setRollButton() {
        JButton button = new JButton("3. roll");
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        roll(role);
                    }
                }
        );
        panel.add(button);
    }

    public void setDisplayButton() {
        JButton button = new JButton("4. Display role card");
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        displayRoleCard(role);
                    }
                }
        );
        panel.add(button);
    }

    public void setSaveButton() {
        JButton button = new JButton("5. Save role card");
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        saveRoleCard();
                    }
                }
        );
        panel.add(button);
    }

    public void setLoadButton() {
        JButton button = new JButton("6. Load role card");
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        loadRoleCard();
                    }
                }
        );
        panel.add(button);
    }

    public void setQuitButton() {
        JButton button = new JButton("7. Quit");
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                }
        );
        panel.add(button);
    }



    //MODIFIES: this
    //EFFECTS: display the role menu and allow users to creat and manage their role card
    // 1.set name for role
    // 2.set age for role
    // 3.set gender for role
    // 4.open job menu
    // 5.set role's states randomly
    // 6.open skill menu
    // 7.open item menu
    // 8.back to previous menu
    public void cardMenu(Role role) {
        panel.removeAll();
        JLabel label = new JLabel("Please choose one of following: ");
        JLabel label0 = new JLabel("(please follow the order from 1 to 7. Please type 8 after finishing editing)");
        panel.add(label);
        panel.add(label0);
        setNameButton();
        JButton button2 = new JButton("2. Set age");
        JButton button3 = new JButton("3. Set gender");
        JButton button4 = new JButton("4. Set job");
        JButton button5 = new JButton("5. Set states");
        JButton button6 = new JButton("6. Skill");
        JButton button7 = new JButton("7. Item");
        JButton button8 = new JButton("8. Previous menu");
        frame.add(panel,BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }

    public void setNameButton() {
        JButton button = new JButton("1. Set name");
        button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        panel.removeAll();
                        JTextField field = new JTextField(5);
                        JButton button1 = new JButton("Set name");
                        panel.add(field);
                        panel.add(button1);
                        frame.add(panel);
                        button1.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        role.setName(field.getText());
                                        cardMenu(role);
                                    }
                                }
                        );
                        panel.revalidate();
                        panel.repaint();
                    }
                }
        );
        panel.add(button);
    }



    //MODIFIES: this
    //EFFECTS: display the job menu and allow users to choose the job for the role
    // 1.set job to Artist
    // 2.set job to Nurse
    // 3.set Policeman
    // 4.back to previous menu)
    public void jobMenu(Role role) {
        System.out.println("\nPlease choose one of following jobs"
                + "\n(Please set states every time after choosing job)" + "\n(Please type 4 after finishing choosing)");
        System.out.println("1. Artist\n"
                + "2. Nurse\n"
                + "3. Policeman\n"
                + "4. Previous menu\n");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1) {
            role.setJobArtist();
        } else if (choice == 2) {
            role.setJobNurse();
        } else if (choice == 3) {
            role.setJobPoliceman();
        } else if (choice == 4) {
            role.addJobSkills();
            cardMenu(role);
        }
        jobMenu(role);
    }

    //MODIFIES: this
    //EFFECTS: display the skill menu and allow users to creat and manage their skills
    // 1.add a new skill with skill points to skill list
    // 2.add skill points to a existing skill
    // 3.remove skill points from skill list
    // 4.remove a skill from skill list entirely
    // 5.back to previous menu
    public void skillMenu(Role role) {
        System.out.println("Skills: ");
        System.out.print(role.getSkillList().toString());
        System.out.println("\nPlease choose one of following" + "(Please type 5 after finishing editing)\n"
                + "(Please don't change states and job after editing skills)\n"
                + "\n1. Add new skill\n" + "2. Add skill points\n"
                + "3. Remove skill points\n" + "4. Remove skill\n"
                + "5. Previous menu\n");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1) {
            addSkill(role);
        } else if (choice == 2) {
            addSkillPoint(role);
        } else if (choice == 3) {
            removeSkillPoint(role);
        } else if (choice == 4) {
            removeSkill(role);
        } else if (choice == 5) {
            cardMenu(role);
        }
        skillMenu(role);
    }

    //MODIFIES: this
    //EFFECTS: add a new skill with name and skill points inputted by users
    public void addSkill(Role role) {
        System.out.println("\nFree points: " + role.getFreeSkillPoints());
        checkFreeSkillPointIsNotZero(role);
        System.out.println("\nPlease enter skill name");
        String skillName = input.nextLine();
        System.out.println("Please enter skill points for the skill");
        int points = input.nextInt();
        input.nextLine();
        if (points > role.getFreeSkillPoints()) {
            System.out.println("Sorry you dont have enough free skill points");
            skillMenu(role);
        }
        if (points > 90) {
            System.out.println("Sorry the maximum skill points for one skill is 90");
            skillMenu(role);
        }
        role.addSkills(skillName, points);
        System.out.println("\nFree points: " + role.getFreeSkillPoints());
    }

    //MODIFIES: this
    //EFFECTS: ask users to input skill name and skill points they want to add.
    // Then add inputted skill points to the skill has inputted name
    public void addSkillPoint(Role role) {
        System.out.println("\nFree points: " + role.getFreeSkillPoints());
        checkFreeSkillPointIsNotZero(role);
        System.out.println("Please enter skill name");
        String skillName = input.nextLine();
        if (role.getSkillIndex(skillName) == -1) {
            System.out.println("Sorry the skill is not in the list");
            skillMenu(role);
        }
        System.out.println("Please enter skill points you want to add");
        int points = input.nextInt();
        input.nextLine();
        if (points > role.getFreeSkillPoints()) {
            System.out.println("Sorry, you dont have enough free skill points");
            skillMenu(role);
        }
        if (points + role.getSkillList().get(role.getSkillIndex(skillName)).getSkillPoints() > 90) {
            System.out.println("Sorry, the maximum skill points for one skill is 90");
            skillMenu(role);
        }
        role.addSkillsPoints(skillName, points);
        System.out.println("\nFree points: " + role.getFreeSkillPoints());
    }

    //MODIFIES: this
    //EFFECTS: ask users to input skill name and skill points they want to remove.
    // Then remove inputted skill points from the skill has inputted name
    public void removeSkillPoint(Role role) {
        System.out.println("\nFree points: " + role.getFreeSkillPoints());
        System.out.println("Please enter skill name");
        String skillName = input.nextLine();
        if (role.getSkillIndex(skillName) == -1) {
            System.out.println("Sorry the skill is not in the list");
            skillMenu(role);
        } else {
            System.out.println("Please enter skill points you want to remove");
            int points = input.nextInt();
            input.nextLine();
            if (points > role.getSkillList().get(role.getSkillIndex(skillName)).getSkillPoints()) {
                System.out.println("Sorry, you can't reduce skill points to negative value");
                skillMenu(role);
            } else {
                role.removeSkillPoints(skillName, points);
                System.out.println("\nFree points: " + role.getFreeSkillPoints());
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: ask users to input skill name they want to remove.
    // Then remove skill with inputted name from the skill list.
    public void removeSkill(Role role) {
        System.out.println("\nFree points: " + role.getFreeSkillPoints());
        System.out.println("Please enter skill name you want to remove");
        String skillName = input.nextLine();
        if (role.getSkillIndex(skillName) == -1) {
            System.out.println("Sorry, the skill is not in the list");
            skillMenu(role);
        } else {
            role.removeSkill(skillName);
            System.out.println("\nFree points: " + role.getFreeSkillPoints());
        }
    }

    //MODIFIES: this
    //EFFECTS: display the item menu and allow users to creat and manage their items
    //(1.add a new item to item list
    // 2.remove item  from item list
    // 3.back to previous menu
    public void itemMenu(Role role) {
        System.out.println("Items: ");
        for (Item s : role.getItemList()) {
            System.out.print(s.getItemName() + ", ");
        }
        System.out.println("\nPlease choose one of following");
        System.out.println("1. Add new item\n"
                + "2. Remove item\n"
                + "3. Previous menu\n");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1) {
            addItem(role);
        } else if (choice == 2) {
            removeItem(role);
        } else if (choice == 3) {
            cardMenu(role);
        }
        itemMenu(role);
    }

    //MODIFIES: this
    //EFFECTS: ask users to input item name they want to add.
    // Than add the item to the item list
    public void addItem(Role role) {
        System.out.println("Please enter item name you want to add");
        String item = input.nextLine();
        role.addItem(item);
    }

    //MODIFIES: this
    //EFFECTS: ask users to input item name they want to add.
    // Than remove the item to the item list
    public void removeItem(Role role) {
        System.out.println("Please enter item name you want to remove");
        String item = input.nextLine();
        if (role.getItemsIndex(item) == -1) {
            System.out.println("Sorry the item you inputted is not in the list");
            itemMenu(role);
        } else {
            role.removeItems(role.getItemsIndex(item));
        }
    }

    //EFFECTS: ask users to input the faces of dice they want to use
    // and how many time they want to roll.
    // Than display the result of rolling
    public void roll(Role role) {
        System.out.println("\nPlease enter faces of dice(3,6,20,100)");
        int choiceDice = input.nextInt();
        input.nextLine();
        System.out.println("\nPlease enter times you want to roll");
        int choiceTimes = input.nextInt();
        input.nextLine();
        rollHelper(choiceDice,choiceTimes);
        mainMenu();
    }

    //EFFECT: roll the chosen dice for the chosen time.
    // Then, display the result.
    public void rollHelper(int choiceDice, int choiceTimes) {
        int total = 0;
        if (choiceDice == 3) {
            for (int i = 0; i < choiceTimes; i++) {
                total += role.rollD3();
            }
        } else if (choiceDice == 6) {
            for (int i = 0; i < choiceTimes; i++) {
                total += role.rollD6();
            }
        } else if (choiceDice == 20) {
            for (int i = 0; i < choiceTimes; i++) {
                total += role.rollD20();
            }
        } else if (choiceDice == 100) {
            for (int i = 0; i < choiceTimes; i++) {
                total += role.rollD100();
            }
        }
        System.out.println(choiceTimes + " D" + choiceDice + ": " + total);
    }

    //MODIFIES: this
    //EFFECTS: display the skill menu and allow users to creat and manage their skills
    // 1.add hit points for user's role
    // 2.reduce hit points for user's role
    // 3.add sanity for user's role
    // 4.reduce sanity for user's role
    // 5.back to previous menu
    public void actionMenu(Role role) {
        System.out.println("\nPlease choose one of following");
        System.out.println("1. Add Hp\n" + "2. Reduce HP\n" + "3. Add SAN\n"
                + "4. Reduce San\n" + "5. Previous menu");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1) {
            System.out.println("Please enter number of HP you want to add");
            role.addHP(input.nextInt());
        } else if (choice == 2) {
            System.out.println("Please enter number of HP you want to reduce");
            role.removeHP(input.nextInt());
        } else if (choice == 3) {
            System.out.println("Please enter number of SAN you want to add");
            role.addSan(input.nextInt());
        } else if (choice == 4) {
            System.out.println("Please enter number of SAN you want to reduce");
            role.removeSan(input.nextInt());
        } else if (choice == 5) {
            mainMenu();
        }
        input.nextLine();
        actionMenu(role);
    }

    //MODIFIES: this
    //EFFECTS: set up user's role's states,
    // and calculate role's hit points, sanity, movement, bonus damage, and free skill points
    public void setUpStates(Role role) {
        role.setStates();
        role.setHitPoints();
        role.setSanity();
        role.setMovement();
        role.setBonusDamage();
        role.setFreeSkillPoints();
    }

    //MODIFIES: this
    //EFFECTS: ask user to input role's name, and set role's name to the inputted name
    public void setName(Role role) {
        System.out.println("\nPlease enter name for the role");
        String name = input.nextLine();
        role.setName(name);
    }

    //MODIFIES: this
    //EFFECTS: ask user to input role's age, and set role's age to the inputted age
    public void setAge(Role role) {
        System.out.println("\nPlease enter age for the role");
        role.setAge(input.nextInt());
        input.nextLine();
    }

    //MODIFIES: this
    //EFFECTS: ask user to input role's gender, and set role's gender to the inputted gender
    public void setGender(Role role) {
        System.out.println("\nPlease enter gender for the role");
        role.setGender(input.nextLine());
    }

    //EFFECTS: check if the free skill point is zero.
    // Display guidance information and return to skill menu if free points is zero, nothing happens otherwise
    public void checkFreeSkillPointIsNotZero(Role role) {
        if (role.getFreeSkillPoints() == 0) {
            System.out.println("If free points is 0 before you edit skill, please go set up states and job first");
            skillMenu(role);
        }
    }

    //EFFECTS: display the information on role card user created
    public void displayRoleCard(Role role) {
        panel.removeAll();
        panel.add(new JLabel("Role Card"));
        panel.add(new JLabel("Name: " + role.getName()));
        panel.add(new JLabel("Age: " + role.getAge()));
        panel.add(new JLabel("Gender: " + role.getGender()));
        panel.add(new JLabel("HP: " + role.getHp() + "\t\tSAN: " + role.getSanity()));
        panel.add(new JLabel("Job: " + role.getJob().getName()));
        displayStates(role);
        panel.add(new JLabel("Skills: "));
        panel.add(new JLabel(role.getSkillList().toString()));
        panel.add(new JLabel("\nItems: "));
        for (Item item: role.getItemList()) {
            panel.add(new JLabel(item.getItemName() + ", "));
        }
        panel.revalidate();
        panel.repaint();
        JButton button = new JButton("Back");
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        mainMenu();
                    }
                }
        );
        panel.add(button);
        frame.add(panel);
    }

    //EFFECTS: display the states of user's role.
    // And calculate half and fifth value os each states and display then in brackets follow each state
    public void displayStates(Role role) {
        panel.add(new JLabel("STR: " + role.getStrength()
                + "(" + role.halfValue(role.getStrength()) + " " + role.fifthValue(role.getStrength()) + ")"
                + "\tAPP: " + role.getAppearance()
                + "(" + role.halfValue(role.getAppearance()) + " " + role.fifthValue(role.getAppearance()) + ")"));
        panel.add(new JLabel("CON: " + role.getConstitution()
                + "(" + role.halfValue(role.getConstitution()) + " " + role.fifthValue(role.getConstitution()) + ")"
                + "\tSIZ: " + role.getSize()
                + "(" + role.halfValue(role.getSize()) + " " + role.fifthValue(role.getSize()) + ")"));
        panel.add(new JLabel("POW: " + role.getPower()
                + "(" + role.halfValue(role.getPower()) + " " + role.fifthValue(role.getPower()) + ")"
                + "\tINT: " + role.getIntelligence()
                + "(" + role.halfValue(role.getIntelligence()) + " " + role.fifthValue(role.getIntelligence()) + ")"));
        panel.add(new JLabel("DEX: " + role.getDexterity()
                + "(" + role.halfValue(role.getDexterity()) + " " + role.fifthValue(role.getDexterity()) + ")"
                + "\tEDU: " + role.getEducation()
                + "(" + role.halfValue(role.getEducation()) + " " + role.fifthValue(role.getEducation()) + ")"));
        panel.add(new JLabel("LUC: " + role.getLuck()
                + "(" + role.halfValue(role.getLuck()) + " " + role.fifthValue(role.getLuck()) + ")"
                + "\tDMG: " + role.getBonusDamage()));
        panel.add(new JLabel("MOV: " + role.getMovement() + "\tCredit: " + role.getCredit()));
    }

    // EFFECTS: saves the role card to file
    private void saveRoleCard() {
        try {
            jsonWriter.open();
            jsonWriter.write(role);
            jsonWriter.close();
            System.out.println("Saved role card" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads role card from file
    private void loadRoleCard() {
        try {
            role = jsonReader.read();
            System.out.println("Loaded role card" + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //EFFECTS: quit the application
    public void quit() {
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.cardMenu(role);
    }
}