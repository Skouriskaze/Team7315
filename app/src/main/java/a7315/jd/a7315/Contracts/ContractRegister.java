package a7315.jd.a7315.Contracts;

/**
 * Created by Jesse on 1/23/2018.
 */

public interface ContractRegister {
    interface View {
        void onRegisterComplete();
        void onLoginRequest();

    }

    interface Presenter {
        /**
         * Registers a user
         * @param username The user's username
         * @param password The user's password
         * @return true if registration is successful
         */
        boolean register(String username, String password);
    }
}
