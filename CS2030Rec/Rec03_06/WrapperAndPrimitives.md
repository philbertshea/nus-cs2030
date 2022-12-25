**A summary of Wrappers and Primitives and their behaviour**
Wrappers and Primitives OF THE SAME SET (Integer <--> int, Double <--> double) are generally interchangeable.
This is because of the presence of *Autoboxing* and *Unboxing*

**Autoboxing** : Conversion of a primitive instance to a Wrapper instance OF EQUIVALENCE.
Integer a = 10; <--
int b = 15;
Integer c = b; <--

**Unboxing**: Conversion of a wrapper instance to a primitive instance OF EQUIVALENCE.
Integer d = 20;
int f = d; <--

**Besides Declarations, Autoboxing and Unboxing also works in less direct circumstances**


**Casting Rules between double, Double, int, Integer**

List<Integer>.add(Integer) OK
List<Integer>.add(int) OK - Autoboxing
List<Integer>.add(double) ERROR - type mismatch
List<Integer>.add(Double) ERROR - type mismatch
List<Integer>.add((int) double) OK             Can Cast double to int , then add to list via autoboxing
List<Integer>.add((int) Double)     ERROR - Cannot Cast Double to int
List<Integer>.add((Integer) double) ERROR - Cannot Cast double to Integer
List<Integer>.add((Integer) Double) ERROR - Cannot Cast Double to Integer


List<Double>.add(Double) OK
List<Double>.add(double) OK - Autoboxing
List<Double>.add(int)     ERROR - type mismatch
List<Double>.add(Integer) ERROR - type mismatch
List<Double>.add((double) int)                 Can Cast int to double, then add to list via autoboxing
List<Double>.add((double) Integer)             Can Cast Integer to double, then add to list via autoboxing
List<Double>.add((Double) int)      ERROR - Cannot Cast int to Double
List<Double>.add((Double) Integer)  ERROR - Cannot Cast Integer to Double

double[] add double           OK
double[] add Double           OK - Unboxing
double[] add int              OK
double[] add Integer          OK
double[] add (double) int     OK       - Can Cast int to double, then add to list via autoboxing
double[] add (double) Integer OK       - Can Cast Integer to double, then add to list via autoboxing
double[] add (Double) int     ERROR - Cannot Cast int to Double
double[] add (Double) Integer ERROR - Cannot Cast Integer to Double

int[] add int                 OK
int[] add Integer             OK - Unboxing
int[] add double              ERROR - type mismatch
int[] add Double              ERROR - type mismatch
int[] add (int) double        OK       - Can Cast int to double
int[] add (Integer) double    ERROR - Cannot Cast Integer to double
int[] add (int) Double        ERROR - Cannot Cast int to Double
int[] add (Integer) Double    ERROR - Cannot Cast Integer to Double

**Printing Rules for List<Integer>, List<Double>, int[], double[]**

List<Integer> print Integer   OK
List<Integer> print int       OK
List<Integer> print double    OK
List<Integer> print Double    ERROR

List<Double> print Double     OK
List<Double> print double     OK
List<Double> print int        ERROR
List<Double> print Integer    ERROR

double[] print double         OK
double[] print Double         OK
double[] print int            ERROR
double[] print Integer        ERROR

int[] print int               OK
int[] print Integer           OK
int[] print double            OK
int[] print Double            ERROR