# AlbumManager

Web application created with Java

### Table of Contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [To-do](#to-do)

## General info
AlbumManager is a web application that can be used to manage album collection.

## Technologies

Spring (+ Spring Security), Hibernate, Maven, HTML, MySQL, Bootstrap

## Setup

To get access to the application, clone repository and open it as a Maven project.
GroupId - pl.coderslab
ArtifactId - AlbumManager
Additionally, there's MySQL database and Tomcat needed.

Deployed version (to be continued): 

* http://77.55.213.198:8080/AlbumManager-1.0-SNAPSHOT/
* patrykleczycki.pl

## Features

* User management (Spring Security: registration panel - passwords hashed with jBCrypt, login panel, permissions depending on user role)
* Entities - album, artist, label
* User can add entities objects and create and edit own album collection
* Admin has the same permissions as an user, additionally he can modify other users' permissions

## To-do
* Sending authentication token on e-mail address during registration/recovering password
* Add image upload functionality to enable adding cover to album
