package by.vorokhobko.model;

/**
 * Account.
 *
 * Class Account creates account for users.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 04.05.2019.
 * @version 1.
 */
public class Account {
    /**
     * The class field.
     */
    private int accountId;
    /**
     * The class field.
     */
    private int account;
    /**
     * The class field.
     */
    private int userId;
    /**
     * Add constructor.
     * @param account - account.
     * @param userId - userId.
     */
    public Account(int account, int userId) {
        this.account = account;
        this.userId = userId;
    }
    /**
     * Add getter accountId.
     * @return tag.
     */
    public int getAccountId() {
        return accountId;
    }
    /**
     * Add setter accountId.
     * @param accountId - accountId.
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    /**
     * Add getter account.
     * @return tag.
     */
    public int getAccount() {
        return account;
    }
    /**
     * Add setter account.
     * @param account - account.
     */
    public void setAccount(int account) {
        this.account = account;
    }
    /**
     * Add getter userId.
     * @return tag.
     */
    public int getUserId() {
        return userId;
    }
    /**
     * Add setter userId.
     * @param userId - userId.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /**
     * Add override method toString.
     * @return tag.
     */
    @Override
    public String toString() {
        return "Account{"
                + "accountId=" + accountId
                + ", account=" + account
                + ", userId=" + userId
                + '}';
    }
}
