# Plateforme de Réservation d'Ateliers Artisanaux avec Spring Boot

Bienvenue dans l'application de réservation d'ateliers artisanaux ! Cette plateforme vous permet de parcourir différents ateliers, de réserver des créneaux, et de gérer vos réservations. Les artisans peuvent mettre en place leurs ateliers, gérer les créneaux disponibles, et suivre les réservations.

## Technologies Utilisées

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Thymeleaf](https://www.thymeleaf.org/)
- [MySQL](https://www.mysql.com/)

## Configuration de l'Environnement de Développement

1. Clonez le projet depuis le repository Git.
2. Importez le projet dans votre IDE favori.
3. Configurez le fichier `application.properties` pour la connexion à votre base de données MySQL.

## Base de Données

Assurez-vous d'avoir créé la base de données via MySQL Workbench en utilisant les paramètres de configuration spécifiés dans le fichier `application.properties`.

## Exécution de l'Application

1. Exécutez l'application en tant que projet Spring Boot.
2. Accédez à l'application via [http://localhost:8080](http://localhost:8080).

## Fonctionnalités

- Affichage de la liste des ateliers
- Réservation d'un créneau
- Annulation d'une réservation

## Structure du Projet

- `src/main/java/com.example.reservation_app`: Contient les classes Java, les contrôleurs, les services, les repositories, etc.
- `src/main/resources/templates`: Contient les templates Thymeleaf pour les pages HTML.

## Contribution

Si vous souhaitez contribuer à ce projet, n'hésitez pas à ouvrir une Pull Request ou à signaler des problèmes.

## Auteur

Justine Clément

---

**Note**: Assurez-vous d'avoir correctement configuré votre environnement et votre base de données avant d'exécuter l'application. Consultez les sections ci-dessus pour plus d'informations.
