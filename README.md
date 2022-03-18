# NBA-API

Why are we doing this?

  The API is designed for users to be able to add and read NBA players to a database table along with some basic stats. It is intended as a way to interact with an information repository on players for recreational or analytical purposes.
  
How I expected the challenge to go

  I expected the creation of the MVP to go smoothly since it was something I had done independently already, but the writing of tests was something I thought may take more time and effort to get right.
  
What went well/ What didn't go as planned

  As expected, writing the code for the API itself went smoothly. I had some issues with the integration testing of the controller in particular due to some mistakes I made with the .sql files populating my H2 test database.
  
Possible improvements

  The addition of signifacntly more columns for further statistical categories would make the API much more useful, as currently its scope is very limited. Further test coverage would also be good, as it is currently sitting just over 80%.
  
Postman request and MySQL database screenshots

Create function:

![image](https://user-images.githubusercontent.com/97948199/158952671-77dc7899-cf4e-4737-9db7-54f68ef75c18.png)
![image](https://user-images.githubusercontent.com/97948199/158954332-7b0c309a-ab78-41c7-aaa3-3c39d902503a.png)

Read function:

![image](https://user-images.githubusercontent.com/97948199/158952778-bdf654c2-2cbc-47df-8654-cf659d712606.png)

Update function:

![image](https://user-images.githubusercontent.com/97948199/158954419-d89389c5-c102-4a96-bd42-6b1136aeac04.png)
![image](https://user-images.githubusercontent.com/97948199/158954486-9c8c8564-a5ab-4f4b-97f4-f94bb06c40ed.png)

Delete function:

![image](https://user-images.githubusercontent.com/97948199/158954851-72ff1af6-c230-4f57-a56c-a421c765ee29.png)
![image](https://user-images.githubusercontent.com/97948199/158954889-76c04c5f-5aee-4cda-aa4e-a16d64ceae01.png)

Test result screenshots

Test passing:

![image](https://user-images.githubusercontent.com/97948199/158955146-1f8ee5d1-ae2c-49fb-a647-e5b19f415be4.png)

Test Coverage:

![image](https://user-images.githubusercontent.com/97948199/158955347-8f1ad530-09a8-40ea-ac2c-cbae8e40e328.png)

Jira board link:

https://alishep.atlassian.net/jira/software/projects/NBA/boards/2/roadmap?selectedIssue=NBA-16

