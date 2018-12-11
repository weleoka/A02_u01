module name: A02_u01

# Assignment II - WakeUpGym
Java application that works towards a CSV database for persistance.

The purpose of the work is to learn basic Java and java best practices. The work is wholly my own, but nevertheless a product of discussion with teachers and other students.  

There are three secret menu items in mainMenu for testing purposes:

```java
case 3: // Secret case for making default rooms.
    generateDefaultRooms();
    break inputLoop;

case 4: // Secret case for booking an activity. Will fail because no userID.
    bookActivity();
    
case 5: // Secret case for listing users.
    listUsers();
```

### Joblist
A few points that could be improved upon in the code in the repository. 

* repo: remove the current *.jar dependency files as included in src in this repository. Bring dependencies in dynamically for forks and clones of this repo.


### Style guide
This project conforms to an older version of the following [style guide](https://github.com/weleoka/myJavaStyleGuide).
The mian difference is this projects adherance to vertically aligned braces on the same column for constructs. This is depreciated in later versions of the style guide.


### UML diagram
The application has the following structure. This diagram is not a live view of the code implementation and requires manual updates. The Diagram is generated from PlantUML markdown language.

![ . . . ](UML_A2.png)

by Kai Weeks, student at Luleå Tekniska Universitet



### Activity Flows


#### Flow - new user:
1) A user starts the application and selects registerUser from mainMenu.
2) The user is prompted for a userName and then a userID.
3) The userID is then checked for validity.
4) A new User is created and the selectedUser is set in UserControl.
5) The new user is prompted for number of months of subscription.
6) A new subscription is created with the date as and from now() and the usersID.
7) SubscriptionControl has the selectedSubscription variable populated.
8) The cost is calculated and displayed to user. If the selectedUser is not Active
    then a membership fee is added to the total.
9) If the user accepts the price then the Subscription and the User are set to Active


#### Flow - Login
1) A user starts the application and selects loginUser.
2) The user is prompted for a name and then a userID.
3) If these are found in the system then the user is authenticated.
4) The menu changes to the loggedInMenu.


#### Flow - Book Activity
1) Same flow as for Login and then:
2) The user selects bookActivity from the loggedInMenu.
3) A check is done that the user has a valid subscription and
    that the membership is still in date.
3) If checks pass then program fetches a list of available activities.
4) The user selects an activity from the list.
5) The program fetches a list of available spaces in the room for that activity.
6) Then the user selects a space and the program checks that it is a vailable,
    and that the user is not already booked.
7) Once the user has found an available place then the room is updated with the userID to that place
8) Room saved to database and user is given a confirmation message.
9) Program returns to main menu.

