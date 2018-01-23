package a7315.jd.a7315.Contracts;

/**
 * Created by Jesse on 1/23/2018.
 */

public interface ContractRegister {
    interface View {

    }

    interface Presenter {
        boolean register(String username, String password);
    }
}
