package CS2030;

public class Lec4Slide14extra {

    public interface iPayment {
        public void savePaymentDetails();

        public void saveCardDetails();
    }

    public class CashPayment implements iPayment {

        @Override
        public void savePaymentDetails() {
            System.out.println("Cash payment saved.");
        }

        @Override
        public void saveCardDetails() {
            /*
             * Violation of Interface Segregation Principle: Because of the need to
             * implement saveCardDetails for CardPayment class,
             * the CashPayment class is forced to implement an unnecessary, redundant
             * saveCardDetails method. This is because both
             * classes implement the same interface. Solution: Segregate the interfaces.
             */
            System.out.println("Error: No card details for cash payment.");
        }
    }

    public class CardPayment implements iPayment {

        @Override
        public void savePaymentDetails() {
            System.out.println("Card payment saved.");
        }

        @Override
        public void saveCardDetails() {
            System.out.println("Card details for card payment saved.");
        }

    }

    // One possible solution for the code to agree with Interface Segregation
    // Principle is:
    // to implement a separate iOnlinePayment interface which *extends from*
    // iPayment
    public interface iPayment2 {
        public void savePaymentDetails();
    }

    public interface iOnlinePayment extends iPayment2 {
        public void saveCardDetails();
    }

    public class CashPayment2 implements iPayment2 {

        @Override
        public void savePaymentDetails() {
            System.out.println("Cash Payment saved");
        }

    }

    public class CardPayment2 implements iOnlinePayment {

        @Override
        public void savePaymentDetails() {
            System.out.println("Card payment saved");
        }

        @Override
        public void saveCardDetails() {
            System.out.println("Card details saved");
        }

    }

    public class Procurement {
        public void calcPayment(iPayment2 Pay) {
            Pay.savePaymentDetails();
        }

        public void calcCardPayment(iOnlinePayment Pay) {
            Pay.saveCardDetails();
        }
    }

    // Another possible solution is to create two different interfaces, one focussed
    // on payment details, another on card details.

    public interface PaymentSaver {
        public void savePaymentDetails();
    }

    public interface CardSaver {
        public void saveCardDetails();
    }

    public class CashPayment3 implements PaymentSaver {

        @Override
        public void savePaymentDetails() {
            System.out.println("Cash payment saved");
        }

    }

    public class CardPayment3 implements PaymentSaver, CardSaver {

        @Override
        public void saveCardDetails() {
            System.out.println("Card payment saved");
        }

        @Override
        public void savePaymentDetails() {
            System.out.println("Card details saved");
        }

    }

    // Main driver
    // Note that I need an instance of Lec4Slide14extra to execute the required
    // functions, because unlike the video,
    // I put everything into one file. The proper method is to separate each class
    // into files where the filename is the
    // same as the class/interface name. And note that main is a *STATIC* function,
    // which cannot directly talk with
    // non-static functions without using an instance of Lec4Slide14extra.
    public static void main(String[] args) {
        Lec4Slide14extra obj = new Lec4Slide14extra();

        System.out.println("Process Cash Payment, followed by Card Payment");
        CashPayment2 PayCash = obj.new CashPayment2();
        Procurement Procurement = obj.new Procurement();
        Procurement.calcPayment(PayCash);

        iOnlinePayment PayCard = obj.new CardPayment2();
        Procurement.calcPayment(PayCard);
        Procurement.calcCardPayment(PayCard);
    }

}
