import java.util.List;

public class WildcardError {

    void foo(List<?> i) {
    	 fooHelper(i);
    }


    // Helper method created so that the wildcard can be captured
    // through type inference.
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }
}
