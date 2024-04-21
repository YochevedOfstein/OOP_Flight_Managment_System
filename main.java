public class main {
    public static void main(String[] args) {

        AirlineSystem program = new AirlineSystem();

        Airline ElAl = program.createAirline("ElAl");
        Airline israir = program.createAirline("israir");
        Airline arkia = program.createAirline("arkia");

        Passenger passenger1 = new Passenger("Yosef Golan", 1);
        Passenger passenger2 = new Passenger("Chen Dan", 2);
        Passenger passenger3 = new Passenger("Mor Lin", 3);

        AirlineWorker worker1 = new AirlineWorker("Guy1", 11, ElAl);
        AirlineWorker worker2 = new AirlineWorker("Guy2", 22, arkia);
        AirlineWorker worker3 = new AirlineWorker("Guy3", 33, israir);

        program.addSubAirline(israir, arkia);

        program.addWorkers(ElAl, worker1);
        program.addWorkers(israir, worker2);
        program.addWorkers(arkia, worker3);

        program.addSubAirline(ElAl,israir);
        program.addSubAirline(ElAl,arkia);

        Flight A5007 = program.createFlight("A5007", 437, arkia, "Israel", "Greece", 2, 12);
        Flight L2308 = program.createFlight("L2308", 622, israir, "Israel", "London", 5.5, 3);
        Flight J0094 = program.createFlight("J0094", 999, ElAl, "Thailand", "Israel", 8, 8);

        program.addFlight(A5007.getAirline(), A5007);
        program.addFlight(L2308.getAirline(), L2308);
        program.addFlight(J0094.getAirline(), J0094);

        program.addPassengerToFlight(A5007, passenger1);
        program.addPassengerToFlight(L2308, passenger2);
        program.addPassengerToFlight(J0094, passenger3);
        program.addPassengerToFlight(L2308, passenger1);
        program.addPassengerToFlight(J0094, passenger1);

        program.searchNewFlight();

        program.getNumberOfFlights(ElAl);

        program.getNumberOfSoldTickets(israir);

        program.cancelFlight(L2308);

        program.getNumberOfFlights(ElAl);

        program.getNumberOfSoldTickets(israir);

        program.announceSale(A5007, 15);

        program.changeDepartureTime(L2308, 4);

        Flight Y2245 = program.createFlight("Y2245", 532, israir, "Rome", "Israel", 4.5, 8);

        program.addPassengerToFlight(Y2245, passenger2);

        program.removePassengerFromFlight(J0094, passenger3);

        Airline Delta = program.createAirline("Delta");

        program.changeWorkPlace(Delta, worker3);

        program.becomeAirlineObserver(passenger1, Delta);

        program.announceNewDeal(ElAl, 10);

        program.newSafetyPolicy(Delta);

        program.happyHolidayMessage(israir);

        program.printNotifications(passenger1);

        program.getAirlineData(ElAl);
    }
}