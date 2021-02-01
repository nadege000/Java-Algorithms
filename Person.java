public class Person {
    /*************************/
    /* Instance variables	 */
    /*************************/
    protected String firstName;                                                                            // the given name for a person
    protected int age;                                                                                     // the persons age in years

    /*************************/
    /* Constant declarations */
    /*************************/
    private final int MIN_AGE = 1;                                                                         // Minimum valid age for a person
    private final int MAX_AGE = 110;                                                                       // Maximum valid age for a person
    private final int NO_AGE_VALUE = -1;                                                                   // Indicates the objects contains no age value

    /*************************/
    /* Constructor methods	 */
    /*************************/
    public Person(String name) {
        String number_digit = "\\d+";                                                                      // checks if string consists only of numbers
        if (2 <= name.length() && !name.matches(number_digit)) {
            for (int i = 0; i < name.length(); ++i) {                                                      // Valid strings with 2 or more characters in length
                char digit = name.charAt(i);

                if (Character.isDigit(digit)) {                                                            // if string is invalid
                    firstName = null;                                                                      // null is assigned as the firstName value
                    break;
                } else {
                    firstName = name;
                }
            }
        } else {
            firstName = null;
        }
        age = NO_AGE_VALUE;                                                                                // instance variable is set to a no value
    }

    /*************************/
    /* Update methods	 */
    /*************************/
    public void setAge(int p_age) {
        if ((MIN_AGE <= p_age && p_age <= MAX_AGE) && firstName != null) {
            age = p_age;                                                                                   // reflects a valid value between min and max
        } else { age = NO_AGE_VALUE; }                                                                     // the argument contains an invalid value
    }

    public void setName(String p_name) {
        if (firstName.equals(p_name)) {                                                                    // reflects a valid name
            firstName = p_name;
        }
    }

    public void bumpAge() {
        if (age != NO_AGE_VALUE && firstName != null) {                                                    // age contains no value
            age += 1;                                                                                      // and firstName instance variable is null
        }
    }

    /*************************/
    /* Accessor Methods	 */
    /*************************/
    public String getFirstName() {
        return firstName;                                                                                  // returns the string of an object
    }

    public int getAge() {
        return age;                                                                                        // returns the age value of an object
    }

    public String toString() {                                  // returns string of name and age of an object
        return ("First Name: " + firstName + " Age: " + age);
    }

    public static void main(String[] args) {
        /* Test Scenario #1 */                                                                             // object contains string and age
        Person myObj = new Person("Robert");
        Person p1 = new Person("A");

        System.out.println("firstName: " + myObj.getFirstName() + " age: " + myObj.getAge() + "\n");

        /* Test Scenario #2 */
        myObj.setAge(31);                                                                                  // object contains the expected value for age
        System.out.println("firstName: " + myObj.getFirstName() + " age: " + myObj.getAge() + "\n");

        /* Test Scenario #3 */
        myObj.bumpAge();                                                                                   // object contains the incremented value in age
        System.out.println("firstName: " + myObj.getFirstName() + " age: " + myObj.getAge() + "\n");

        /* Test Scenario #4 */
        myObj.setAge(111);                                                                                 // object contains non-null, valid age value to invalid value
        System.out.println("firstName: " + myObj.getFirstName() + " age: " + myObj.getAge() + "\n");

        /* Test Scenario #5 */
        myObj.bumpAge();                                                                                   // object contains a no value
        System.out.println("firstName: " + myObj.getFirstName() + " age: " + myObj.getAge() + "\n");

        /* Test Scenario #6 */
        System.out.println("firstName: " + p1.getFirstName() + " age: " + p1.getAge() + "\n");             // object has a null string, no value in age

        /* Test Scenario #7 */
        p1.bumpAge();                                                                                      // attempt to increment the value in object that contains a null
        System.out.println("firstName: " + p1.getFirstName() + " age: " + p1.getAge() + "\n");
    }
}