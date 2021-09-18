# Database View

## Introduction
In a situation where we want a single source of data for multiple services, a view can be used to mitigate the concerns regarding coupling. With a view, a service can be presented with a schema that is a limited projection from an underlying schema. This projection can limit the data that is visible to the service, hiding information it shouldn’t have access to.

## The Database as a Public Contract


![database view](images/databaseView1.PNG)

## Limitations 

- It's important to see the impact on performance of the views (cache vs online query)
- There are database engines that only support read-only views

## Where to Use It

- Should be avoided as much as possible
- There are times when other services cannot be updated to use a service and need to access directly to the database

## Our Example

This is a very simple SpringBoot project to manage customers. 

- In the v1, we have all services get data from the monolith schema:

![database view_v1](images/databaseViewV1.PNG)

- In the v2, we have one microservice (loyaltyService) get data from the loyalty schema through a view:

![database view_v2](images/databaseViewV2.PNG)


## Deployment

We are going to user a Docker compose file to deploy the examples: 

- In the v1 version we are going to deploy the database, and the v1 of the monolith and the loyalty service. Both services  will be hosted on dockerhub.



- In the v1 version we are going to deploy the database, and the v1 of the monolith and the loyalty service. Both services  will be hosted on dockerhub.


Both services uses mysql as database, whose tables are created by hibernate in the startup.

Three self-explaining entities:

    Book
        id
        title 
        summary
        author
        publisher 
        publicationYear 
        comments (OneToMany)
    Commment
        id
        comment
        score
        book (ManyToOne)
        user (ManyToOne)
    User
        id
        nick
        email
        comments (OneToMany)



