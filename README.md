# TP 4 – Architecture Orientée Services et APIs  
## Application du laboratoire scientifique (Microservices, Security, Eureka, OpenFeign, Config Server)

Ce repository contient une application basée sur une architecture microservices.  
Elle implémente l’authentification sécurisée, la découverte des services, la configuration centralisée, la communication inter-services via OpenFeign, et la gestion des enseignants, chercheurs et projets scientifiques.

---

## 1. Architecture Globale des Microservices

### 1. Configuration_Service (Spring Cloud Config Server)
- Fournit une configuration centralisée pour tous les microservices.
- Connecté à un dépôt Git contenant les fichiers de configuration.
- Inclut Actuator (`/actuator/refresh`).
- Enregistré comme Eureka Client.

### 2. Discovery_Service (Eureka Server)
- Service de découverte dynamique.
- Tous les microservices s’y enregistrent automatiquement.
- Permet au Gateway et aux clients Feign de localiser les services sans connaître leurs ports.

### 3. Gateway_Service (Spring Cloud Gateway)
- Point d’entrée unique dans l’architecture.
- Gère le routage dynamique vers les microservices enregistrés dans Eureka.
- Intègre Actuator pour le monitoring.

### 4. Security_Service
Service responsable de l’authentification et de la gestion des tokens JWT.  
Fonctionnalités :
- Gestion des utilisateurs (enseignants et chercheurs).
- Génération et validation des tokens JWT.
- Sécurisation des endpoints des autres services.

Inclut : Spring Security, OAuth2 Resource Server, JWT, Actuator, Eureka Client, Config Client, OpenFeign.

### 5. MicroService Enseignant
- Fournit les opérations CRUD des enseignants.
- Affiche les statistiques sur les chercheurs et les projets associés via OpenFeign.

Inclut : Actuator, Eureka Client, Config Client, OpenFeign.

### 6. MicroService Chercheur
- CRUD des chercheurs.
- Méthode permettant de compter les chercheurs associés à un enseignant donné.

Inclut : Actuator, Eureka Client, Config Client, OpenFeign.

### 7. MicroService Projet
- Gestion des projets scientifiques.
- Fonction pour obtenir le nombre de projets assignés à un enseignant.

Inclut : Actuator, Eureka Client, Config Client, OpenFeign.

---

## 2. Technologies & Bibliothèques Utilisées

### Backend
- Java 17+
- Spring Boot 3+
- Spring MVC
- Spring Data JPA
- Hibernate
- MySQL

### Microservices (Spring Cloud)
- Spring Cloud OpenFeign
- Spring Cloud Gateway
- Spring Cloud Config Server
- Spring Cloud Config Client
- Spring Cloud Netflix Eureka Server
- Spring Cloud Netflix Eureka Client
- Spring Boot Actuator

### Sécurité
- Spring Security
- OAuth2 Resource Server
- JWT

### Outils
- Maven
- Lombok
- Swagger / OpenAPI

---

## 3. Fonctionnement Général

1. Le Config Service charge la configuration depuis un dépôt Git.
2. Chaque microservice récupère sa configuration via le Config Client.
3. Tous les microservices s’enregistrent dans Eureka Server.
4. Le Gateway route les requêtes vers les microservices appropriés.
5. Le Security Service génère et valide les tokens JWT.
6. Les microservices communiquent entre eux via OpenFeign.
7. Actuator fournit des endpoints de monitoring.

---

## 4. Ordre de Démarrage Recommandé

1. Configuration_Service  
2. Discovery_Service (Eureka Server)  
3. Gateway_Service  
4. Security_Service  
5. Enseignant_Service  
6. Chercheur_Service  
7. Projet_Service

---
