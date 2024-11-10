package Employee;

import java.text.NumberFormat;
import java.util.Locale;

public class Employee {
   private static int nextId = 1;
   private final int id;
   private String name;
   private Position position;


   public Employee(String name, Position position) {
      this.id = nextId++;
      this.name = name;
      this.position = position;


   }

   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Position getPosition() {
      return position;
   }

   public void toPromote(Position newPosition){
      this.position = newPosition;
   }

   @Override
   public String toString() {
      return "O funcionário " + this.getName() + " com o cargo de " + this.getPosition().getDescription() + " tem " + this.getPosition().getFormatSalary() + " de salário.";
   }
}
