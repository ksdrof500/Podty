package podcast.com.br.podtche.view;

/**
 * Created by fenrir on 15/03/16.
 */
public interface LoginView {
    void displayInsertMsisdn();
    void displaySmsReceiver(String msisdn);
    void displayInsertPin(String msisdn, String expectedPin);
    void displayCongratulations();
    void displaySubscriptionPendingMessage();
    void displayInvalidNumberError();
    void displayInvalidPinError();
    void displayProgress();
    void hideProgress();
    void setOkResult();
    void setCancelResult();
    void close();
}
