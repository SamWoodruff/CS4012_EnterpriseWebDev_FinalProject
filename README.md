Final Project

Developer:
Samuel M. Woodruff
Yun Lu

Put the following code into context.xml under conf folder of TomCat root folder to enable the DataSource:
    <Resource url="jdbc:mysql://localhost:3306/enterprise" driverClassName="com.mysql.jdbc.Driver" password="root" username="root" maxWait="10000" maxIdle="5" maxActive="20" type="javax.sql.DataSource" name="jdbc/enterprise"/>
    Should be placed under Context Property.

