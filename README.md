# Inversion de Contrôle (IoC) et Injection de Dépendances

## Description

Ce projet a été réalisé dans le cadre du module **Frameworks et Middleware**.
Il illustre le principe de **l'Inversion de Contrôle (IoC)** et de **l'Injection de Dépendances (DI)** en Java.

L'objectif est de comprendre comment réduire le **couplage fort entre les composants** d'une application et améliorer la **flexibilité et la maintenabilité** du code.

Le projet reprend l'exemple présenté dans les vidéos des séances et implémente plusieurs méthodes d'injection des dépendances.

---

# Partie 1 : Implémentation de l'Inversion de Contrôle

## 1. Création de l'interface IDao

Cette interface définit une méthode permettant de récupérer des données.

```java
public interface IDao {
    double getData();
}
```

---

## 2. Implémentation de l'interface

Une classe implémente l'interface `IDao`.

```java
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        return Math.random() * 100;
    }
}
```

---

## 3. Création de l'interface IMetier

```java
public interface IMetier {
    double calcul();
}
```

---

## 4. Implémentation avec couplage faible

La classe métier dépend de l'interface `IDao` et non d'une implémentation concrète.

```java
public class MetierImpl implements IMetier {

    private IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double data = dao.getData();
        return data * 2;
    }
}
```

---

# Injection des dépendances

## 1. Injection par instanciation statique

```java
public class Pres1 {
    public static void main(String[] args) {
        IDao dao = new DaoImpl();
        IMetier metier = new MetierImpl(dao);
        System.out.println(metier.calcul());
    }
}
```

---

## 2. Injection par instanciation dynamique

Les dépendances sont récupérées à partir d'un fichier de configuration `config.txt`.

```java
public class Pres2 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("config.txt"));

        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.newInstance();

        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

        System.out.println(metier.calcul());
    }
}
```

---

## 3. Injection en utilisant Spring Framework

### Version XML

Configuration via fichier XML :

```xml
<beans>
    <bean id="dao" class="DaoImpl"/>
    <bean id="metier" class="MetierImpl">
        <constructor-arg ref="dao"/>
    </bean>
</beans>
```

---

### Version Annotations

```java
@Component
public class DaoImpl implements IDao {
}

@Component
public class MetierImpl implements IMetier {

    @Autowired
    private IDao dao;
}
```

---

# Partie 2 : Mini Framework d'Injection de Dépendances

Dans cette partie, nous développons un **mini Framework similaire à Spring IoC** permettant de gérer automatiquement l'injection des dépendances.

## Fonctionnalités du Framework

Le framework doit permettre :

### 1. Configuration via XML

Utilisation de **JAXB (Jax Binding)** pour mapper les objets Java avec un fichier XML de configuration.

### 2. Configuration via Annotations

Les composants peuvent être configurés directement avec des annotations.

### 3. Types d'injection supportés

#### Injection via Constructeur

```java
public MetierImpl(IDao dao) {
    this.dao = dao;
}
```

#### Injection via Setter

```java
public void setDao(IDao dao) {
    this.dao = dao;
}
```

#### Injection via Attribut (Field Injection)

```java
@Autowired
private IDao dao;
```

---

# Technologies utilisées

* Java
* Maven
* Spring Framework
* Git
* GitHub

---

# Structure du projet

```
src
 └── main
     └── java
         └── net
             └── nawal
                 ├── dao
                 ├── metier
                 ├── pres
                 └── ext
```

---

# Gestion de version

Le projet est versionné avec **Git** et hébergé sur **GitHub**.
Des commits ont été effectués régulièrement durant la séance comme demandé.

---

# Ressource utilisée

Vidéo de référence :

https://www.youtube.com/watch?v=vOLqabN-n2k

---

# Conclusion

Ce projet nous a permis de comprendre :

* le principe de **l'inversion de contrôle**
* l'importance du **couplage faible**
* les différentes méthodes **d'injection des dépendances**
* le fonctionnement interne d'un **Framework IoC comme Spring**

---
