package a7315.jd.a7315.Contracts;

/**
 * Created by Jesse on 1/23/2018.
 */

public interface ContractLogin {
    interface View {
        /**
         * This function is called on a successful login. Normally, this should create a new Home
         * Activity, but it may lead to other things such as a temporary server down screen or
         * similar.
         */
        void onSuccessfulLogin();
        /**
         * This function is called on a failed login. This can be used to notify the user that the
         * login has failed.
         */
        void onFailedLogin();

        /**
         * This function is called when a register request is made.
         */
        void onRegisterRequest();
    }

    interface Presenter {
        /**
         * Checks whether given credentials are valid
         * @param username A username
         * @param password A password
         * @return True if credentials are valid, false otherwise
         */
        boolean login(String username, String password);
    }
}
