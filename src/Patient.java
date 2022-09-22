import java.time.LocalDate;

public class Patient
{
   private static final int SURNAME     = 1;
   private static final int FIRSTNAME   = 2;
   private static final int DATEOFBIRTH = 3;

   private int       id;
   private String    surname;
   private String    firstName;
   private LocalDate dateOfBirth;

   ////////////////////////////////////////////////////////////////////////////////
   ////////////////////////////////////////////////////////////////////////////////
   public String getSurname()
   {
      return surname;
   }

   ////////////////////////////////////////////////////////////////////////////////
   ////////////////////////////////////////////////////////////////////////////////
   public String getFirstName()
   {
      return firstName;
   }
   public void setFirstName(String firstName)
   {
     this.firstName = firstName;
   }
   public void setLastName(String lastName)
   {
      this.surname = lastName;
   }
   public void setDateofbirth(String dateofbirth)
   {
      this.dateOfBirth = dateOfBirth;
   }
   ////////////////////////////////////////////////////////////////////////////////
   // Constructor
   ////////////////////////////////////////////////////////////////////////////////
   Patient( int id, String surname, String firstName, LocalDate dateOfBirth )
   {
      this.id          = id;
      this.surname     = surname;
      this.firstName   = firstName;
      this.dateOfBirth = dateOfBirth;
   }

   ////////////////////////////////////////////////////////////////////////////////
   // Display patient data.
   ////////////////////////////////////////////////////////////////////////////////
   public void viewData()
   {
      System.out.format( "===== Patient id=%d ==============================\n", id );
      System.out.format( "%-17s %s\n", "Surname:", surname );
      System.out.format( "%-17s %s\n", "firstName:", firstName );
      System.out.format( "%-17s %s\n", "Date of birth:", dateOfBirth );
   }

   ////////////////////////////////////////////////////////////////////////////////
   // Shorthand for a Patient's full name
   ////////////////////////////////////////////////////////////////////////////////
   public String fullName()
   {
      return String.format( "%s %s [%s]", firstName, surname, dateOfBirth.toString() );
   }

}
