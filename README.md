# eCommerceWebsiteDiscountsApp

### An Android mobile application version of the eCommerceWebsiteDiscounts  

This program, written in Java, aims at calculating discounts for an online retail store customers, who are divided into three categories: Employee, Affiliate, Regular (i.e. customers for more than 2 years). Another category is therefore implicit in this, which is of customers who do not belong to any of these three categories. Each catefory, except for the implicit one, has a certain percent of discount they can avail, while a general discount is available to all who shop above a certain limit. Effort has been made to ensure best practices of Software Engineering and Object Oriented Programming.

### The App  

This Android application version of the [eCommerceWebsiteDiscounts](https://github.com/FaizanHZaidi/eCommerceWebsiteDiscounts/blob/master/README.md "eCommerceWebsiteDiscounts") allows users to interact with the program. They can select a customer type, set total bill amount, set grocery bill amount (if any) and calculate the total payable bill. They can then refresh the page at the touch of a button and re-enter new information.

### Understanding the structure of the program  

To keep the code simple and easily readable, there is only one Activity. It takes input from the user interface and calculates the payable bill. The logic for doing that is the same as in the previous program, linked above. The Java code for that sits in the eCommerceWebsiteDiscounts package of the app. 
