The implemented solution consists of two activities. The main activity where the list of banks obtained from the rest API is displayed, and the detail activity where the extra information of the bank selected in the main activity is displayed. I decided to use activities for the purposes of practicality and time savings compared to the implementation of the navigation component, and thus be able to navigate from the main activity to the secondary activity in a simpler way.
The main screen has the search component that fulfills the described functionality of filtering the banks in the list by name, and the component that contains the list.
Each item in the list contains the image of the bank, the name, and the description, which I consider to be important data to show to the user, as well as the icon to select the banks as favorites.
The bank detail activity displays the complete information of the selected bank.

To work on this project using the scrum methodology, I would organize the work as follows:
1. Define the objective.
2. Define the deliverables or the MVP (Minimum Viable Product)
4. Define the technical requirements.
5. Define the size of the team and the role of each team member, as well as their activities.
6. Define user stories. (Epics)
7. Define the use cases for each user story (Features).
8. Generate a Product Backlog with all the Epics.
9. Define the Sprint time (min 15 days per Sprint)
10. Assign the Epic to the Sprint that is going to be worked on.
11. Assign the use cases with the corresponding tasks to the team members.
12. Define time for Daily Stand Ups (meetings of 15 minutes maximum to follow up on tasks). The format for the Daily is as follows:
   * What I worked on yesterday.
   * What am I going to work on today
   * I have an issue or blocker that prevents me from continuing with my work.
13. Completion of the Sprint and a day before having a meeting for the next Sprint Planning.
14. The QA area must have an outdated Sprint to be able to test the developers' deliverables from the past Sprint.
15. Schedule releases every QA Sprint completion.

--Instructions to build and run the project--
It is necessary to have the most up-to-date version of the Android Studio IDE to avoid AGP compatibility issues.
After cloning or downloading the project from the GitHub repository, you only need to run the project from the Android Studio IDE, either on a physical device or a device emulated from the IDE. Clarifying that in any case, you must have a minimum version of SDK 28.
