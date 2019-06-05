# AlbumManager

Web application created with Java

### Table of Contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [To-do](#to-do)

## General info
AlbumManagers is a web application that helps user with managing his music albums
collection. It provides register and password retrieval functionalities
based on Spring Security. It allows user to add music labels, artists or
bands and albums that are based on these ones and can be added to
user's private collection.

## Technologies

Spring Boot, Spring Security, Hibernate, Maven, HTML, CSS, JavaScript, jQuery, MySQL, Bootstrap

## Setup

To get access to the application you can:

* clone repository and open it in your IDE (MySQL database and Tomcat needed)
* visit http://pleczycki.pl/albummanager 

## Features

* User management (Spring Security: registration panel - passwords hashed with jBCrypt, account verification and password recovery based on authentication tokens, login panel, permissions depending on user role)
* Entities - album, artist, band, label
* User can add entities objects and create and edit own album collection
* Admin has the same permissions as an user, additionally he can modify other users' permissions

## To-do

* Add image upload functionality to enable adding cover to album
* Add tracklist feature
* Add OAuth2 authentication
* Correct Spring Security login error messages
