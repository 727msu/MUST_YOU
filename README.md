# Projects Introduction

MUST Campus Open Day Reservation System.

You can log in to the system on a specific date to make reservations for campus access and multiple activities.

# Environments

Front-end: 
	NodeJS v20.1
Back-end:
	java 17
Database: 
	MySQL8

# Installation Tutorial

1. Import the database scheme structure domain data (in the backend resource directory, under /src/main/resource/db).
2. Enter the root directory of the backend project
3. Check if you have a backend runtime environment
4. Use `java -version` to check the Java version.
5. Use the java package management tool maven to import Java dependencies `mvn dependency:resolve`. 6.
6. Start the back-end project `mvn spring-boot:run`. 7.
7. Go to the root directory of the front-end project.
8. Check if the front-end runtime environment is included `Node -v` to see the current NodeJS version.
9. Install the frontend package management tool pnpm, `npm i pnpm -g`. 10.
10. Run the frontend project `pnpm run dev`.

# Instructions for Use

1. User registers for a user account through the registration page, using phone number.

2. Login to the system through the login page.

3. Users can make reservations for school activities only after they have made a reservation for school admission.

4. Users can check the booked activities through the order page.


# Development

## Front-end: 

Technology used:

    * [VueJS](https://vuejs.org/): An incremental JS framework      
    * [taiwindCSS](https://tailwindcss.com/): An atomized CSS framework
    * [Pinia]
    * TypeScrip language


## Back-end:

    * [Spring framework](https://spring.io/) 
    * [MyBatis](https://mybatis.org/mybatis-3/) 

## Database:

    * [MySQL]

# Update Logs

1. Registration Page Exception - Regular Field Validation Result Error

    ```vue
    <script setup>
    const phoneRegex = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$/;
      //  Modify: 
      //  if (!phoneRegex.test(form.value.username))
      //  to: 
          if (phoneRegex.test(form.value.username))
    </script>
    ```
    
2. Modify Appointment Entry Interface Statistics Exception - Modify SQL statement in MyBatis mapper file

    ```sql
            SELECT timeSlot, COUNT(user_id) AS number
            FROM booking
            <if test="date != null">
                WHERE DATE(date) = #{date}
            </if>
            //Adding a group statement
            GROUP BY timeSlot
            order by timeSlot;
    ```

3. perf store the activity data into localStrong, refresh the page from the local read, reduce the pressure on the back-end server.

    ```ts
    localStrong.setItem('ACTIVITY_DETIAL',JOSN.Stringity(res.data));
    ```

# Authors
    PM: Wenxin Chi
    Designer: Wenqi Gong
    Developer: Zhuohan Fu
    Testing: Yuhan Bai
