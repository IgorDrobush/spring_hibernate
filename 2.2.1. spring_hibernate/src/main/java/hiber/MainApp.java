package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {

   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("ВАЗ", 2108);
      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      Car car2 = new Car("ГАЗ", 3110);
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
      Car car3 = new Car("ГАЗ", 3302);
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
      Car car4 = new Car("ВАЗ", 2115);
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      User user = userService.findByCarModelAndCarSeries("ГАЗ", 3302);
      System.out.println();
      System.out.println(user);

      context.close();
   }
}
