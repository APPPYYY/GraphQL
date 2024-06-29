# GraphQL with Spring Boot - POC
## Overview

This project is a Proof of Concept (POC) that demonstrates the integration of GraphQL with Spring Boot. The goal is to showcase how GraphQL can be used to build a flexible and efficient API, highlighting its benefits and various real-world applications.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Schema](#schema)
- [Setup](#setup)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Efficient Data Fetching:** Request only the data you need.
- **Strongly Typed Schema:** Ensures data integrity and consistency.
- **Single Endpoint:** Simplifies client-server interactions.
- **Real-time Data with Subscriptions:** Supports live updates.
- **Comprehensive Queries and Mutations:** Covers various real-world use cases.

## Technologies Used

- **Java 17**
- **Spring Boot 3.3.1
- **GraphQL Java**
- **Spring Data JPA**
- **Postgresql Database** 

## Schema

### Types

type UserEntity {
  userId: ID!
  name: String
  phone: String
  email: String
  password: String
  orders: [OrderEntity]
}

type OrderEntity {
  orderId: ID!
  orderDetails: String
  address: String
  price: String
  user: UserEntity
}
Queries

type Query {
  findAllUsers: [UserEntity]
  findUserByUserId(userId: ID!): UserEntity
  findAllOrders: [OrderEntity]
  findOrderByorderId(orderId: ID!): OrderEntity
}
Mutations

type Mutation {
  createUser(name: String, phone: String, email: String, password: String): UserEntity
  deleteUserByUserId(userId: ID!): Boolean
  createOrder(orderDetails: String, address: String, price: String, userId: ID!): OrderEntity
  deleteOrderByorderId(orderId: ID!): Boolean
}
Setup
Prerequisites
Java 17
Maven
Installation
Clone the repository:

bash
git clone https://github.com/yourusername/your-repo.git
cd your-repo
Build the project:

bash
mvn clean install
Run the application:

bash
mvn spring-boot:run
Usage
Access GraphQL Playground
Once the application is running, you can access the GraphQL Playground at:

bash
http://localhost:1122/graphiql OR http://localhost:1122/mypath
Example Queries
Find All Users:

graphql
query {
  findAllUsers {
    userId
    name
    phone
    email
  }
}
Create a User:

graphql
mutation {
  createUser(name: "John Doe", phone: "1234567890", email: "john.doe@example.com", password: "password") {
    userId
    name
    email
  }
}
Contributing
Contributions are welcome! Please fork this repository and submit a pull request for any improvements or bug fixes.

Fork the repository
Create a feature branch
Commit your changes
Push to the branch
Create a new Pull Request
License
This project is open-source.

Contact
For any inquiries or support, please contact comeflywithmes1999@gmail.com.

---
