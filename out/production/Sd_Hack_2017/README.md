# Sd_Hack_2017
MLH Sd_Hack_2017 <br>
The purpose for the project is to build a parking-guidance system. <br>
When people search a destination, our App/Web should be able to return names and locations of the available parking spaces which are closest to the destination location. There should be two types of parking areas, public parking stations and private sharing slots. When people select one of the parking spaces, our App/Web should be able to guide the customer to the available parking lot (Note: not the parking station, but the specific parking lot). 

# Realization [In order to maximize our efficiency. We will skip partI and start by partII]
<b>Part I</b> <br>
First we need to build a system of maps (demo) where people can find closest parking lots based on a specific location input. <br>
Then we need to build database system for both public and private parking spaces (we will focus on the public system first). <br>
The parking space searching system and our specific parking-station parking lot availability system should be connected together. So that people should be able to find specific parking lot base on a location input. 
<br>
<b>Part II</b> <br>
Then we can start doing the private sharing parking spaces. 
<br>
Note: [The graphic team should work at the same time:: HTML/CSS]
<br>
The private sharing parking lots have two ends: The owners who supply empty parking spaces, and the customer who rent the parking spaces. Thus we need to make the system writable for owners and readable for customers. The system will work like this: The owners will signup an account, verify themselves (use API:https://www.docusign.com/developer-center/api-overview), then submit info to our backend. Our backend will approve the info and put it into our system. The customers will find the parking lot information as usual.


# What's difficult
We haven't mastered the skill to catch and use interactive database system through html by JS yet. We need to learn this part.
<br>
We can try easy PounchDB as basic interactive system. <br>
Once we are done with the database, we can merge the front and back end together.


# Plan
We will split into two teams. <br>
<font>&emsp;One is for html.</font> <br>
<font>&emsp;One is for back end development.</font><br>
<b>Front End</b>: Multiple display pages <br>
<b>Back End</b>: Three ends: Owner, backend, Customer. Relation: Owner will signup, then submit info about their parking lot, the backend will receive it and approve or disapprove. Backend should have information about every signuped owners and customers. Customers can check the avaiablity list and select for occupy. The total parking availability list should be public so that the information of that should be updated for every approved new parking lots and newly occupied ones. 
<br>
Then we should learn the database system. <br>

<b>Explaination</b>: We should finish the front and backend during today and then focus on the database system together at least by tomorrow.






