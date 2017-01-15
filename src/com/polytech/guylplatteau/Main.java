package com.polytech.guylplatteau;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Service> services = new ArrayList<>();
        Date departureDate = new Date();
        Service service = new Service("Lyon", "Paris", 900d, departureDate);
        services.add(service);

        Company airFrance = new Company("Air France", services, 7);
        //airFrance.run();

        List<Company> whitelist = new ArrayList<>();
        whitelist.add(airFrance);

        Consumer rodrigo = new Consumer(whitelist, null, "Lyon", "Paris", 500, departureDate, whitelist);
        //rodrigo.run();
        rodrigo.negociate();
    }
}
