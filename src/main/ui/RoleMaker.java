package ui;

import model.Role;
import model.Skill;

import java.util.Scanner;

public class RoleMaker {
    private final Scanner input = new Scanner(System.in);
    private Role role;

    //EFFECTS: run the role maker application
    public RoleMaker() {
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
        System.out.println("\nPlease choose one of following");
        System.out.println("1. Make role card\n"
                + "2. Actions\n"
                + "3. roll\n"
                + "4. Display role card\n"
                + "5. Quit");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1) {
            cardMenu(role);
        } else if (choice == 2) {
            actionMenu(role);
        } else if (choice == 3) {
            roll(role);
        } else if (choice == 4) {
            displayRoleCard(role);
        } else if (choice == 5) {
            quit();
        }
        mainMenu();
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
        System.out.println("\nPlease choose one of following\n" + "(please follow the order from 1 to 7)\n"
                + "(Please type 8 after finishing editing)\n" + "1. Set name\n" + "2. Set age\n" + "3. Set gender\n"
                + "4. Set job\n" + "5. Set states\n" + "6. Skill\n" + "7. Item\n" + "8. Previous menu\n");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1) {
            setName(role);
        } else if (choice == 2) {
            setAge(role);
        } else if (choice == 3) {
            setGender(role);
        } else if (choice == 4) {
            jobMenu(role);
        } else if (choice == 5) {
            setUpStates(role);
        } else if (choice == 6) {
            skillMenu(role);
        } else if (choice == 7) {
            itemMenu(role);
        } else {
            mainMenu();
        }
        cardMenu(role);
    }

    //MODIFIES: this
    //EFFECTS: display the job menu and allow users to choose the job for the role
    //(1.set job to Artist
    // 2.set job to Nurse
    // 3.set Policeman
    // 4.back to previous menu)
    public void jobMenu(Role role) {
        System.out.println("\nPlease choose one of following jobs" + "\n(Please type 4 after finishing choosing)");
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
            cardMenu(role);
        }
        jobMenu(role);
    }

    //MODIFIES: this
    //EFFECTS: display the skill menu and allow users to creat and manage their skills
    //(1.add a new skill with skill points to skill list
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
        checkFreeSkillPointIsNotZero(role);
        System.out.println("Free points: " + role.getFreeSkillPoints());
        System.out.println("\nPlease enter skill name");
        String skillName = input.nextLine();
        System.out.println("Please enter skill points for the skill");
        int points = input.nextInt();
        input.nextLine();
        role.addSkills(skillName, points);
        System.out.println("Free points: " + role.getFreeSkillPoints());
    }

    //MODIFIES: this
    //EFFECTS: ask users to input skill name and skill points they want to add.
    // Then add inputted skill points to the skill has inputted name
    public void addSkillPoint(Role role) {
        checkFreeSkillPointIsNotZero(role);
        System.out.println("Free points: " + role.getFreeSkillPoints());
        System.out.println("Please enter skill name");
        String skillName = input.nextLine();
        System.out.println("Please enter skill points you want to add");
        int points = input.nextInt();
        input.nextLine();
        role.addSkills(skillName, points);
        System.out.println("Free points: " + role.getFreeSkillPoints());
    }

    //MODIFIES: this
    //EFFECTS: ask users to input skill name and skill points they want to remove.
    // Then remove inputted skill points from the skill has inputted name
    public void removeSkillPoint(Role role) {
        checkFreeSkillPointIsNotZero(role);
        System.out.println("Free points: " + role.getFreeSkillPoints());
        System.out.println("Please enter skill name");
        String skillName = input.nextLine();
        System.out.println("Please enter skill points you want to remove");
        int points = input.nextInt();
        input.nextLine();
        role.removeSkillPoints(skillName, points);
        System.out.println("Free points: " + role.getFreeSkillPoints());
    }

    //MODIFIES: this
    //EFFECTS: ask users to input skill name they want to remove.
    // Then remove skill with inputted name from the skill list.
    public void removeSkill(Role role) {
        checkFreeSkillPointIsNotZero(role);
        System.out.println("Free points: " + role.getFreeSkillPoints());
        System.out.println("Please enter skill name you want to remove");
        String skillName = input.nextLine();
        role.removeSkill(skillName);
        System.out.println("Free points: " + role.getFreeSkillPoints());
    }

    //MODIFIES: this
    //EFFECTS: display the item menu and allow users to creat and manage their items
    //(1.add a new item to item list
    // 2.remove item  from item list
    // 3.back to previous menu
    public void itemMenu(Role role) {
        System.out.println("Items: ");
        for (String s : role.getItemList()) {
            System.out.print(s);
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
        role.removeItems(role.getItemsIndex(item));
    }

    //EFFECTS: ask users to input the faces og dice they want to use.
    // Than display the result of rolling
    public void roll(Role role) {
        System.out.println("\nEnter faces of dice(3,6,20,100)");
        int choiceDice = input.nextInt();
        input.nextLine();
        if (choiceDice == 3) {
            System.out.println(role.rollD3());
        } else if (choiceDice == 6) {
            System.out.println(role.rollD6());
        } else if (choiceDice == 20) {
            System.out.println(role.rollD20());
        } else if (choiceDice == 100) {
            System.out.println(role.rollD100());
        }
    }

    //MODIFIES: this
    //EFFECTS: display the skill menu and allow users to creat and manage their skills
    //(1.add hit points for user's role
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
            role.addHP(input.nextInt());
            input.nextLine();
        } else if (choice == 2) {
            role.removeHP(input.nextInt());
            input.nextLine();
        } else if (choice == 3) {
            role.addSan(input.nextInt());
            input.nextLine();
        } else if (choice == 4) {
            role.removeSan(input.nextInt());
            input.nextLine();
        } else if (choice == 5) {
            mainMenu();
        }
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
    //EFFECTS: ask user to input role's age, and set role's name to the inputted age
    public void setAge(Role role) {
        System.out.println("\nPlease enter age for the role");
        role.setAge(input.nextInt());
        input.nextLine();
    }

    //MODIFIES: this
    //EFFECTS: ask user to input role's gender, and set role's name to the inputted gender
    public void setGender(Role role) {
        System.out.println("\nPlease enter gender for the role");
        role.setGender(input.nextLine());
    }

    //EFFECTS: check if the free skill point is zero.
    // Display guidance information and return to main menu if free points is zero, nothing happens otherwise
    public void checkFreeSkillPointIsNotZero(Role role) {
        if (role.getFreeSkillPoints() == 0) {
            System.out.println("If free points is 0 before you edit skill, please go set up states and job first");
            mainMenu();
        }
    }

    //EFFECTS: display the role card users created
    public void displayRoleCard(Role role) {
        System.out.println("Role Card");
        System.out.println("Name: " + role.getName());
        System.out.println("Age: " + role.getAge());
        System.out.println("Gender: " + role.getGender());
        System.out.println("HP: " + role.getHp() + "\t\tSAN: " + role.getSanity());
        System.out.println("Job: " + role.getJob().getName());
        displayStates(role);
        System.out.println("Skills: ");
        System.out.print(role.getSkillList().toString());
        System.out.println("\nItems: ");
        for (String item : role.getItemList()) {
            System.out.print(item + ", ");
        }
    }

    //EFFECTS: display the states of user's role.
    // And calculate half and fifth value os each states and display then in brackets follow each state
    public void displayStates(Role role) {
        System.out.println("STR: " + role.getStrength()
                + "(" + role.halfValue(role.getStrength()) + " " + role.fifthValue(role.getStrength()) + ")"
                + "\tAPP: " + role.getAppearance()
                + "(" + role.halfValue(role.getAppearance()) + " " + role.fifthValue(role.getAppearance()) + ")");
        System.out.println("CON: " + role.getConstitution()
                + "(" + role.halfValue(role.getConstitution()) + " " + role.fifthValue(role.getConstitution()) + ")"
                + "\tSIZ: " + role.getSize()
                + "(" + role.halfValue(role.getSize()) + " " + role.fifthValue(role.getSize()) + ")");
        System.out.println("POW: " + role.getPower()
                + "(" + role.halfValue(role.getPower()) + " " + role.fifthValue(role.getPower()) + ")"
                + "\tINT: " + role.getIntelligence()
                + "(" + role.halfValue(role.getIntelligence()) + " " + role.fifthValue(role.getIntelligence()) + ")");
        System.out.println("DEX: " + role.getDexterity()
                + "(" + role.halfValue(role.getDexterity()) + " " + role.fifthValue(role.getDexterity()) + ")"
                + "\tEDU: " + role.getEducation()
                + "(" + role.halfValue(role.getEducation()) + " " + role.fifthValue(role.getEducation()) + ")");
        System.out.println("LUC: " + role.getLuck()
                + "(" + role.halfValue(role.getLuck()) + " " + role.fifthValue(role.getLuck()) + ")"
                + "\tDMG: " + role.getBonusDamage());
        System.out.println("MOV: " + role.getMovement() + "\tCredit: " + role.getCredit());
    }

    //EFFECTS: quit the application
    public void quit() {
        System.exit(0);
    }
}