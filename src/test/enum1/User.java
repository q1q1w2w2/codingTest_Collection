package test.enum1;

public class User {
    public static void main(String[] args) {
        Role role = Role.ROLE_USER;
        String roleStr = role.toString();

        System.out.println("role = " + role);
        System.out.println("roleStr = " + roleStr);
    }
}
