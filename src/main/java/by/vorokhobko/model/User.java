package by.vorokhobko.model;

/**
 * User.
 *
 * Class User creates users for database.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 04.05.2019.
 * @version 1.
 */
public class User {
    /**
     * The class field.
     */
    private int userId;
    /**
     * The class field.
     */
    private String name;
    /**
     * The class field.
     */
    private String superName;
    /**
     * Add constructor.
     * @param name - name.
     * @param superName - superName.
     */
    public User(String name, String superName) {
        this.name = name;
        this.superName = superName;
    }
    /**
     * Add getter id.
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
     * Add getter name.
     * @return tag.
     */
    public String getName() {
        return name;
    }
    /**
     * Add setter name.
     * @param name - name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Add getter superName.
     * @return tag.
     */
    public String getSuperName() {
        return superName;
    }
    /**
     * Add setter superName.
     * @param superName - superName.
     */
    public void setSuperName(String superName) {
        this.superName = superName;
    }
    /**
     * Add override method toString.
     * @return tag.
     */
    @Override
    public String toString() {
        return "User{"
                + "userId=" + userId
                + ", name='" + name + '\''
                + ", superName='" + superName + '\''
                + '}';
    }
}