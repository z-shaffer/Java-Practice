/**
 * TestPrelab1.java
 */
 
import static org.junit.Assert.fail;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Constructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Check for the existance and type of each field.
 * Check for the existance and return type of 
 *      accessors for each field.
 * Check for the existance and parameter type of
 *      mutators for each field.
 * Check for the existance of a noarg constructor.
 * Check for the existance of a constructor which
 *      sets all fields using parameters.
 * Check for other listed methods.
 *      
 * DOES NOT CHECK ANY FUNCTIONALITY.
 * You must use fully qualified class names
 * such as java.util.Scanner
 * 
 * @author Joel Swanson
 * @version 02.09.2014
 */

@SuppressWarnings("unchecked") 
public class TestPart1A
{
    private String className = "Plotter";
    private String[] fields = new String[]{};
    
    private boolean fail = false;
    private int grade = 0;
    private Class testClass;
    private String fb = "";
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {      
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Test Scene class from activity 4.
     */
    @Test
    public void testPrelab()
    {
        testSilent();
    }    
    
    /**
     * Run previous tests; TestHouseActivity2.
     */
    public void testPrevious()
    {
    }      
    
        
    /**
     * Run all tests.
     */
    public void testSilent()
    {        
        checkCircle();
        checkSquare();
        checkPlotter();
    }    
    
    /**
     * Test fields, accessors, and mutators.
     */
    public void checkPlotter()
    {
        className = "Plotter";
        printHeader("Plotter");

        fail = false;

        checkClass();        
        checkConstructor();
        checkMain();
        checkMethod("drawXAxis", "void");
        checkMethod("drawOneXTick", "void", "int");
        checkMethod("drawAllXTicks", "void");
        checkMethod("drawYAxis", "void");
        checkMethod("drawOneYTick", "void", "int");
        checkMethod("drawAllYTicks", "void");        
        checkMethod("drawAxes", "void");        
        checkMethod("plotPoints", "void", "java.util.Scanner");        
        checkMethod("plotPointsProper", "void", "java.util.Scanner");        
        //checkMethod("testMethod", "boolean", "int", "int", "double");        
        
        if (fail)
        {
            fb += "Fail in TestPrelab1.\n";
            fb += "Errors exist. See terminal for details.";
            fail(fb);
        }
    }
    
    
    /**
     * Print a standard header. Useful if testing multiple
     * classes for proper declaration.
     * 
     * @param name The name of the class that is currently
     * being tested.
     */
    public void printHeader(String name)
    {
        System.out.println("\nTesting " + name);
        System.out.println("Items marked with an X" 
            + " below this line are errors.");
        System.out.println("---------------------" 
            + "---------------------------");        
    }
    /** 
     * Test the circle class to see if constructor was
     * created properly.
     */
    public void checkCircle()
    {
        //Have to change the name of the test class if testing more
        //than one class in the same file.
        className = "Circle";
        printHeader(className);
        fail = false;
        
        checkClass();
        checkConstructor("int", "int");

        if (fail)
        {
            fb += "Fail in TestPrelab1.\n";
            fb += "Errors exist. See terminal for details.";
            fail(fb);
        }       
    }

    /** 
     * Test the circle class to see if constructor was
     * created properly.
     */
    public void checkSquare()
    {
        //Have to change the name of the test class if testing more
        //than one class in the same file.
        className = "Square";
        printHeader(className);
        fail = false;
        
        //Run the checks.
        checkClass();
        checkConstructor("int", "int");
        
        if (fail)
        {
            fb += "Fail in TestPrelab1.\n";
            fb += "Errors exist. See terminal for details.";
            fail(fb);
        }
    }

    
    /**
     * Check that the class is properly named.
     */    
    private void checkClass()
    {
        try
        {
            testClass = Class.forName(className);
            System.out.println("  : " + className + " class exists.");
        }
        catch (Exception e)
        {
            System.out.println("X : " + className + " class does not exist.");
            System.out.println("No further checks are possible" 
                + " without a " + className + " class to check.");
            fb += "Fail in TestPrelab1.\n";
            fb += className + " class does not exist.\n";
            fb += "You must have a class in your project named "
                + className + ".\n";            
            fb += "Make sure it is spelled properly.  Case counts.\n";
            fail(fb);
        }        
    }   
    
    /**
     * Check to see if a properly declared main exists.
     * public, static, and void with String[] parameter.
     */
    public void checkMain()
    {
        try
        {
            Method method = testClass.getMethod("main", 
                new Class[]{String[].class});            
            
            if (method.getReturnType() != void.class)
            {
                System.out.println("X : \"main\" should " 
                    + "have a return type of void." 
                    + " Make the return type is void.");
                fail = true;
            }      
            else if (!Modifier.isPublic(method.getModifiers()))
            {
                System.out.println("X : \"main\" must be declared public.");
                fail = true;
            }
            else if (!Modifier.isStatic(method.getModifiers()))
            {
                System.out.println("X : \"main\" must be declared static.");
                fail = true;
            }
            else
            {                    
                System.out.println("  : \"main\" declared correctly.");
            }
        }
        catch (Exception e)
        {
            System.out.println("X : \"main\" can't be" 
                + " found. Check spelling and parameter (String[] args).");
            fail = true;
        }        
        
    }

    /**
     * Check that all fields exist as named.
     * Check that all fields are of the correct type.
     * Check that all fields are private.
     */
    private void checkFields()
    {
        for (int i = 0; i < fields.length; i += 2)
        {
            checkOneField(fields[i], fields[i + 1]);
        }
    }

    /**
     * Check that all the accessors are correct.
     */
    private void checkAccessors()
    {         
        for (int i = 0; i < fields.length; i += 2)
        {            
            String methodName = "get" + fields[i].substring(0, 1).toUpperCase() 
                + fields[i].substring(1);
            checkOneAccessor(methodName, fields[i + 1]);
        }        
    }    

    /**
     * Check that all the mutators are correct.
     */
    private void checkMutators()
    {
        for (int i = 0; i < fields.length; i += 2)
        {            
            String methodName = "set" + fields[i].substring(0, 1).toUpperCase() 
                + fields[i].substring(1);
            checkOneMutator(methodName, fields[i + 1]);
        } 
    }
    
    /**
     * Tests for a constructor with a given number and
     * type of parameters.
     * 
     * @param parameters A variable list of parameter types
     * as Strings.  Put any types and this method will
     * attempt to find a constructor with those types in
     * the specified order.
     */
    private void checkConstructor(String... parameters)
    {           
        Class[] typeArray = getTypeClassArray(parameters);
        
        try
        {            
            Constructor constructor = testClass.getConstructor(typeArray);
            if (parameters.length == 0)
            {                
                System.out.print("  : No-arg constructor found.\n");
            }
            else
            {
                System.out.print("  : Constructor found with parameter");
                System.out.println(" list: " + getParameterList(parameters));
            }
        }
        catch (Exception e)
        {
            System.out.print("X : Constructor NOT found with" 
                + " parameter list : ");
            System.out.println(getParameterList(parameters));
            fail = true;
        }        
    }
    
    /**
     * Tests for a constructor with a given number and
     * type of parameters.
     * 
     * @param name Search for a method with this name.
     * @param expectedReturn Expected type of the return.
     * @param parameters A variable list of parameter types
     * as Strings.  Put any types and this method will
     * attempt to find a constructor with those types in
     * the specified order.
     */
    private void checkMethod(String name, String expectedReturn, 
        String... parameters)
    {           
        Class[] typeArray = getTypeClassArray(parameters);
        
        try
        {                       
            Method method = testClass.getMethod(name, typeArray);            
            
            if (getTypeClass(expectedReturn) != method.getReturnType())
            {
                System.out.println("X : Method named \"" 
                    + name + "\" should have a return type of " 
                    + expectedReturn + "." 
                    + " Make the return type is correct.");
                fail = true;
            }      
            else
            {                    
                System.out.println("  : Method named \"" + name 
                    + "\" declared correctly.");                    
            }
        }
        catch (Exception e)
        {
            System.out.println("X : Method "  + name + "("
                + getParameterList(parameters) + ") can't be" 
                + " found. Check spelling and parameter order.");
            fail = true;
        }        
    }
    
    /**
     * Return the parameters as a comma separated list
     * or return none.
     * 
     * @param parameters List of parameter types as strings.
     * 
     * @return Returns all parameters as a single comma
     * separated list.
     */
    private String getParameterList(String[] parameters)
    {
        String listString = "";
        if (parameters.length != 0)
        {
            //List all strings except the last one followed
            //by a comma.
            int i = 0;
            for (i = 0; i < parameters.length - 1; i++)
            {
                listString += parameters[i] + ", ";
            }
            //List the last one without a comma.
            listString += parameters[i];
        }        
        return listString;
    }
    
    /**
     * Turn a string array of types into an array of Class types.
     * 
     * @param parameters A list of parameter types as Strings.
     * 
     * @return Returns an array of Class objects based on the
     * parameter list which are String objects.
     */
    private Class[] getTypeClassArray(String [] parameters)
    {
        Class[] classes = null;
        
        if (parameters.length == 0)
        {
            //no-arg constructor
            classes = new Class[0];
        }
        else
        {
            classes = new Class[parameters.length];
            for (int i = 0; i < classes.length; i++)
            {
                classes[i] = getTypeClass(parameters[i]);
                if (classes[i] == null)
                {
                    //Need to do more testing here.
                    classes[i] = void.class;
                }
            }
        }
        return classes;        
    } 
    
    /**
     * Test Chalk class for a specific field name and correct type.
     * 
     * @param name Make sure Chalk has a field of this name.
     * @param expectedType Make sure the name field has this type.
     */
    private void checkOneField(String name, String expectedType)
    {
        try
        {
            Field field = testClass.getDeclaredField(name);

            if (field.getType().equals(getTypeClass(expectedType)))
            {
                System.out.println("  : Field named \"" + name + "\"" 
                    + " declared correctly.");                
            }
            else
            {
                System.out.println("X : Field named \"" + name 
                    + "\" is the wrong type.");
                fail = true;
            }

            if (!Modifier.isPrivate(field.getModifiers()))
            {
                System.out.println("X : Field named \"" + name + "\"" 
                    + " is not private.");
                fail = true;
            }
        }
        catch (Exception e)
        {
            System.out.println("X : Field named \"" + name 
                + "\" does not exist.");
            fail = true;
        }
    }  

    /**
     * Test the Chalk class for a specific accessor for existance and type.
     * @param name The expected name of the accessor.
     * @param expectedType The expected return type of the accessor
     * of this type.
     */
    private void checkOneAccessor(String name, String expectedType)
    {
        Method method = null;

        try
        {
            method = testClass.getMethod(name, new Class[]{});

            if (method.getReturnType().equals(getTypeClass(expectedType)))
            {
                System.out.println("  : Accessor named \"" 
                    + name + "\" declared correctly.");                
            }
            else
            {
                System.out.println("X : Accessor named \"" 
                    + name + "\" has the wrong return type.");
                fail = true;
            }
        }
        catch (Exception e)
        {
            boolean found = false;
            fail = true;
            Method[] methods = testClass.getDeclaredMethods();
            Method m = null;
            //Search to see if there is a method with that name.
            //If one is found it means they have a parameter in the accessor.
            int i = 0;
            while (!found && i < methods.length)
            {
                m = methods[i++];
                if (m.getName().equals(name))
                {
                    found = true;
                }                
            }

            //We found the correct name and it is stored in m.  
            //Determine if it has incorrect parameters or is private.
            if (found)
            {
                if (Modifier.isPrivate(m.getModifiers()))
                {
                    System.out.println("X : Accessor named \"" + name + "\"" 
                        + " is private. Make it public.");
                    fail = true;
                }
                else
                {
                    //Must have included a parameter.
                    System.out.println("X : Accessor named \"" 
                        + name + "\" should not have any parameters.");
                    fail = true;                    
                }
            }
            else
            {
                System.out.println("X : Accessor named \"" 
                    + name + "\" does not exist. Check spelling. " 
                    + "Case matters.");                                
            }
        }  
    }

    /**
     * Test the Chalk class for a specific accessor for existance and type.
     * @param name The expected name of the accessor.
     * @param expectedType The expected parameter type of the accessor
     * of this type.
     */
    private void checkOneMutator(String name, String expectedType)
    {
        try
        {            
            Class parameterType = getTypeClass(expectedType);
            
            if (parameterType == null)            
            {
                System.out.println("X : Mutator named \"" + name 
                    + "\" can't determine parameter type. " 
                    + " Make sure classes used for types are in the project.");
                fail = true;
            }
            else
            {
                Method method = testClass.getMethod(name
                    , new Class[]{parameterType});            
                
                if (method.getReturnType() != void.class)
                {
                    System.out.println("X : Mutator named \"" 
                        + name + "\" should have a return type of void." 
                        + " Make the return type void.");
                    fail = true;
                }      
                else
                {                    
                    System.out.println("  : Mutator named \"" + name 
                        + "\" declared correctly.");                    
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("X : Mutator named \"" 
                + name + "\" does not exist.  Check spelling. Case Matters.");
            fail = true;
        }        
    }  
    
    /**
     * Turn a string class description into a class type.
     * 
     * @param expectedType The string representation of a type.
     * For example "int", "double", "java.lang.String", etc...
     * 
     * @return Return the class definition of a string representation
     * of a type.
     */
    private Class getTypeClass(String expectedType)
    {
        switch (expectedType)
        {
            case "int":
                return int.class;
                
            case "double":
                return double.class;
                
            case "short":
                return short.class;
            
            case "long":
                return long.class;
                
            case "boolean":
                return boolean.class;
                
            case "float":
                return float.class;
                
            case "char":
                return char.class;
                
            case "byte":
                return byte.class;
            
            case "String":
                return String.class;
            
            case "void":
                return void.class;
                
            default:
                try
                {
                    return Class.forName(expectedType);
                }
                catch (Exception e)
                {
                    return null;
                }
        }
    }
    
}


