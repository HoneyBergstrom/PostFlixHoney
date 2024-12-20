import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class AdminDecorator extends Admin  {
        protected Admin decoratedAdmin;
        protected String newContent;

        public AdminDecorator(Admin admin) {
            super(admin.getName(), admin.getPassword());
            this.decoratedAdmin = admin;
        }


        public void showNewsContent(String newContent) {
            showNewsContent("Banana");
            System.out.println("New promotion added: " + newContent);
        }

        public void displayPromotions() {
            System.out.println("\n--- Current new content ---" + newContent);
        }

@Override
public void updateContent(Scanner scanner) {
    decoratedAdmin.updateContent(scanner);
}
    }
