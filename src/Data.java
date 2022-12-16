public class Data {
    private static final String VALID_CHARACKTERS="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";
    public Data() {
    }

    public static boolean securityData(String login,
                                   String password,
                                   String confirmPassword) {
        try {
            security(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void security(String login,
                                   String password,
                                   String confirmPassword) throws WrongPasswordException, WrongLoginException {
        if (!validate(login)){
            throw new WrongLoginException("Логин не верный");
        }
        if (!validate(password)){
            throw new WrongPasswordException("Пароль не верный");
        }
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли должны совпадать");
        }



    }
    private static boolean validate (String s){
        if (s.length() > 20) {
            return  false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACKTERS.contains(String.valueOf(s.charAt(i)))){
                return false;
            }
        }
        return true;
    }
}
