package a7315.jd.a7315.Contracts;

/**
 * Created by Jesse on 1/23/2018.
 */

public interface ContractLogin {
    interface View {

    }

    interface Presenter {
        boolean login(String username, String password);
    }
}
