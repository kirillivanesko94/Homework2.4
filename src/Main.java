
public class Main {
    public static void main(String[] args) {
        String login = "Qsd123_";
        String password = "Qsd123_";
        String confirmPassword = "Qsd123_";
        isValidPassword(login, password, confirmPassword);
    }
    public static boolean isValidPassword(String login, String password, String confirmPassword) {
        try {
            сheckLogin(login);
            сheckPassword(password);
            сheckPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Не верный формат логина");
        } catch (WrongPasswordException e) {
            System.out.println("Не верный формат пароля");
        } finally {
            System.out.println("Проверка пароля завершена");
        }
        return false;
    }

    public static void сheckLogin(String login) throws WrongLoginException {
        String regex = "^[\\w\\d_]+$";
        if (login.matches(regex) && login.length() <= 20) {
            System.out.println("Логин введен корректно");
        } else {
            throw new WrongLoginException();
        }
    }

    public static void сheckPassword(String password) throws WrongPasswordException {
        String regex = "^[\\w\\d_]+$";
        if (password.matches(regex) && password.length() < 20) {
            System.out.println("Пароль введен корректно");
        } else {
            throw new WrongPasswordException();
        }
    }

    public static void сheckPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password.equals(confirmPassword)) {
            System.out.println("Пароль совпадает");
        } else {
            throw new WrongPasswordException();
        }
    }

}