package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer("Mazda", "Japan");
        manufacturerService.create(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        Driver driver = new Driver(null, "Gordon", "F13232221328");
        Driver driver1 = new Driver(null, "Max", "D6663232299");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driver = driverService.create(driver);
        driver1 = driverService.create(driver1);
        driverService.getAll().forEach(System.out::println);
        System.out.println("---------------------------------------");
        Driver driver2 = new Driver(driver.getId(), "Shlepa", "F13232221328");
        driverService.update(driver2);
        driverService.getAll().forEach(System.out::println);
        System.out.println("---------------------------------------");
        driverService.delete(driver1.getId());
        driverService.getAll().forEach(System.out::println);



    }
}
