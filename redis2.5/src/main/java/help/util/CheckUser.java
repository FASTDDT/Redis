package help.util;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * <p>
 * Discription
 * </p>
 *
 * @author father
 * @ClassName CheckUser
 * @since 2018/12/14 20:45
 */
public class CheckUser {
    public static String getUserId(){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("CheckUser"+username);
        return username;
    }
    public static boolean checkOwn(String username){
        return getUserId().equals(username);
    }
}
