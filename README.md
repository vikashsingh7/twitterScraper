# twitterScraper
A Spring Boot aaplication that uses Twitter API to search and filter Public Tweets

Go to "https://developer.twitter.com/" and create an account to generate API tokens that will be used to Authenticate you.

Setup for Angular FrontEnd:
1. Import the project then run "npm install".
2. Run "npm install @angular-devkit/build-angular@0.901.9" to fix some issues.
3. Run "ng serve" and make sure the server is running on localhost:4200.

Setup for Spring Boot BackEnd:
1. Import the project.
2. Replace Dummy Values for Twitter API tokens recieved earlier with values(Bearer Token is enough for now as all the processes require OAuth 2.0).
3. Enter Credentials for MYSQL Datatbase in applicatio.properties.
3. Install all the dependencies present in Maven file(mvn install).
4. Start the server.

Setup for Database Operation:
1. Create a user with Username and password as "twitterApp" or create a new Schema and generate your own username and passwords(make sure to include them in application.properties) in the spring-boot app.
2. Run the DataBaseScripts.sql file to generate tables.


A Free Template is used for FrontEnd to make the design process faster and for further enhancements.
The template is free under MIT license("https://github.com/creativetimofficial/paper-kit-2/blob/bootstrap4-development/LICENSE").
