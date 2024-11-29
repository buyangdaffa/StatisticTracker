# My Personal Project
My project for CPSC210 is to develop an application for soccer coaches to track their players' statistics throughout the season. In this application, the coaches can add and update their player profiles, where each player will have several key metrics as their parameters, such as goals, assists, starting XI, substitutions, yellow cards, red cards, etc. The primary users of this application will be soccer coaches since I hope that this application can simplify data collection and visualization for coaches who don't have a computer science or statistics background, making it easier for them to make informed decisions.

I am particularly interested in this project because I am a big soccer fan and also previously worked as a Data Analyst Intern, where I was responsible for gathering statistics data and visualizing it for the coaches. By starting a project like this, I plan to build the application further even after the CPSC 210 course ends since I believe it will be an additional portfolio for me as an aspiring data analyst in the sports industry.⁤



## User Stories
- As a user, I want to be able to create a new player and add it to a list of players.
- As a user, I want to be able to view a list of available players for upcoming match based on their number of yellow cards, red cards and injury.
- As a user, I want to be able to create comparison visualization from the performance of key metrics (parameters) of two players.
- As a user, I want to be able to create simple dataframe for each players that shows their statistics records throughout the season.
- As a user, I want to be able to save the teams that I have created including all the players on that teams with their statistics.
- As a user, I want to be able to load the teams that I have created including all the players on that teams with their statistics.

## Instructions for End User
- You can add Player to a Team by running the StatisticTrackerGUI. Then, you need to create a Team first before you can add Players to the Team. You can create a Team by clicking "Create New Team" in the main panel of the application. After the team is successfully created, there will be a pop up message with a text "Team created successfully!". Now, you can add Player to the team by clicking the "View and Edit Teams" button at the main panel to go to the Team panel. Then, on the Team panel, there will be a button with a text "Add Player" which allows you to add Player to the team. You need to fill out the Player Name, Player Position, Player Age, Player Height and Player Jersey Number. Finally, you can click "OK" and a pop up message "Player added successfully!" will be shown on your screen which shows that the Player is successfully added to the Team.
- You can generate the first required action related to the user story "compare the performance of key metrics (parameters) of two players" by running the StatisticTrackerGUI. Then, you need to make sure that you already have a Team with at least 2 players in it. Then, you can click the "View and Edit Teams" button at the main panel to go to the Team panel. Then, on the Team panel, there will be a button with a text "Compare Players" which requires you to select two players that you want to compare. After that, the application will show you the comparison of those two players statistics.
- You can generate the second required action related to the user story "view a list of available players for upcoming match" by running the StatisticTrackerGUI. Then, on the main panel, you can click the "View and Edit Teams" to go to the Team Panel. Then, on the Team panel, in the middle of the panel there will be shown the list of players that is available for the upcoming match based on their injury status.
- You can locate my visual component by running the StatisticTrackerGUI. My visual component is located on the main panel of the application which is the logo of the application.
- You can save the state of my application by running the StatisticTrackerGUI. Then, in the main panel, there will be a button with a text "Save Teams to File" that you need to click which allows you to save your current state of data to the JSON file.
- You can reload the state of my application by running the StatisticTrackerGUI. Then, in the main panel, there will be a button with a text" Load Teams from File" that you need to click which allows you to load your JSON file as the data input for the application you currently running.

## Phase 4: Task 2
Event log:
created team Indonesia that is coached by Shin Tae Yong // Fri Nov 29 03:56:54 PST 2024
created player Thom Haye with jersey number 19 who plays as a MF // Fri Nov 29 03:57:09 PST 2024
added player Thom Haye to team Indonesia // Fri Nov 29 03:57:09 PST 2024
added a win to Thom Haye // Fri Nov 29 03:57:12 PST 2024
added a win to team Indonesia // Fri Nov 29 03:57:12 PST 2024
added a loss to Thom Haye // Fri Nov 29 03:57:13 PST 2024
added a loss to team Indonesia // Fri Nov 29 03:57:13 PST 2024
added a draw to Thom Haye // Fri Nov 29 03:57:14 PST 2024
added a draw to team Indonesia // Fri Nov 29 03:57:14 PST 2024
added a yellow card to Thom Haye // Fri Nov 29 03:57:16 PST 2024
added a red card to Thom Haye // Fri Nov 29 03:57:17 PST 2024
changed injury status of Thom Haye // Fri Nov 29 03:57:17 PST 2024
added 65 minutes to Thom Haye // Fri Nov 29 03:57:21 PST 2024
added a goal to Thom Haye // Fri Nov 29 03:57:23 PST 2024
added an assist to Thom Haye // Fri Nov 29 03:57:24 PST 2024