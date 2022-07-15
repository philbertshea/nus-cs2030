// Refer to Lac7Slide5.java

// Maybe is a generic class taking in type T
package CS2030;

public class Lec7Maybe<T> { // Only need <T> when implementing class.
    private final T thing;

    private Lec7Maybe() { // No need <T> when implementing constructor.
        this.thing = null;
    }

    public Lec7Maybe(T thing) {
        this.thing = thing;
    }

    public static <T> Lec7Maybe<T> empty() { // Need both static<T> (only for static methods) and Maybe<T> (when the return
                                         // type is the class itself, or has a parameterised type)
        return new Lec7Maybe<T>(); // But need <T> when creating new instance via constructor.
    }

    public void ifPresent(Actionable<T> action) {
        if (thing != null) {
            action.doit(thing);
        }
    }

    // A Maybe<T> instance has a function map, which accepts a Mappable<T,R> mapper that contains a CONVERTER function "apply"
    // R apply (T t) takes in a "thing" of type T, and returns a "thing" of type R.  [mapper.apply(thing)]
    // Then, the map function returns a new Maybe<R> instance, of type R with "thing" of type R. 

    public <R> Lec7Maybe<R> map(Mappable<T,R> mapper) {
        if (thing == null) {
            return Lec7Maybe.empty();
        } else {
            return new Lec7Maybe<R>(mapper.apply(thing));
        }
    }

    @Override
    public String toString() {
        return "Maybe[" + (thing == null ? "empty" : thing + " of type " + thing.getClass().getSimpleName()) + "] ";
    }
}
