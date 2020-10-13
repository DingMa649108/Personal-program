package ui;

import model.Role;
import model.Skill;

import java.util.Scanner;

public class RoleMaker {
    private final Scanner input = new Scanner(System.in);
    private Role role;

    public RoleMaker() {
        runRoleMaker();
    }

    public void runRoleMaker() {
        role = new Role();
//        displayRoleCard(role);
        mainMenu();
    }

    public void displayRoleCard(Role role) {
        System.out.println("Role Card");
        System.out.println("Name: " + role.getName());
        System.out.println("Age: " + role.getAge());
        System.out.println("Gender: " + role.getGender());
        System.out.println("HP: " + role.getHp() + "\t\tSAN: " + role.getSanity());
        System.out.println("Job: " + role.getJob().getName());
        System.out.println("STR: " + role.getStrength() + "\tAPP: " + role.getAppearance());
        System.out.println("CON: " + role.getConstitution() + "\tSIZ: " + role.getSize());
        System.out.println("POW: " + role.getPower() + "\tINT: " + role.getIntelligence());
        System.out.println("DEX: " + role.getDexterity() + "\tEDU: " + role.getEducation());
        System.out.println("LUC: " + role.getLuck() + "\tDMG: " + role.getBonusDamage());
        System.out.println("MOV: " + role.getMovement() + "\tCredit: " + role.getCredit());
        System.out.println("Skills: ");
        for (Skill s : role.getSkillList()) {
            System.out.print(s.toString() + ", ");
        }
        System.out.println("\nItems: ");
        for (String item : role.getItemList()) {
            System.out.print(item + ", ");
        }
    }

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
            actionMenu();
        } else if (choice == 3) {
            roll(role);
        } else if (choice == 4) {
            displayRoleCard(role);
        } else if (choice == 5) {
            quit();
        }
    }

    public void cardMenu(Role role) {
        System.out.println("\nPlease choose one of following\n" + "(please follow the order from 1 to 7)");
        System.out.println("1. Set name\n" + "2. Set age\n" + "3. Set gender\n" + "4. Set job\n" + "5. Set states\n"
                + "6. Skill\n" + "7. Item\n" + "8. Previous menu\n");
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

    public void jobMenu(Role role) {
        System.out.println("\nPlease choose one of following jobs");
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

    public void skillMenu(Role role) {
        System.out.println("Skills: ");
        for (Skill s : role.getSkillList()) {
            System.out.print(s.toString() + ", ");
        }
        System.out.println("\nPlease choose one of following");
        System.out.println("1. Add new skill\n"
                + "2. Add skill points\n"
                + "3. Remove skill points\n"
                + "4. Previous menu\n");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1) {
            addSkill(role);
        } else if (choice == 2) {
            addSkillPoint(role);
        } else if (choice == 3) {
            removeSkillPoint(role);
        } else if (choice == 4) {
            cardMenu(role);
        }
        skillMenu(role);
    }

    public void addSkill(Role role) {
        if (role.getFreeSkillPoints() == 0) {
            System.out.println("Free points is 0 please go set up states and job first");
            mainMenu();
        }
        System.out.println("Free points: " + role.getFreeSkillPoints());
        System.out.println("\nPlease enter skill name");
        String skillName = input.nextLine();
        System.out.println("Please enter skill points");
        int points = input.nextInt();
        input.nextLine();
        role.addSkills(skillName, points);
        System.out.println("Free points: " + role.getFreeSkillPoints());
    }

    public void addSkillPoint(Role role) {
        if (role.getFreeSkillPoints() == 0) {
            System.out.println("Free points is 0 please go set up states and job first");
            mainMenu();
        }
        System.out.println("Free points: " + role.getFreeSkillPoints());
        System.out.println("Please enter skill name");
        String skillName = input.nextLine();
        System.out.println("Please enter skill points");
        int points = input.nextInt();
        input.nextLine();
        role.addSkills(skillName, points);
        System.out.println("Free points: " + role.getFreeSkillPoints());
    }

    public void removeSkillPoint(Role role) {
        if (role.getFreeSkillPoints() == 0) {
            System.out.println("Free points is 0 please go set up states and job first");
            mainMenu();
        }
        System.out.println("Free points: " + role.getFreeSkillPoints());
        System.out.println("Please enter skill name");
        String skillName = input.nextLine();
        System.out.println("Please enter skill points");
        int points = input.nextInt();
        input.nextLine();
        role.removeSkillPoints(skillName, points);
        System.out.println("Free points: " + role.getFreeSkillPoints());
    }

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

    public void addItem(Role role) {
        System.out.println("Please enter item name");
        String item = input.nextLine();
        role.addItem(item);
    }

    public void removeItem(Role role) {
        System.out.println("Please enter item name");
        String item = input.nextLine();
        role.removeItems(role.getItemsIndex(item));
    }

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

    public void actionMenu() {
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
        actionMenu();
    }

    public void quit() {
        System.exit(0);
    }

    public void setUpStates(Role role) {
        role.setStates();
        role.setHitPoints();
        role.setSanity();
        role.setMovement();
        role.setBonusDamage();
        role.setFreeSkillPoints();
    }

    public void setName(Role role) {
        System.out.println("\nPlease enter name");
        String name = input.nextLine();
        role.setName(name);
    }

    public void setAge(Role role) {
        System.out.println("\nPlease enter age");
        role.setAge(input.nextInt());
        input.nextLine();
    }

    public void setGender(Role role) {
        System.out.println("\nPlease enter age");
        role.setAge(input.nextInt());
        input.nextLine();
    }
}