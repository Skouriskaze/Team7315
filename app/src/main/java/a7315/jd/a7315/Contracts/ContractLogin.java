package a7315.jd.a7315.Contracts;

/**
 * Created by Jesse on 1/23/2018.
 */

public interface ContractLogin {
    interface View {
        void onSuccessfulLogin();
        void onFailedLogin();
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
