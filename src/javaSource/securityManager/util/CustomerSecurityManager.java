package javaSource.securityManager.util;

// 自定义的安全管理器
public class CustomerSecurityManager extends SecurityManager {

    @Override
    public void checkRead(String file) {
//        if (file != null && file.contains("wgx.txt")) {
//            throw new RuntimeException("您还没有读的权限");
//        }
        super.checkRead(file);
    }

    @Override
    public void checkWrite(String file) {
        super.checkWrite(file);
        if (file != null && file.contains("wgx.txt")) {
            throw new RuntimeException("您还没有写的权限");
        }
        super.checkRead(file);
    }
}
