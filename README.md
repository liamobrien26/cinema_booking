# Cinema Booking

This Java/Spring Boot project is developed for Cinema Booking.

## Technologies used

- **Maven**: Build automation tool for managing dependencies and building the project.
- **Mustache**: Template engine for rendering views in the application.
- **MongoDB**: NoSQL database used for data storage and management.
- **Spring Security**: Login security (With spring security you're required go use a token to access other pages whilst using Thyme Leaf, it automatically does that for you. For mustache, you are required to do it manually )

## QuickStart instructions



1. **Build and Run the Application:**
    - Use Maven to build the project and start the server:
      'mvn spring-boot:run'

2. **Connect to Mongo**
   - 'docker-compose.yml' and click on the play button
     

3. **Access the Application:**
    - Open a web browser.
    - Navigate to [http://localhost:8080/movies](http://localhost:8080/movies) to access the application.

**STEPS TO TAKE NEXT**

--Add validation on register page (e.g. enter phone number if blank, etc.)

--Add Admin role, will need to create a field for user roles in the database. (line 26 on UserDetailsService is where I can add roles)

--Mustache: add partials, layout templates, etc. (e.g. header, footer, etc.) Read through documentation for mustache to understand how it works.

--TESTS: Unit testing, component testing, black box testing, acceptance test(rendering page tests), etc.

--DTO (Later stage)

--Explain how VIEW_NAME & MODEL_NAME works

--Explain tokens

--FIX REGISTER 
