# Solid Principles


## Author: Ursu Vlad

----

## Objectives:

* Study and understand the SOLID Principles.
* Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
* Create a sample project that respects SOLID Principles.


## Laboratory Notes:

* Used Java for the programming language for it's OOP properties, as well as for practicing a bit more,
since Java experience beforehand was pretty scarce.
* Decided to create a Sample project for a train management system, because trains are cool.


## Implementation

* There are classes for almost everything, starting with trains, carriages, locomotives, passengers, etc.
Additionally, there are interfaces for these classes to use and to adhere to the SOLID principles.


* The following is a list of code snippets, each showcasing a SOLID principle in action.



### Single Responsibility Principle:
* Classes have only one job to do, for example are the RegisterEconomy and RegisterBusines
classes, each doing the specific job of creating a train ticket for economy class and
business class respectively.
```
public class RegisterEconomy implements calculatePrice{
    private EconomyTicket ticket;

    public void createTicket(Train train, Carriage carriage, int seatNumber){
        this.ticket = new EconomyTicket(train, carriage, seatNumber);
    }

    public EconomyTicket getTicket(){
        return ticket;
    }

    public double returnPrice(){
        return 50.00;
    }
}

public class RegisterBusiness implements calculatePrice{
    private BusinessTicket ticket;

    public void createTicket(Train train, Carriage carriage, int seatNumber){
        this.ticket = new BusinessTicket(train, carriage, seatNumber);
    }

    public BusinessTicket getTicket(){
        return ticket;
    }

    public double returnPrice(){
        return 100.00;
    }
}

```

### Open-closed principle:
* Instead of creating a single Locomotive class, and adding more and more if-statements,
the Locomotive class has different subclasses for the new types of locomotives to be added.

```
public class Locomotive {
    protected String id;
    protected int maxLoad;
    protected int maxSpeed;

    public Locomotive(String id, int maxLoad, int maxSpeed){
        this.id = id;
        this.maxLoad = maxLoad;
        this.maxSpeed = maxSpeed;
    }
}

public class DieselLoco extends Locomotive implements Sounds{
    public DieselLoco(String id, int maxLoad, int maxSpeed){
        super(id, maxLoad, maxSpeed);
    }

    @Override
    public void locoSound(){
        System.out.print("choochoo");
    }
}



public class ElectricLoco extends Locomotive implements Sounds{
    public ElectricLoco(String id, int maxLoad, int maxSpeed){
        super(id, maxLoad, maxSpeed);
    }

    @Override
    public void locoSound(){
        System.out.print("choochoo");
    }
}



public class SteamLoco extends Locomotive implements Sounds{
    public SteamLoco(String id, int maxLoad, int maxSpeed){
        super(id, maxLoad, maxSpeed);
    }

    @Override
    public void locoSound(){
        System.out.print("choochoo");
    }
}

```

### Liskov Substitution Principle
* The different locomotive subclasses mentioned above, can substitute their parent 
Locomotive class with no issues. An example of this is in the train class, where the
required type in the Train Constructor is Locomotive, and any of the subclasses works
for instantiation.


### Interface Segregation Principle
* A small example of this principle being applied are the Passenger and TrainManager
classes. Each class uses interfaces tailored to their own needs, without any irrelevant
interface for their specific class.

```
interface reserveTicket{
    public void reserveEconomy(Train train, Carriage carriage, int seatNumber);
    public void reserveBusiness(Train train, Carriage carriage, int seatNumber);
}

public class Passenger extends User implements reserveTicket{
    private Ticket ticket;

    public Passenger(String id, String name){
        super(id, name);
    }

    @Override
    public void reserveEconomy(Train train, Carriage carriage, int seatNumber) {
        RegisterEconomy ecRegistry = new RegisterEconomy();
        ecRegistry.createTicket(train, carriage, seatNumber);
        ticket = ecRegistry.getTicket();
    }

    @Override
    public void reserveBusiness(Train train, Carriage carriage, int seatNumber) {
        RegisterBusiness buRegistry = new RegisterBusiness();
        buRegistry.createTicket(train, carriage, seatNumber);
        ticket = buRegistry.getTicket();
    }
}




interface createTrain{
    public Train buildTrain(String id, Locomotive loco);
}

interface attachCarriage{
    public Train addCarriages(Train train, Carriage newCarriage);
}


public class TrainManager extends User implements createTrain, attachCarriage{
    public TrainManager(String id, String name) {
        super(id, name);
    }


    @Override
    public Train buildTrain(String id, Locomotive loco) {
        Train newTrain = new Train(id, loco);
        return newTrain;
    }

    @Override
    public Train addCarriages(Train train, Carriage newCarriage) {
        train.addCarriage(newCarriage);
        return train;
    }
}

```

### Dependency Inversion principle:
* In the Passenger class, instead of relying on a concrete ticket subclass (EconomyTicket or Business Ticket),
it relies on the abstract class Ticket, which can be substituted by the 2 subclasses when used.

```
public class Passenger extends User implements reserveTicket{
    private Ticket ticket;

    public Passenger(String id, String name){
        super(id, name);
    }

    ...
}

abstract class Ticket {
    public Ticket(Train train, Carriage carriage, int seatNumber) {
        this.train = train;
        this.carriage = carriage;
        this.seatNumber = seatNumber;
    }
    ...
    
}

public class BusinessTicket extends Ticket{

    public BusinessTicket(Train train, Carriage carriage, int seatNumber) {
        super(train, carriage, seatNumber);
    }

    ...
}

public class EconomyTicket extends Ticket{

    public BusinessTicket(Train train, Carriage carriage, int seatNumber) {
        super(train, carriage, seatNumber);
    }

    ...
}
```


## Conclusions 

At this lab all 5 principles of SOLID where implemented at least once, as the examples
will go to prove. 


NOTE: since this was the first real project I did in Java, the packages may be all over
the place, as I am still getting the hang of them.