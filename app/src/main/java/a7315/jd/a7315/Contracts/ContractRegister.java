package a7315.jd.a7315.Contracts;

/**
 * Created by Jesse on 1/23/2018.
 */

public interface ContractRegister {
    interface View {
        /**
         * This is called when a register is completed. Normally, this may log in the user and
         * moves to the Home Activity.
         */
        void onRegisterComplete();

        /**
         * This is called when a login request is made.
         */
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
