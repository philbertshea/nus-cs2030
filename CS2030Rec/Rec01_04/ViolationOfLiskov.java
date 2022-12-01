package CS2030Rec.Rec01_04;

public class ViolationOfLiskov {
    // Liskov Substitution Principle states that
    // if S is a subtype of T then for any provable property phi(x) for object x of
    // type T,
    // phi(y) must also be a provable property of object y of type S, SUCH that
    // objects of
    // type T can be replaced by objects of type S without changing the desired
    // property of the program.

    // The code violates Liskov Substitution principle.
    /*
     * Yes. The “desirable property” here is that toggleUnderline() toggles the
     * isUnderlined
     * flag, i.e. from false to true, or from true to false.
     * Since URL changes the behavior of toggleUnderline(), this property no longer
     * holds
     * for subclass URL. Places in a program where the super-class (i.e.
     * FormattedText) is
     * used cannot be simply replaced by the sub-class (i.e URL).
     */
}

class FormattedText {
    public String text;
    public boolean isUnderlined;

    public void toggleUnderline() {
        isUnderlined = (!isUnderlined);
    }
}

class URL extends FormattedText {
    public URL() {
        isUnderlined = true;
    }

    @Override
    public void toggleUnderline() {
        return;
    }
}
