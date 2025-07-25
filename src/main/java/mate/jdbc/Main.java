package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector =
            Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Mazda");
        manufacturer.setCountry("Japan");
        System.out.println("Создаем мануфактурера: " + manufacturerService.create(manufacturer));

        Manufacturer getManufacturer = manufacturerService.get(1L);
        System.out.println("Еще раз получаем по ID: " + getManufacturer);

        Manufacturer manufacturerTwo = new Manufacturer();
        manufacturerTwo.setName("Mercedes");
        manufacturerTwo.setCountry("Germany");
        System.out.println("Создаем мануфактурера: " + manufacturerService.create(manufacturerTwo));

        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Ivan Ivanovich");
        driver.setLicenseNumber("322464262AA");
        System.out.println("Создаем водителя: " + driverService.create(driver));

        Driver getDriver = driverService.get(1L);
        System.out.println("Еще раз получаем по ID: " + getDriver);

        Driver driverUpdate = new Driver();
        driverUpdate.setId(1L);
        driverUpdate.setName("Ivan Ivanovich");
        driverUpdate.setLicenseNumber("888844447777");
        System.out.println("Обновим водителя: " + driverService.update(driverUpdate));

        Driver driverTwo = new Driver();
        driverTwo.setName("Dubin Oleksey");
        driverTwo.setLicenseNumber("444333322222");
        System.out.println("Создаем водителя: " + driverService.create(driverTwo));

        System.out.println("Вывести всех водителей: ");
        driverService.getAll().forEach(System.out::println);

        driverService.delete(1L);

        System.out.println("Вывести всех водителей: ");
        driverService.getAll().forEach(System.out::println);
    }
}
