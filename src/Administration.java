import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

///////////////////////////////////////////////////////////////////////////
// class Administration represents the core of the application by showing
// the main menu, from where all other functionality is accessible, either
// directly or via sub-menus.
//
// An Administration instance needs a User as input, which is passed via the
// constructor to the data member 'currentUser'.
// The patient data is available via the data member currentPatient.
/////////////////////////////////////////////////////////////////
public class Administration
{
   private static final int STOP = 0;
   private static final int VIEW = 1;

   private Patient currentPatient;            // The currently selected patient
   private User    currentUser;               // the current user of the program.

   private ArrayList<Patient> patientArrayList;

   public ArrayList<Patient> getPatientArrayList() {
      return patientArrayList;
   }

   public void addPatient(Patient patient) {
   }
   public void editPatient(Patient patient) {
      Scanner scanner = new Scanner(System.in);
      var option = 0;
      System.out.println("Edit patient's data");
      System.out.format("%d:  STOP\n", STOP);
      System.out.format("%d:  first name\n", 1);
      System.out.format("%d:  last name\n", 2);
      System.out.format("%d:  date of birth\n", 3);
      option = scanner.nextInt();
      switch (option){
         case STOP:
            return;
         case 1:
            System.out.println("first name:");
            String s = scanner.nextLine();
            patient.setFirstName(s);
            break;
         case 2:
            System.out.println("last name");
            String lastname = scanner.nextLine();
            patient.setLastName(lastname);
            break;
         case 3:
            System.out.println("date of birth");
            System.out.println("year");
            Integer year = scanner.nextInt();
            System.out.println("month");
            Integer month = scanner.nextInt();
            System.out.println("day");
            Integer day = scanner.nextInt();
            patient.setDateofbirth(String.valueOf(LocalDate.of(year, month, day)));
            break;
      }
   }

   /////////////////////////////////////////////////////////////////
   // Constructor
   /////////////////////////////////////////////////////////////////
   Administration( User user )
   {
      currentUser    = user;
      currentPatient = new Patient( 1, "Van Puffelen", "Pierre", LocalDate.of( 2000, 2, 29 ) );
      System.out.format( "Current user: [%d] %s\n", user.getUserID(), user.getUserName() );

      ArrayList<Patient> patientList = new ArrayList<Patient>();
      this.patientArrayList = patientList;

      patientList.add(new Patient(1,"Van Puffelen","Pierre",LocalDate.of(2000, 2, 29)));
      patientList.add(new Patient(2,"Bakker","Diederik",LocalDate.of(1996, 8, 2)));
      patientList.add(new Patient(3,"Williams","Libra",LocalDate.of(2004, 9, 1)));
      patientList.add(new Patient(4,"Rutte", "Mark",LocalDate.of(1968,6,14)));
      patientList.add(new Patient(5,"Tompsen","Adriaan",LocalDate.of(1986, 4,26)));
   }

   /////////////////////////////////////////////////////////////////
   /////////////////////////////////////////////////////////////////
   void menu()
   {
      var scanner = new Scanner( System.in );  // User input via this scanner.
      var currentPatientID = 0;
      boolean nextCycle = true;
      Patient currentPatient = getPatientArrayList().get(currentPatientID);
      while (nextCycle)
      {
         System.out.format( "%s\n", "=".repeat( 80 ) );

         ////////////////////////a
         // Print menu on screen
         ////////////////////////
         System.out.format( "%d:  STOP\n", STOP );
         System.out.format( "%d:  View patient data\n", VIEW );
         System.out.printf( "%d:  Edit patient data\n", 2);

         ////////////////////////

         System.out.print( "enter #choice: " );
         int choice = scanner.nextInt();
         switch (choice) {
            case STOP:
               nextCycle = false;
               break;
            case VIEW:
               System.out.println("\033[H\033[2J");
               System.out.flush();
               currentPatientID++;
               currentUser.viewPatientData(getPatientArrayList().get(currentPatientID));
               break;
            case 2:
               editPatient(getPatientArrayList().get(currentPatientID));
               break;
            default:
               System.out.println("Please enter a *valid* digit");
               break;
         }
      }
   }
}
