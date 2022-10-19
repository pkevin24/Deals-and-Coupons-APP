# Deals-and-Coupons-APP
Microservice WebApp for Deals and Coupons

## About this Service
### Deals and Coupons Api Gateway
•	This service provides an entry point for all API Interfaces for the UI client.

•	Request validation through JWT token auth.

•	Swagger API documentation for various microservices.

### Eureka Microservice
•	Eureka microservice is used to register various other microservices like User, Deals and Coupouns used in our project.

### User Microservice
•	This microservice provides authentication and validation using JWT(JSON WEB Token) Authentication.

•	It has the capabilities to add, delete, edit User details as well as encrypt User password.

•	Admin section enables the admin(Admin role) to access details of Coupouns, Users and Deals which includes editing. User will just be able to view and redeem coupons or deals. 


### Deals Microservice
•	This microservice will enable the admin to add, edit or remove deals.

•	And provides various deals to the user based on the deals added by the Admin, and will redirect to the deals website.

### Coupons Microservice
•	This microservice will enable the admin to add, edit or remove coupons.

•	And provides various coupons to the user based on the coupons added by the Admin.

## FrontEnd

### Login Page

•	Login page contains username and password to authenicate the users, and the admin uses the same webpage which redirects to admin dashboard. 

• It has link which redirects to signup page for new user.

### Signup Page

• It takes the details of new users like username, name, password, etc which gets stored into the database(MongoDB).

• It validates for exisiting username and email making sure that duplication is avoided. It also validates all the other fields based on the pattern provided by us.

• Once the login validation is completed and details are stored in the database, it redirects to the login page.

### Admin page

• Admin has access to the details of Users, Coupons and Deals. Where the admin can add/edit/delete the details.

• It makes sure that only admin has the access to the dashboard and other users will be intercepted to the forbidden page.

### News API

• News API provides top headlines across the world, which can be accessed without the user or Admin logging in.

### Deals and Coupons page

• User will be able to view or redeem various deals and coupons. In case of deals, when a user clicks on any deal it will redirect to the particular deal's website and coupon's code will be redeemed. 

• Deals and Coupons when redeemed will be reflected in the user database.

## Database(DealsCoupons)

### Various Collections used in our project are as follows

• Users

• dbsequence

• Roles

• Deals

• Coupons











