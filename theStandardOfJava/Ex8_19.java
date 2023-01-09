package theStandardOfJava;

public class Ex8_19 {

    public static void main(String[] args) {
        try {
            install();
        } catch (InstallException2 e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static void install() throws InstallException2 {
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException2 e) {
            InstallException2 ie = new InstallException2("설치 중 예외 발생 @@");
            ie.initCause(e);
            throw ie;
        } catch (MemoryException2 me) {
            InstallException2 ie = new InstallException2("설치 중 예외 발생");
            ie.initCause(ie);
            throw ie;
        } finally {
            deleteTempFiles();
        }
    }

    static void startInstall() throws SpaceException2, MemoryException2 {
        if(!enoughSpace()) {
            throw new SpaceException2("설치할 공간이 부족합니다.");
        }
        if(!enoughMemory()) {
            throw new MemoryException2("메모리가 부족합니다.");
        }
    }   
    
    static void copyFiles(){}
    static void deleteTempFiles(){}

    static boolean enoughSpace(){
        return false;
    }

    static boolean enoughMemory(){
        return true;
    }
}



class InstallException2 extends Exception {
    InstallException2(String msg) {
        super(msg);
    }
}

class SpaceException2 extends Exception {
    SpaceException2(String msg) {
        super(msg);
    }
}

class MemoryException2 extends Exception {
    MemoryException2(String msg) {
        super(msg);
    }
}
