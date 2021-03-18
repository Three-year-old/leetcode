package String;

public class CheckIfWordIsValidAfterSubstitutions {

    public boolean isValid(String s) {
        if (s.length() < 2) return false;
        if (s.equals("abc")) return true;
        String rep = s.replace("abc", "");
        if (rep.equals(s)) return false;
        if (rep.equals("")) return true;
        return isValid(rep);
    }
}
