# The Call of Cthulhu(CoC) Gaming Tool

## Proposal

<p>Call of Cthulhu is a **horror fiction role-playing game** based on *H. P. Lovecraft's* story of the same name and the 
associated *Cthulhu Mythos*. It requires 1 to 8 players and a host to play. Players will 
make their imaginary characters with unique skills and states. Host will use those characters for a adventure in the 
fantasy world. 
All the events and actions in this game is decided by dice with different faces(ie. D3, D6, D20, ect).</p>>

<p>This application will help the players to make and manage theri characters in a Call of Cthulhu game. And this
application will also provide dices with different faces for players to use during the game.Mainly, the players will use 
this application. The reason why I am interested in making such a program is I am a big fan of
DND. However, it is really inconvenience to play this game in this special period. So I decide to make an application to
make playing DnD online easier and more manageable.</p>>

## User Stories

A *user stories* list:
- As a user, I want to be able to set character's states randomly.
- As a user, I want to be able to choose the dice I want to roll for different events.
- As a user, I want to be able to add/subtract a number to character's HP(hit points) and SAN(sanity).
- As a user, I want to be able to add character's skills to the skill list.
- As a user, I want to be able to add/subtract skill points to character's skills.
- As a user, I want to be able to remove character's skills from the skill list.
- As a user, I want to be able to add items to my character's item list.
- As a user, I want to be able to remove items to my character's item list.
- As a user, I want to be able to assign basic information(name, age, and gender) for my character.
- As a user, I want to be able to choose the job I want from given jobs.
- As a user, I want to be able to save my role card to file.
- As a user, I want to be able to load my role card from file.

## Phase 4: Task 2
The option I choose to implement is type hierarchy.
<p>The super class is Job. It represents a genetic Job class that include the most basic 
behaviors of a Job in this program, including set and get job's name, set and get job's credit, and set and get 
job's skill list.</p>
<p>Artist, Nurse, and Policeman are the subclasses of Job class. Method setJob() is override
in three of the subclasses. Each of the classes has it's own credit, name, and skill list. The setJob()
method overridden in each subclasses helpsthem to set up their own information in order to represent three different 
jobs. </p>

## Phase 4: Task 3
<p>There are some changes I could make to improve the code.</p>
<p>First, there is too much code duplication within RoleMaker class. To be specific, many methods for setting buttons 
and menu items to share is a similar code. It might be a good idea to write a helper method that receives a String name 
as the argument that could help set up buttons with different names and reduce code duplication.</p>
<p>Second, the Role class seems to has too many responsibilities and too many files. It manages the Role's name, age, 
gender, Job, Skill, item, states, and even manages the dice rolling. It would be a good idea to separate these 
responsibilities and files into several different classes. For example, file name, age, gender, and corresponding 
methods could be a move to a class could PersonalInformationManager. Files Job and its corresponding methods could be 
moved to a class called JobManager. List Skill and its corresponding method could be a move to a class called 
SkillManager. List Item, and it is the corresponding method could be a move to a class called ItemManager. All the 
states and their corresponding method to a class called StatesManager. Furthermore, lastly, dice files, and 
corresponding methods to a class called DiceManager. In that way, each class would only have one responsibility.</p>
<p>Third, there is some coupling between Skill class, Role class, Job class as Role class s=contains a collection of 
Skill. It means the Role could access Skill through this file. Role class also has a field of Job that has a 
collection of Skills. This means Role could access Skill class through Job class. Deleting the association between 
Skill and Role would reduce the coupling for the diagram.</p>
<p>Fourth, writing a few helper method for displaying method could help to reduce the semantic coupling between 
classes. Similar helper method could be applied to the methods that are hard coded.</p>
<p>Adding a few exception class could help to prevent user from entering unexpected value. It also make the
whole program more robust.</p>
