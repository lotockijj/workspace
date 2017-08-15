package MindCastr.persistent;

import MindCastr.panels.LoginWindow;

import java.io.File;
import java.io.IOException;

public interface Membership {
    public boolean check();

    public class Fork implements Membership {
        private final String file;

        public Fork(String file) {
            this.file = file;
        }

        @Override
        public boolean check() {
            if (!new FileCheck(this.file).check()){
                return LoginWindow.getInstance().check();
            } else {
                return true;
            }
        }
    }

    class FileCheck implements Membership{
        private String file;

        public FileCheck(String file) {
            this.file = file;
        }

        @Override
        public boolean check() {
            return new File(this.file).exists();
        }

    }
}

