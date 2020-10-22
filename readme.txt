This program prints all the possible tickets/fares you can choose between in sorted order.
It takes input in following format:
targetSource targetDestination
source destination fare
source destination fare
.
.
.
source destination fare
source destination fare


where, 
targetSource and targetDestination are the actual source and destination person is willing to travel.
all the below lines containing 'source destination fare' indicate ticket options and respective fare available.

Input Example:
mumbai bangalore
mumbai pune 200
pune bangalore 300
mumbai bangaore 1000
mumbai vashi 100
vashi pune 250
mumbai thane 200

Output for the above i/p:
mumbai pune bangalore 500
mumbai vashi pune bangalore 650

Explaination:
1 st line shows that person wants to travel from Mumbai to Bangalore.
remaining lines show: ticket and it's fare. for eg. there is a ticket from mumbai to pune which has fare of 200rs.

So in order to go from Mumbai to Bangalore there are 2 options: 1st is Mumbai to Pune=200 then Pune to Bangalore=300 i.e.(200+300=500).
And 2nd option is mumbai to vashi=100 then vashi pune=250 and then travel from pune to bangalore=300 i.e(100+250+300=650)


to run the code use following commands:
1. javac ticket.java
2. java ticket
